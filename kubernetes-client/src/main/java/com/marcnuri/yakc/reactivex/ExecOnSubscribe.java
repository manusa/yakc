/*
 * Copyright 2020 Marc Nuri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created on 2020-04-29, 19:56
 */
package com.marcnuri.yakc.reactivex;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ExecMessage;
import com.marcnuri.yakc.api.ExecMessage.StandardStream;
import com.marcnuri.yakc.api.KubernetesException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Marc Nuri on 2020-04-29.
 * @see <a href="https://www.openshift.com/blog/executing-commands-in-pods-using-k8s-api">executing-commands-in-pods-using-k8s-api</a>
 * @see <a href="https://docs.openshift.com/enterprise/3.0/rest_api/kubernetes_v1.html#connect-get-requests-to-exec-of-pod">connect-get-requests-to-exec-of-pod</a>
 */
public class ExecOnSubscribe implements ObservableOnSubscribe<ExecMessage>, Disposable {

  private final Request request;
  private final KubernetesClient kubernetesClient;
  private final AtomicBoolean disposed = new AtomicBoolean(false);
  private AtomicReference<WebSocket> webSocket = new AtomicReference<>(null);

  public ExecOnSubscribe(Request request, KubernetesClient kubernetesClient) {
    this.request = request;
    this.kubernetesClient = kubernetesClient;
  }

  @Override
  public void subscribe(ObservableEmitter<ExecMessage> emitter) throws Exception {
    emitter.setDisposable(this);
    final CountDownLatch cdl = new CountDownLatch(1);
    final HttpUrl updatedUrl = request.url().newBuilder()
      .addQueryParameter("stdout", "true")
      .addQueryParameter("stderr", "true")
      .build();
    final Request updatedRequest = request.newBuilder().url(updatedUrl).build();
    webSocket.set(kubernetesClient.getOkHttpClient().newWebSocket(updatedRequest, new WebSocketListener() {

      @Override
      public void onMessage(WebSocket webSocket, String text) {
        emitter.onNext(ExecMessage.builder().standardStream(StandardStream.STDOUT).message(text).build());
      }

      @Override
      public void onMessage(WebSocket webSocket, ByteString bytes) {
        emitter.onNext(ExecMessage.builder()
          .standardStream(StandardStream.fromByte(bytes.getByte(0)))
          .message(bytes.substring(1).utf8())
          .build());
      }

      @Override
      public void onClosing(WebSocket webSocket, int code, String reason) {
        dispose();
      }

      @Override
      public void onClosed(WebSocket webSocket, int code, String reason) {
        emitter.onComplete();
        close();
      }

      @Override
      public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        final String message = Optional.ofNullable(response)
          .map(Response::body)
          .map(rb -> {
            try {
              return rb.string();
            } catch(IOException ex) {
              return null;
            }
          }).orElse(t.getMessage());
        emitter.onError(new KubernetesException(message, response));
        close();
      }

      private void close() {
        disposed.set(true);
        cdl.countDown();
      }
    }));
    cdl.await();
  }

  @Override
  public void dispose() {
    Optional.ofNullable(webSocket.get()).ifPresent(ws -> ws.close(1000, null));
  }

  @Override
  public boolean isDisposed() {
    return disposed.get();
  }
}

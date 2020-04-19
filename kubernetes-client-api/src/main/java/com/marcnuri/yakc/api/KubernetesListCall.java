package com.marcnuri.yakc.api;

import io.reactivex.Observable;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-04-19.
 */
public interface KubernetesListCall<T, W> extends KubernetesCall<T> {

  Stream<W> stream() throws IOException;

  Observable<WatchEvent<W>> watch() throws KubernetesException;
}

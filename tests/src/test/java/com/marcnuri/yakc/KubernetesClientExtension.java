/*
 * KubernetesClientExtension.java
 *
 * Created on 2020-05-03, 6:53
 */
package com.marcnuri.yakc;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store.CloseableResource;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

/**
 * Created by Marc Nuri on 2020-05-03.
 */
public class KubernetesClientExtension implements BeforeAllCallback, CloseableResource {

  public static KubernetesClient KC;

  @Override
  public synchronized void beforeAll(ExtensionContext context) {
    if (KC == null) {
      KC = new KubernetesClient();
      context.getRoot().getStore(GLOBAL).put("Kubernetes Client Extension finalize callback", this);
    }
  }

  @Override
  public void close() {
    KC.close();
  }
}

/*
 * WatchEvent.java
 *
 * Created on 2020-04-13, 9:36
 */
package com.marcnuri.yakc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-13.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WatchEvent<T> {
  public enum Type {
    ADDED, MODIFIED, DELETED, BOOKMARK, ERROR
  }
  private Type type;
  private T object;
}



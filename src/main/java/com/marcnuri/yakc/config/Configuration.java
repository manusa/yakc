/*
 * Configuration.java
 *
 * Created on 2020-04-11, 12:44
 */
package com.marcnuri.yakc.config;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-11.
 */
@Builder(toBuilder = true)
@Data
public class Configuration {
  private String url;
}

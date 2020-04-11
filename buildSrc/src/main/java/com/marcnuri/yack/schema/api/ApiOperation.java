/*
 * ApiOperation.java
 *
 * Created on 2020-04-10, 13:08
 */
package com.marcnuri.yack.schema.api;

import io.swagger.v3.oas.models.Operation;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
@Builder(toBuilder = true)
@Data
class ApiOperation {
  enum Method {
    DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT, TRACE
  }
  private String tag;
  private String path;
  private Method method;
  private Operation operation;
}

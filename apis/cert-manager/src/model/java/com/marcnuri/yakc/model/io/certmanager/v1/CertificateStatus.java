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
 */

package com.marcnuri.yakc.model.io.certmanager.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Status of the Certificate. This is set and managed automatically.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateStatus implements Model {


  /**
   * List of status conditions to indicate the status of certificates. Known condition types are `Ready` and `Issuing`.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<CertificateStatusConditions> conditions;

  /**
   * LastFailureTime is the time as recorded by the Certificate controller of the most recent failure to complete a CertificateRequest for this Certificate resource. If set, cert-manager will not re-request another Certificate until 1 hour has elapsed from this time.
   */
  @JsonProperty("lastFailureTime")
  private OffsetDateTime lastFailureTime;

  /**
   * The name of the Secret resource containing the private key to be used for the next certificate iteration. The keymanager controller will automatically set this field if the `Issuing` condition is set to `True`. It will automatically unset this field when the Issuing condition is not set or False.
   */
  @JsonProperty("nextPrivateKeySecretName")
  private String nextPrivateKeySecretName;

  /**
   * The expiration time of the certificate stored in the secret named by this resource in `spec.secretName`.
   */
  @JsonProperty("notAfter")
  private OffsetDateTime notAfter;

  /**
   * The time after which the certificate stored in the secret named by this resource in spec.secretName is valid.
   */
  @JsonProperty("notBefore")
  private OffsetDateTime notBefore;

  /**
   * RenewalTime is the time at which the certificate will be next renewed. If not set, no upcoming renewal is scheduled.
   */
  @JsonProperty("renewalTime")
  private OffsetDateTime renewalTime;

  /**
   * The current 'revision' of the certificate as issued. <br><p>  When a CertificateRequest resource is created, it will have the `cert-manager.io/certificate-revision` set to one greater than the current value of this field. <br><p>  Upon issuance, this field will be set to the value of the annotation on the CertificateRequest resource used to issue the certificate. <br><p>  Persisting the value on the CertificateRequest resource allows the certificates controller to know whether a request is part of an old issuance or if it is part of the ongoing revision's issuance by checking if the revision value in the annotation is greater than this field.
   */
  @JsonProperty("revision")
  private Number revision;

}


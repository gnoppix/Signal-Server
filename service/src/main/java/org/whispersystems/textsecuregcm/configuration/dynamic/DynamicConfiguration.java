/*
 * Copyright 2023 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.whispersystems.textsecuregcm.configuration.dynamic;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.whispersystems.textsecuregcm.limits.RateLimiterConfig;

public class DynamicConfiguration {

  @JsonProperty
  @Valid
  private Map<String, DynamicExperimentEnrollmentConfiguration> experiments = Collections.emptyMap();

  @JsonProperty
  @Valid
  private Map<String, DynamicPreRegistrationExperimentEnrollmentConfiguration> preRegistrationExperiments = Collections.emptyMap();

  @JsonProperty
  @Valid
  private Map<String, RateLimiterConfig> limits = new HashMap<>();

  @JsonProperty
  @Valid
  private DynamicRemoteDeprecationConfiguration remoteDeprecation = new DynamicRemoteDeprecationConfiguration();

  @JsonProperty
  @Valid
  private DynamicPaymentsConfiguration payments = new DynamicPaymentsConfiguration();

  @JsonProperty
  @Valid
  private DynamicCaptchaConfiguration captcha = new DynamicCaptchaConfiguration();

  @JsonProperty
  @Valid
  private DynamicPushLatencyConfiguration pushLatency = new DynamicPushLatencyConfiguration(Collections.emptyMap());

  @JsonProperty
  @Valid
  private DynamicTurnConfiguration turn = new DynamicTurnConfiguration();

  @JsonProperty
  @Valid
  DynamicMessagePersisterConfiguration messagePersister = new DynamicMessagePersisterConfiguration();

  @JsonProperty
  @Valid
  DynamicRateLimitPolicy rateLimitPolicy = new DynamicRateLimitPolicy(false);

  @JsonProperty
  @Valid
  DynamicECPreKeyMigrationConfiguration ecPreKeyMigration = new DynamicECPreKeyMigrationConfiguration(true, false);

  @JsonProperty
  @Valid
  DynamicDeliveryLatencyConfiguration deliveryLatency = new DynamicDeliveryLatencyConfiguration(Collections.emptyMap());

  public Optional<DynamicExperimentEnrollmentConfiguration> getExperimentEnrollmentConfiguration(
      final String experimentName) {
    return Optional.ofNullable(experiments.get(experimentName));
  }

  public Optional<DynamicPreRegistrationExperimentEnrollmentConfiguration> getPreRegistrationEnrollmentConfiguration(
      final String experimentName) {
    return Optional.ofNullable(preRegistrationExperiments.get(experimentName));
  }

  public Map<String, RateLimiterConfig> getLimits() {
    return limits;
  }

  public DynamicRemoteDeprecationConfiguration getRemoteDeprecationConfiguration() {
    return remoteDeprecation;
  }

  public DynamicPaymentsConfiguration getPaymentsConfiguration() {
    return payments;
  }

  public DynamicCaptchaConfiguration getCaptchaConfiguration() {
    return captcha;
  }

  public DynamicPushLatencyConfiguration getPushLatencyConfiguration() {
    return pushLatency;
  }

  public DynamicTurnConfiguration getTurnConfiguration() {
    return turn;
  }

  public DynamicMessagePersisterConfiguration getMessagePersisterConfiguration() {
    return messagePersister;
  }

  public DynamicRateLimitPolicy getRateLimitPolicy() {
    return rateLimitPolicy;
  }

  public DynamicECPreKeyMigrationConfiguration getEcPreKeyMigrationConfiguration() {
    return ecPreKeyMigration;
  }

  public DynamicDeliveryLatencyConfiguration getDeliveryLatencyConfiguration() {
    return deliveryLatency;
  }
}

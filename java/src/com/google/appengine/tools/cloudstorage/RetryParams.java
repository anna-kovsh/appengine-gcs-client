// Copyright 2012 Google Inc. All Rights Reserved.
package com.google.appengine.tools.cloudstorage;

import java.io.Serializable;

/**
 * Parameters for configuring exponential backoff. See {@link RetryHelper}. The initial request is
 * executed immediately. It is given {@link #requestTimeoutMillis} to complete or it is regarded as
 * a failure. If the request fails the calling thread sleeps for {@link #initialRetryDelayMillis}.
 * Each subsequent failure the sleep interval is calculated as at least half of and no more than:
 *
 * <pre>
 *{@link #initialRetryDelayMillis} * {@link #retryDelayBackoffFactor} ^ NumFailures
 *</pre>
 *
 * This proceeds until either the request is successful, {@link #retryMaxAttempts} are made, or both
 * {@link #retryMinAttempts} are made and {@link #retryPeriodMillis} have elapsed.
 *
 */
class RetryParams implements Serializable {
  private static final long serialVersionUID = -8492751576749007700L;

  private static final long DEFAULT_REQUEST_TIMEOUT_MILLIS = 5000;
  private static final int DEFAULT_RETRY_MIN_ATTEMPTS = 5;
  private static final int DEFAULT_RETRY_MAX_ATTEMPTS = 10;
  private static final long DEFAULT_INITIAL_RETRY_DELAY_MILLIS = 10;
  private static final long DEFAULT_MAX_RETRY_DELAY_MILLIS = 10 * 1000;
  private static final double DEFAULT_RETRY_DELAY_BACKOFF_FACTOR = 2;
  private static final long DEFAULT_RETRY_PERIOD_MILLIS = 30 * 1000;

  private long requestTimeoutMillis = DEFAULT_REQUEST_TIMEOUT_MILLIS;
  private int retryMinAttempts = DEFAULT_RETRY_MIN_ATTEMPTS;
  private int retryMaxAttempts = DEFAULT_RETRY_MAX_ATTEMPTS;
  private long initialRetryDelayMillis = DEFAULT_INITIAL_RETRY_DELAY_MILLIS;
  private long maxRetryDelayMillis = DEFAULT_MAX_RETRY_DELAY_MILLIS;
  private double retryDelayBackoffFactor = DEFAULT_RETRY_DELAY_BACKOFF_FACTOR;
  private long retryPeriodMillis = DEFAULT_RETRY_PERIOD_MILLIS;

  /**
   * @return the retryMinAttempts
   */
  public int getRetryMinAttempts() {
    return retryMinAttempts;
  }

  /**
   * @param retryMinAttempts the retryMinAttempts to set
   */
  public void setRetryMinAttempts(int retryMinAttempts) {
    this.retryMinAttempts = retryMinAttempts;
  }

  /**
   * @return the retryMaxAttempts
   */
  public int getRetryMaxAttempts() {
    return retryMaxAttempts;
  }

  /**
   * @param retryMaxAttempts the retryMaxAttempts to set
   */
  public void setRetryMaxAttempts(int retryMaxAttempts) {
    this.retryMaxAttempts = retryMaxAttempts;
  }

  /**
   * @return the initialRetryDelayMillis
   */
  public long getInitialRetryDelayMillis() {
    return initialRetryDelayMillis;
  }

  /**
   * @param initialRetryDelayMillis the initialRetryDelayMillis to set
   */
  public void setInitialRetryDelayMillis(long initialRetryDelayMillis) {
    this.initialRetryDelayMillis = initialRetryDelayMillis;
  }

  /**
   * @return the maxRetryDelayMillis
   */
  public long getMaxRetryDelayMillis() {
    return maxRetryDelayMillis;
  }

  /**
   * @param maxRetryDelayMillis the maxRetryDelayMillis to set
   */
  public void setMaxRetryDelayMillis(long maxRetryDelayMillis) {
    this.maxRetryDelayMillis = maxRetryDelayMillis;
  }

  /**
   * @return the maxRetryDelayBackoffFactor
   */
  public double getRetryDelayBackoffFactor() {
    return retryDelayBackoffFactor;
  }

  /**
   * @param retryDelayBackoffFactor the retryDelayBackoffFactor to set
   */
  public void setRetryDelayBackoffFactor(double retryDelayBackoffFactor) {
    this.retryDelayBackoffFactor = retryDelayBackoffFactor;
  }

  /**
   * @return the retryPeriodMillis
   */
  public long getRetryPeriodMillis() {
    return retryPeriodMillis;
  }

  /**
   * @param retryPeriodMillis the retryPeriodMillis to set
   */
  public void setRetryPeriodMillis(long retryPeriodMillis) {
    this.retryPeriodMillis = retryPeriodMillis;
  }

  /**
   * @return the requestTimeoutMillis
   */
  public long getRequestTimeoutMillis() {
    return requestTimeoutMillis;
  }

  /**
   * @param requestTimeoutMillis the requestTimeoutMillis to set
   */
  public void setRequestTimeoutMillis(long requestTimeoutMillis) {
    this.requestTimeoutMillis = requestTimeoutMillis;
  }
}

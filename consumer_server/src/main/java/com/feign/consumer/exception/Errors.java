package com.feign.consumer.exception;

/**
 * @Author LittleCadet
 * @Date 2020/2/14
 */
public interface Errors {
    Integer getCode();

    String getErrorCode();

    String getErrorMessage();
}

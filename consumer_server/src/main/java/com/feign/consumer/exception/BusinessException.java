package com.feign.consumer.exception;


/**
 * @Author LittleCadet
 * @Date 2020/2/14
 */
public class BusinessException extends RuntimeException implements Errors
{
    private String errorCode;
    private String errorMessage;
    private int code;

    public BusinessException(int code, String errorCode, String errorMessage) {
        super(errorCode + ":" + errorMessage);
        this.code = code;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(int code, String errorCode, String errorMessage, Exception e) {
        super(errorCode + ":" + errorMessage, e);
        this.code = code;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(Errors errors) {
        this(errors.getCode(), errors.getErrorCode(), errors.getErrorMessage());
    }

    public BusinessException(Errors errors, Exception e) {
        this(errors.getCode(), errors.getErrorCode(), errors.getErrorMessage(), e);
    }

    public BusinessException(Errors errors, Object... args) {
        this(errors.getCode(), errors.getErrorCode(), String.format(errors.getErrorMessage(), args));
    }

    public Integer getCode() {
        return this.code;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}

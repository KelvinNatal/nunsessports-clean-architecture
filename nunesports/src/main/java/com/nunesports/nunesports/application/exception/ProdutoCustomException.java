package com.nunesports.nunesports.application.exception;

public class ProdutoCustomException extends RuntimeException {
    public ProdutoCustomException() {
    }
    public ProdutoCustomException(String message) {
        super(message);
    }
    public ProdutoCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

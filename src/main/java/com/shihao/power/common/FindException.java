package com.shihao.power.common;

public class FindException extends RuntimeException {

    private static final long serialVersionUID = 18794756827824687L;

    public FindException() {
        super();
    }

    public FindException(String message) {
        super(message);
    }

    public FindException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindException(Throwable cause) {
        super(cause);
    }

    protected FindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

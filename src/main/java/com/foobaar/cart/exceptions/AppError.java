package com.foobaar.cart.exceptions;

public class AppError {
    private int httpStatus;
    private String errorMessage;
    private String appErrorCode;
    private String errorId;

    public AppError(final int httpStatus, final String errorMessage,
                    final String appErrorCode, final String errorId) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.appErrorCode = appErrorCode;
        this.errorId = errorId;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getAppErrorCode() {
        return appErrorCode;
    }

    public String getErrorId() {
        return errorId;
    }

}

package com.anand.order_service.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;

    public ErrorResponse(String failure, int i, LocalDateTime now) {
        this.message=failure;
        this.status=i;
        this.timestamp=now;
    }
}

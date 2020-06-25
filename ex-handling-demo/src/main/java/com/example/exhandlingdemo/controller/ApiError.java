package com.example.exhandlingdemo.controller;

import lombok.Data;

@Data
public class ApiError {

    private String reason;
    private String defMessage;

    public ApiError() {
    }

    public ApiError(String reason, String defMessage) {
        this.reason = reason;
        this.defMessage = defMessage;
    }
}

package com.some.demo.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SomeError {
    final HttpStatus badRequest;
    final Integer code;
    final List<String> errors;
    final String uri;
    final LocalDateTime timestamp;

    public SomeError(final HttpStatus badRequest, LocalDateTime timestamp, final String uri, final List<String> errors) {
        this.badRequest = badRequest;
        this.errors = errors;
        this.code = badRequest.value();
        this.uri = uri;
        this.timestamp = timestamp;
    }
}

package com.hackaton.backend.v1.core.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidOperationException extends RuntimeException {
    public String message;
}

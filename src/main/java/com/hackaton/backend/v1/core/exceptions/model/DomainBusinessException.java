package com.hackaton.backend.v1.core.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainBusinessException extends RuntimeException {
    public String message;
}

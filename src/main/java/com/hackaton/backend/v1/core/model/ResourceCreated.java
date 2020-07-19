package com.hackaton.backend.v1.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ResourceCreated implements Serializable {
    private Long id;

    public ResourceCreated(Long id) {
    }
}

package io.airow.core.domain;

public record Type(String value) {
    public Type {
        if (value == null) {
            throw new IllegalArgumentException("type can not be null");
        }
    }
}

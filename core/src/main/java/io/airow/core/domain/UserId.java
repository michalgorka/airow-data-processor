package io.airow.core.domain;

public record UserId(String value) {
    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("userId can not be null");
        }
    }
}

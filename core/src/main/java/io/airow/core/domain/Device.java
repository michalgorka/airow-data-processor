package io.airow.core.domain;

public record Device(String value) {
    public Device {
        if (value == null) {
            throw new IllegalArgumentException("device can not be null");
        }
    }
}

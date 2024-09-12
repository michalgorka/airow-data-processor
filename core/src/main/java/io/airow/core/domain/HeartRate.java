package io.airow.core.domain;

public record HeartRate(String key, int value) {
    public HeartRate {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key can not be empty");
        }
    }
}

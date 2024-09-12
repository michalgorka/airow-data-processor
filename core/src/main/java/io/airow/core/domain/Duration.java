package io.airow.core.domain;

public record Duration(long value, TimeUnit timeUnit) {
    public Duration {
        if (value < 0) {
            throw new IllegalArgumentException("Duration can not be less than 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("TimeUnit can not be null");
        }
    }
}

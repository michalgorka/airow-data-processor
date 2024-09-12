package io.airow.core.domain;

public record StartTime(int value, TimeUnit unit) {
    public StartTime(int value, TimeUnit unit) {
        this.value = value;
        this.unit = unit;

        if (this.value < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0");
        }

        if (this.unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
    }
}

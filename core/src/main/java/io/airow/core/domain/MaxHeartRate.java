package io.airow.core.domain;

public record MaxHeartRate(int value) {
    public MaxHeartRate {
        if (value < 0) {
            throw new IllegalArgumentException("HeartRate can not be less than 0");
        }
    }
}

package io.airow.core.domain;

public record Distance(int distance, DistanceUnit distanceUnit) {
    public Distance {
        if (distance < 0) {
            throw new IllegalArgumentException("distance cannot be less than 0");
        }

        if (distanceUnit == null) {
            throw new IllegalArgumentException("distanceUnit cannot be null");
        }
    }

    public int getValueInMeters() {
        return distance;
    }
}

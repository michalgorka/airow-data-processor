package io.airow.core.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Lap {
    private final StartTime startTime;
    private final Distance distance;
    private final Duration duration;
    private final List<HeartRate> heartRateList = new ArrayList<>();

    public Lap(StartTime startTime, Distance distance, Duration duration) {
        this.startTime = startTime;
        this.distance = distance;
        this.duration = duration;

        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }

        if (distance == null) {
            throw new IllegalArgumentException("Distance cannot be null");
        }

        if (duration == null) {
            throw new IllegalArgumentException("Duration cannot be null");

        }
    }

    public void add(HeartRate heartRate) {
        if (heartRate == null) {
            throw new IllegalArgumentException("HeartRate cannot be null");
        }
        heartRateList.add(heartRate);
    }
}

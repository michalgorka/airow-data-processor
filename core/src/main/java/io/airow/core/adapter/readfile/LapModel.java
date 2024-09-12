package io.airow.core.adapter.readfile;

import lombok.Getter;

@Getter
public class LapModel {
    private int startTimeInSeconds;
    private int airTemperatureCelsius;
    private int heartRate;
    private int totalDistanceInMeters;
    private int timerDurationInSeconds;
}

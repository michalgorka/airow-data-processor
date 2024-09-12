package io.airow.core.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Metadata {
    private final int numberOfLaps;
    private final Distance totalDistance;
    private final boolean allLapsContainsHearthRateSamples;
    private final boolean heartRelatesContainsValidData;

    public Metadata(List<Lap> laps) {
        numberOfLaps = laps.size();
        totalDistance = new Distance(laps.stream().mapToInt(lap -> lap.getDistance().getValueInMeters()).sum(), DistanceUnit.METERS);
        allLapsContainsHearthRateSamples = laps.stream().noneMatch(lap -> lap.getHeartRateList().isEmpty());
        heartRelatesContainsValidData = laps.stream()
                .flatMap(lap -> lap.getHeartRateList().stream())
                .map(HeartRate::value)
                .filter(hearthRate -> hearthRate == -1)
                .findFirst()
                .isEmpty();
    }
}

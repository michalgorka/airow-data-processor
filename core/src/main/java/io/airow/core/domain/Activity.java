package io.airow.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Activity {
    private final UserId userId;
    private final Type type;
    private final MaxHeartRate maxHeartRate;
    private final Duration duration;
    private final List<Lap> laps = new ArrayList<>();

    public void addLap(Lap lap) {
        if (lap == null) {
            throw new IllegalArgumentException("lap can not be null");
        }

        laps.add(lap);
    }

    @JsonProperty("activityMetaData")
    public Metadata generateMetadata() {
        return new Metadata(laps);
    }
}

package io.airow.core.adapter.readfile;

import lombok.Getter;

@Getter
public class SummaryModel {
    private String userId;
    private long activityId;
    private String activityName;
    private int durationInSeconds;
    private int startTimeInSeconds;
    private int startTimeOffsetInSeconds;
    private String activityType;
    private int averageHeartRateInBeatsPerMinute;
    private int activeKilocalories;
    private String deviceName;
    private int maxHeartRateInBeatsPerMinute;
}

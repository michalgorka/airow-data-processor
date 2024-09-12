package io.airow.core.adapter.readfile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SampleModel {
    @JsonProperty("recording-rate")
    private int recordingRate;
    @JsonProperty("sample-type")
    private String sampleType;
    private String data;
}

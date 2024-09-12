package io.airow.core;

import io.airow.core.adapter.readfile.LapModel;
import io.airow.core.adapter.readfile.SampleModel;
import io.airow.core.adapter.readfile.SummaryModel;
import io.airow.core.domain.*;

import java.util.*;
import java.util.stream.IntStream;

class Context {
    private final ContextId contextId;
    private SummaryModel summaryModel;
    private List<LapModel> lapModel;
    private List<SampleModel> sampleModel;

    Context() {
        this.contextId = new ContextId();
    }

    ContextId getContextKey() {
        return contextId;
    }

    public void loadSummary(SummaryModel summary) {
        if (summary == null) {
            throw new IllegalArgumentException("summary can not be null");
        }
        this.summaryModel = summary;
    }

    public void loadLaps(List<LapModel> lapModel) {
        if (lapModel == null) {
            throw new IllegalArgumentException("lapsModel can not be null");
        }
        this.lapModel = lapModel;
    }

    public void loadSamples(List<SampleModel> sampleModel) {
        if (sampleModel == null) {
            throw new IllegalArgumentException("samplesModel can not be null");
        }
        this.sampleModel = sampleModel;
    }


    public Activity process() {
        if (lapModel == null) {
            throw new IllegalStateException("laps model is not loaded");
        }
        if (summaryModel == null) {
            throw new IllegalStateException("summary model is not loaded");
        }
        if (sampleModel == null) {
            throw new IllegalStateException("sample model is not loaded");
        }

        var activity = new Activity(
                new UserId(summaryModel.getUserId()),
                new Type(summaryModel.getActivityType()),
                new MaxHeartRate(summaryModel.getMaxHeartRateInBeatsPerMinute()),
                new Duration(summaryModel.getDurationInSeconds(), TimeUnit.SECONDS)
        );

        Map<Integer, List<String>> samples;
        if (activity.getType().value().equals("INDOOR_CYCLING")) {
            samples = indoorCyclingSampleProcessor();
        } else {
            samples = new HashMap<>();
        }

        int lapNumber = 0;
        for (LapModel lapModel : lapModel) {
            lapNumber++;
            var lap = new Lap(
              new StartTime(lapModel.getStartTimeInSeconds(), TimeUnit.SECONDS),
                    new Distance(lapModel.getTotalDistanceInMeters(), DistanceUnit.METERS),
                    new Duration(lapModel.getTimerDurationInSeconds(), TimeUnit.SECONDS)
            );

            if (samples.containsKey(lapNumber)) {
                var sample = samples.get(lapNumber);
                IntStream.range(0, sample.size())
                        .forEach(sampleArrayIndex -> {
                                var heartRatesString = sample.get(sampleArrayIndex);
                                var heartRates = heartRatesString.split(",");
                                IntStream.range(0, heartRates.length)
                                        .forEach(index -> lap.add(new HeartRate(String.format("%d-%d", sampleArrayIndex, index), tryConvertToIntOrDefault(heartRates[index]))));

                        });
            }

            activity.addLap(lap);
        }

        return activity;
    }

    private Map<Integer, List<String>> indoorCyclingSampleProcessor() {
        var samples = new HashMap<Integer, List<String>>();
        int sampleIndex = 0;
        for (SampleModel sampleModel : sampleModel) {
            if (Objects.equals(sampleModel.getSampleType(), "0")) {
                sampleIndex++;
                samples.put(sampleIndex, new ArrayList<>());
            }
            if (Objects.equals(sampleModel.getSampleType(), "2")) {
                samples.get(sampleIndex).add(sampleModel.getData());
            }
        }
        return samples;
    }

    private int tryConvertToIntOrDefault(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}

package io.airow.core;

import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Summary, sample or laps file url missing");
        }
        var summaryPath = args[0];
        var samplePath = args[1];
        var lapsPath = args[2];

        var dataProcessor = new DataProcessor();
        var contextId = dataProcessor.createProcessContext();

        dataProcessor.loadSummary(contextId, new File(summaryPath));
        dataProcessor.loadSample(contextId, new File(samplePath));
        dataProcessor.loadLaps(contextId, new File(lapsPath));

        var result = dataProcessor.process(contextId);
        System.out.println(result);
    }
}

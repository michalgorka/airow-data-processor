package io.airow.core;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataProcessorTest {

    private final DataProcessor dataProcessor = new DataProcessor();

    @Test
    void shouldLoadSummary() throws IOException {
        //given
        var contextId = dataProcessor.createProcessContext();
        var file = new File(getClass().getClassLoader().getResource("summary.json").getFile());

        //when
        dataProcessor.loadSummary(contextId, file);
    }

    @Test
    void shouldLoadSamples() throws IOException {
        //given
        var contextId = dataProcessor.createProcessContext();
        var file = new File(getClass().getClassLoader().getResource("samples.json").getFile());

        //when
        dataProcessor.loadSample(contextId, file);
    }

    @Test
    void shouldLoadLaps() throws IOException {
        //given
        var contextId = dataProcessor.createProcessContext();
        var file = new File(getClass().getClassLoader().getResource("laps.json").getFile());

        //when
        dataProcessor.loadLaps(contextId, file);
    }

    @Test
    void shouldProcess() throws IOException {
        //given
        var contextId = dataProcessor.createProcessContext();
        var lapsFile = new File(getClass().getClassLoader().getResource("laps.json").getFile());
        var summaryFile = new File(getClass().getClassLoader().getResource("summary.json").getFile());
        var samplesFile = new File(getClass().getClassLoader().getResource("samples.json").getFile());
        var expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("expected.json").getFile())));


        dataProcessor.loadLaps(contextId, lapsFile);
        dataProcessor.loadSummary(contextId, summaryFile);
        dataProcessor.loadSample(contextId, samplesFile);


        //when
        var result = dataProcessor.process(contextId);

        //then
        assertEquals(expected, result);
    }
}
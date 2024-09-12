package io.airow.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import io.airow.core.adapter.readfile.LapModel;
import io.airow.core.adapter.readfile.SampleModel;
import io.airow.core.adapter.readfile.SummaryModel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor {

    private final Map<ContextId, Context> contextMap = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ContextId createProcessContext() {
        var context = new Context();
        contextMap.put(context.getContextKey(), context);
        return context.getContextKey();
    }

    public void loadSummary(ContextId contextId, File file) throws IOException {
        try {
            var summary = objectMapper.readValue(file, SummaryModel.class);
            contextMap.get(contextId).loadSummary(summary);
        } catch (MismatchedInputException e) {
            throw new IllegalArgumentException("Invalid summary json in file: " + file.getAbsolutePath(), e);
        }
    }

    public void loadLaps(ContextId contextId, File file) throws IOException {
        try {
            var lapsModel = objectMapper.readValue(file, new TypeReference<List<LapModel>>(){});
            contextMap.get(contextId).loadLaps(lapsModel);
        } catch (MismatchedInputException e) {
            throw new IllegalArgumentException("Invalid laps json in file: " + file.getAbsolutePath(), e);
        }
    }

    public void loadSample(ContextId contextId, File file) throws IOException {
        try {
            var samplesModel = objectMapper.readValue(file, new TypeReference<List<SampleModel>>(){});
            contextMap.get(contextId).loadSamples(samplesModel);
        } catch (MismatchedInputException e) {
            throw new IllegalArgumentException("Invalid sample json in file: " + file.getAbsolutePath(), e);
        }
    }

    public String process(ContextId contextId) throws JsonProcessingException {
        var result = contextMap.get(contextId).process();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }
}

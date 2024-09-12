package io.airow.core;

import io.airow.core.adapter.readfile.LapModel;
import io.airow.core.adapter.readfile.SampleModel;
import io.airow.core.adapter.readfile.SummaryModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ContextTest {

    private final Context context = new Context();

    @Test
    void shouldCreateContext() {
        //when
        var context = new Context();

        //then
        assertNotNull(context);
        assertNotNull(context.getContextKey());
    }

    @Test
    void shouldLoadSummaryThrowException_whenSummaryModelIsNull() {
        //given
        var context = new Context();

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> context.loadSummary(null));

        //then
        assertEquals("summary can not be null", ex.getMessage());
    }

    @Test
    void shouldLoadLapsThrowException_whenLapsModelIsNull() {
        //given
        var context = new Context();

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> context.loadLaps(null));

        //then
        assertEquals("lapsModel can not be null", ex.getMessage());
    }

    @Test
    void shouldLoadSamplesThrowException_whenSamplesModelIsNull() {
        //given
        var context = new Context();

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> context.loadSamples(null));

        //then
        assertEquals("samplesModel can not be null", ex.getMessage());
    }

    @Test
    void shouldProcessThrowException_whenSummaryModelIsNull() {
        //given
        var context = new Context();
        context.loadLaps(List.of(mock(LapModel.class)));
        context.loadSamples(List.of(mock(SampleModel.class)));

        //when
        var ex = assertThrows(IllegalStateException.class, () -> context.process());

        //then
        assertEquals("summary model is not loaded", ex.getMessage());
    }

    @Test
    void shouldProcessThrowException_whenLapsModelIsNull() {
        //given
        var context = new Context();
        context.loadSummary(mock(SummaryModel.class));
        context.loadSamples(List.of(mock(SampleModel.class)));

        //when
        var ex = assertThrows(IllegalStateException.class, () -> context.process());

        //then
        assertEquals("laps model is not loaded", ex.getMessage());
    }

    @Test
    void shouldProcessThrowException_whenSamplesModelIsNull() {
        //given
        var context = new Context();
        context.loadSummary(mock(SummaryModel.class));
        context.loadLaps(List.of(mock(LapModel.class)));

        //when
        var ex = assertThrows(IllegalStateException.class, () -> context.process());

        //then
        assertEquals("sample model is not loaded", ex.getMessage());
    }
}
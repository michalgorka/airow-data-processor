package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LapTest {

    @Test
    void shouldThrowException_whenStartTimeIsNull() {
        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new Lap(null, new Distance(1, DistanceUnit.METERS), new Duration(2, TimeUnit.SECONDS)));

        //then
        assertEquals("Start time cannot be null", ex.getMessage());
    }


    @Test
    void shouldThrowException_whenDistanceIsNull() {
        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new Lap(new StartTime(2, TimeUnit.SECONDS), null, new Duration(2, TimeUnit.SECONDS)));

        //then
        assertEquals("Distance cannot be null", ex.getMessage());
    }

    @Test
    void shouldThrowException_whenDurationIsNull() {
        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new Lap(new StartTime(2, TimeUnit.SECONDS), new Distance(1, DistanceUnit.METERS), null));

        //then
        assertEquals("Duration cannot be null", ex.getMessage());
    }
}
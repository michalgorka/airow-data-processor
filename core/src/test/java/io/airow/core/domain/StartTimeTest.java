package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartTimeTest {

    @Test
    void shouldThrowException_whenStartTimeIsLessThanZero() {
        //given
        var startTime = -1;
        var timeUnit = TimeUnit.SECONDS;

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new StartTime(startTime, timeUnit));

        //then
        assertEquals("Value cannot be less than 0", ex.getMessage());
    }

    @Test
    void shouldThrowException_whenTimeUnitIsNull() {
        //given
        var startTime = 1;

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new StartTime(startTime, null));

        //then
        assertEquals("Unit cannot be null", ex.getMessage());
    }
}
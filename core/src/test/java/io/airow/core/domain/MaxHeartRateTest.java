package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeartRateTest {

    @Test
    void shouldCreateMaxHeartRate() {
        //given
        var heartRate = 100;

        //when
        var result = new MaxHeartRate(heartRate);

        //then
        assertNotNull(result);
        assertEquals(heartRate, result.value());
    }

    @Test
    void shouldNotCreateMaxHeartRate_whenValueIsLessThanZero() {
        //given
        var heartRate = -1;

        //when
        var throwable = assertThrows(IllegalArgumentException.class, () -> new MaxHeartRate(heartRate));

        //then
        assertEquals("HeartRate can not be less than 0", throwable.getMessage());
    }
}
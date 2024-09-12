package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void shouldThrowException_whenDistanceLessThanZero() {
        //given
        var distance = -1;
        var unit = DistanceUnit.METERS;

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new Distance(distance, unit));

        //then
        assertEquals("distance cannot be less than 0", ex.getMessage());
    }

    @Test
    void shouldThrowException_whenUnitIsNull() {
        //given
        var distance = 100;

        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new Distance(distance, null));

        //then
        assertEquals("distanceUnit cannot be null", ex.getMessage());
    }
}
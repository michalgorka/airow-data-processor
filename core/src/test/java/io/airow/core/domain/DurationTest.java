package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationTest {
    
    @Test
    void shouldCreateDuration() {
        //given
        var duration = 100;

        //when
        var result = new Duration(duration, TimeUnit.SECONDS);

        //then
        assertNotNull(result);
        assertEquals(duration, result.value());
    }

    @Test
    void shouldNotCreateDuration_whenValueIsLessThanZero() {
        //given
        var duration = -1;

        //when
        var throwable = assertThrows(IllegalArgumentException.class, () -> new Duration(duration, TimeUnit.SECONDS));

        //then
        assertEquals("Duration can not be less than 0", throwable.getMessage());
    }

    @Test
    void shouldNotCreateDuration_whenTimeUnitIsNull() {
        //given
        var duration = 100;

        //when
        var throwable = assertThrows(IllegalArgumentException.class, () -> new Duration(duration, null));

        //then
        assertEquals("TimeUnit can not be null", throwable.getMessage());
    }
}
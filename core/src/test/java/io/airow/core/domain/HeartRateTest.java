package io.airow.core.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class HeartRateTest {

    @Test
    void shouldCreateHeartRate() {
        //given
        var key = "1-1";
        var rate = 80;

        //when
        var result = new HeartRate(key, rate);

        //then
        assertNotNull(result);
        assertEquals(key, result.key());
        assertEquals(rate, result.value());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowException_whenKeyIs(String key) {
        //when
        var ex = assertThrows(IllegalArgumentException.class, () -> new HeartRate(key, 80));

        //then
        assertEquals("key can not be empty", ex.getMessage());
    }
}
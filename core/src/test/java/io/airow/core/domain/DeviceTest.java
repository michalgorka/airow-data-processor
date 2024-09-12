package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

    @Test
    void shouldCreateDevice() {
        //given
        var device = UUID.randomUUID().toString();

        //when
        var result = new Device(device);

        //then
        assertNotNull(result);
        assertEquals(device, result.value());
    }

    @Test
    void shouldNotCreateDevice_whenValueIsNull() {
        //when
        var throwable = assertThrows(IllegalArgumentException.class, () -> new Device(null));

        //then
        assertEquals("device can not be null", throwable.getMessage());
    }
}
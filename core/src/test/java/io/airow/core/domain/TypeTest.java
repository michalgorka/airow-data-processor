package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {

    @Test
    void shouldCreateType() {
        //given
        var type = UUID.randomUUID().toString();

        //when
        var result = new Type(type);

        //then
        assertNotNull(result);
        assertEquals(type, result.value());
    }

    @Test
    void shouldNotCreateType_whenValueIsNull() {
        //when
        var throwable = assertThrows(IllegalArgumentException.class, () -> new Type(null));

        //then
        assertEquals("type can not be null", throwable.getMessage());
    }
}
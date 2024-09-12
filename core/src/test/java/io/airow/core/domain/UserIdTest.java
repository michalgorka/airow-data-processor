package io.airow.core.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserIdTest {

    @Test
    void shouldCreateUserId() {
        //given
        var userId = UUID.randomUUID().toString();

        //when
        var result = new UserId(userId);

        //then
        assertNotNull(result);
        assertEquals(userId, result.value());
    }

    @Test
    void shouldNotCreateUserId_whenValueIsNull() {
        //when
        var throwable = assertThrows(IllegalArgumentException.class, () -> new UserId(null));

        //then
        assertEquals("userId can not be null", throwable.getMessage());
    }
}
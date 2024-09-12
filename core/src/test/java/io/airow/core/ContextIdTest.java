package io.airow.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextIdTest {

    @Test
    void shouldCreateContextId() {
        //when
        var contextId = new ContextId();

        //then
        assertNotNull(contextId);
        assertNotNull(contextId.value());
    }
}
package io.airow.core;

import java.util.UUID;

public class ContextId {
    private final UUID value;

    public ContextId() {
        this.value = UUID.randomUUID();
    }

    public String value() {
        return value.toString();
    }
}

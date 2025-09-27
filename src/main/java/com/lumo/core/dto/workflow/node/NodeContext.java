package com.lumo.core.dto.workflow.node;

import java.util.HashMap;
import java.util.Map;

public class NodeContext {
    private final Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) { data.put(key, value); }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> clazz) { return (T) data.get(key); }

    public Map<String, Object> getAll() { return data; }
}

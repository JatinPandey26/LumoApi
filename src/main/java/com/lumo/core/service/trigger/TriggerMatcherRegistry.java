package com.lumo.core.service.trigger;

import com.lumo.core.ENUM.TriggerType;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class TriggerMatcherRegistry {

    private final Map<TriggerType,TriggerMatcher> triggerMatcherMap;

    public TriggerMatcherRegistry(List<TriggerMatcher> triggerMatchers) {
        Map<TriggerType, TriggerMatcher> map = new LinkedHashMap<>();
        for (TriggerMatcher matcher : triggerMatchers) {
            TriggerType type = matcher.getType();
            if (map.containsKey(type)) {
                throw new IllegalStateException(
                        "Duplicate TriggerMatcher found for type: " + type
                );
            }
            map.put(type, matcher);
        }
        this.triggerMatcherMap = Collections.unmodifiableMap(map);
    }

    public TriggerMatcher getMatcher(TriggerType type) {
        TriggerMatcher matcher = triggerMatcherMap.get(type);
        if (matcher == null) {
            throw new IllegalArgumentException("No TriggerMatcher found for type: " + type);
        }
        return matcher;
    }

}

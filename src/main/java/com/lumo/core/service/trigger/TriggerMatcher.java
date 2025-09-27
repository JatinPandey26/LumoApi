package com.lumo.core.service.trigger;

import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.trigger.TriggerEvent;
import com.lumo.core.dto.trigger.Trigger;

public interface TriggerMatcher {

    TriggerType getType();

    public boolean matches(Trigger trigger, TriggerEvent triggerEvent);

    default boolean supports(TriggerType triggerType){
        return getType() == triggerType;
    }

}

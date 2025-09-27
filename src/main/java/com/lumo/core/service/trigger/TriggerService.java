//package com.lumo.core.service.trigger;
//
//import com.lumo.core.ENUM.TriggerType;
//import com.lumo.core.dto.trigger.Trigger;
//import com.lumo.core.dto.trigger.TriggerRequest;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface TriggerService {
//
//    Long createTrigger(TriggerRequest request);
//
//    Optional<Trigger> getTriggerById(Long triggerId);
//
//    List<Trigger> getTriggersByConnector(String connectorID);
//
//    /**
//     * Retrieve all triggers of a specific type.
//     * @param type the trigger type
//     * @return list of triggers
//     */
//    List<Trigger> getTriggersByType(TriggerType type);
//
//    /**
//     * Update an existing trigger.
//     * @param triggerId the ID of the trigger
//     * @param request the new trigger data
//     * @return updated trigger entity
//     */
//    Trigger updateTrigger(Long triggerId, Trigger request);
//
//    /**
//     * Delete a trigger by ID.
//     * @param triggerId the trigger ID
//     */
//    void deleteTrigger(Long triggerId);
//}

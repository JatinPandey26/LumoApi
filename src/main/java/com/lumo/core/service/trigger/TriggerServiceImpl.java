//package com.lumo.core.service.trigger;
//
//import com.lumo.core.ENUM.TriggerType;
//import com.lumo.core.Entities.TriggerEntity;
//import com.lumo.core.dto.trigger.Trigger;
//import com.lumo.core.dto.trigger.TriggerRequest;
//import com.lumo.core.mapper.TriggerMapper;
//import com.lumo.core.repository.TriggerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class TriggerServiceImpl implements TriggerService {
//
//    private final TriggerMapper triggerMapper;
//    private final TriggerRepository triggerRepository;
//
//    @Override
//    public Long createTrigger(TriggerRequest request) {
//        TriggerEntity triggerEntity = triggerMapper.toEntity(request);
//        TriggerEntity entity = triggerRepository.save(triggerEntity);
//        return entity.getId();
//    }
//
//    @Override
//    public Optional<Trigger> getTriggerById(Long triggerId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Trigger> getTriggersByConnector(String connectorID) {
//        List<Trigger> triggerEntities = new java.util.ArrayList<>();
//        return triggerEntities;
//    }
//
//    @Override
//    public List<Trigger> getTriggersByType(TriggerType type) {
//        List<Trigger> triggerEntities = new java.util.ArrayList<>();
//        return triggerEntities;
//    }
//
//    @Override
//    public Trigger updateTrigger(Long triggerId, Trigger request) {
//        return null;
//    }
//
//    @Override
//    public void deleteTrigger(Long triggerId) {
//
//    }
//}

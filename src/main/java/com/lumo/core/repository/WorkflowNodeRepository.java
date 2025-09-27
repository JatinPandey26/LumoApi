package com.lumo.core.repository;

import com.lumo.core.ENUM.NodeType;
import com.lumo.core.Entities.WorkflowNodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkflowNodeRepository extends JpaRepository<WorkflowNodeEntity,Long> {
    List<WorkflowNodeEntity> findByType(NodeType nodeType);
}

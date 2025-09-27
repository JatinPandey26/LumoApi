package com.lumo.core.repository;

import com.lumo.core.Entities.WorkflowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowRepository extends JpaRepository<WorkflowEntity,Long> {


}

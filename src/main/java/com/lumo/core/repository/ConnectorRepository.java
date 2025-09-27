package com.lumo.core.repository;


import com.lumo.core.Entities.ConnectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectorRepository extends JpaRepository<ConnectorEntity,Long> {
}

package com.lumo.core.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column
    @UpdateTimestamp
    private Instant updatedAt;
}


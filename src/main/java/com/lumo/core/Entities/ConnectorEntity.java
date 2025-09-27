package com.lumo.core.Entities;

import com.lumo.core.ENUM.ConnectorStatus;
import com.lumo.core.ENUM.ConnectorType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
public class ConnectorEntity extends BaseEntity{

    @Column(name = "id", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ConnectorType type;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ConnectorStatus status = ConnectorStatus.INITIAL;

    @OneToMany(mappedBy = "connector")
    private List<TriggerEntity> triggers;

    @Type(JsonType.class)  // Hibernate knows this is JSONB
    @Column(columnDefinition = "JSONB")
    private HashMap<String, String> metaData = new HashMap<>();

}

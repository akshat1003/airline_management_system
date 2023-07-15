package com.loconav.airline_management.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class AbstractAirline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis() / 1000;
    }

    @PrePersist
    protected void onCreate() {
        this.updatedAt = System.currentTimeMillis() / 1000;
        this.createdAt = System.currentTimeMillis() / 1000;
    }

}

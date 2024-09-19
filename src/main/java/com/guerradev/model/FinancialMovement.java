package com.guerradev.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_financial_movement")
public class FinancialMovement extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Column(name = "name")
    public String name;
    @Column(name = "movement_value")
    public Double value;
    @Enumerated(EnumType.STRING)
    public MovementType movementType;
    @Column(name = "movement_date")
    public ZonedDateTime movementDate;

    public enum MovementType {
        EARNING,
        LOSS
    }
}

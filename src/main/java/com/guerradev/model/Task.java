package com.guerradev.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_task")
public class Task extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Column(name = "task_title", nullable = false)
    public String title;
    @OneToOne
    @JoinColumn(name = "task_responsible_id")
    public Person responsible;
}

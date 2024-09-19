package com.guerradev.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_person")
public class Person extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    public LocalDate birthDate;
    @Column(nullable = false)
    public String email;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "partner_id")
    public Person partner;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tb_person_task", joinColumns = {@JoinColumn(name = "person_id")},
    inverseJoinColumns = {@JoinColumn(name = "task_id")})
    public List<Task> tasks;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tb_person_compromise", joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "compromise_id")})
    public List<Compromise> compromise;
}

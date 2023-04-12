package com.dentalCare.TashkoAlejandra.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Patients")
public class Patient {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String lastName;
    private String address;
    private int dni;
    private Date dischargeDate;
    @OneToOne(mappedBy = "patient", fetch = FetchType.LAZY)

    @Transient
    private Appointment appointment;

    public Long getId() {return id;}
}


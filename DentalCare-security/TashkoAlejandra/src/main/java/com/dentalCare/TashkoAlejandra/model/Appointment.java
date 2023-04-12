package com.dentalCare.TashkoAlejandra.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "Appointments")
public class Appointment {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}

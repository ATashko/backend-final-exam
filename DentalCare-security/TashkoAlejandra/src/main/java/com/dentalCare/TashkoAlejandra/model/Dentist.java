package com.dentalCare.TashkoAlejandra.model;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="dentists")
public class Dentist {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String lastname;

    private String name;
    @Column(name="dental_license")
    private int license;
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    //private Appointment appointment;
    private Set<Appointment> appointment = new HashSet<>();
    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", license=" + license +
                ", appointment=" + appointment +
                '}';
    }

    public Long getId() {
        return id;
    }
}

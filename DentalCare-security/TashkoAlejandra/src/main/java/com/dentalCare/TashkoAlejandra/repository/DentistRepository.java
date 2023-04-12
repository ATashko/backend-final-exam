package com.dentalCare.TashkoAlejandra.repository;

import com.dentalCare.TashkoAlejandra.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface DentistRepository extends JpaRepository <Dentist, Long> {
    boolean existsById(Long id);

    @Transactional
    @Modifying
    @Query("update Dentist d set d.lastname = ?1, d.name = ?2, d.license = ?3 " +
            "where d.lastname is not null and d.name is not null and d.license is not null")
    Dentist update(@NonNull String lastname, @NonNull String name, @NonNull int license);

}

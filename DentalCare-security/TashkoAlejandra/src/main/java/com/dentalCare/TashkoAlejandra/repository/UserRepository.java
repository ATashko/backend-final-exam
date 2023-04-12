package com.dentalCare.TashkoAlejandra.repository;

import com.dentalCare.TashkoAlejandra.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <AppUser, Long> {
    Optional<AppUser> findByEmail(String email);


}

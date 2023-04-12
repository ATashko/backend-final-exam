package com.dentalCare.TashkoAlejandra.security.config;

import com.dentalCare.TashkoAlejandra.model.AppUser;
import com.dentalCare.TashkoAlejandra.model.AppUserRoles;
import com.dentalCare.TashkoAlejandra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DataLoader implements ApplicationRunner {

    UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");


        userRepository.save(new AppUser("User", "pass", "userTest@email.com", password, AppUserRoles.USER));
        userRepository.save(new AppUser("User2", "pass2", "userTest2@email.com", password2, AppUserRoles.ADMIN));


    }
}

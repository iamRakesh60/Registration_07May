package com.Registration_07May.service;

import com.Registration_07May.entity.Registration;
import com.Registration_07May.registration.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getRegistrationList(){
        List<Registration> registrationList = registrationRepository.findAll();
        return registrationList;
    }
}

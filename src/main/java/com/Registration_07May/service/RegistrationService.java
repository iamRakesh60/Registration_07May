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

    //Post Registration
    public Registration createRegistration(Registration reg){
        return registrationRepository.save(reg);
    }

    // Delete Registration
    public void deleteRegistration(long id){
        registrationRepository.deleteById(id);
    }

    // get Registration
    public List<Registration> getRegistrationList(){
        return registrationRepository.findAll();
    }
}

package com.Registration_07May.service;

import com.Registration_07May.entity.KYC;
import com.Registration_07May.entity.Registration;
import com.Registration_07May.payload.RegistrationDto;
import com.Registration_07May.repository.KYCRepository;
import com.Registration_07May.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private KYCRepository kycRepository;

    public RegistrationService(RegistrationRepository registrationRepository, KYCRepository kycRepository) {
        this.registrationRepository = registrationRepository;
        this.kycRepository = kycRepository;
    }

    //Post Registration
    public RegistrationDto createRegistration(RegistrationDto dto){
        Registration reg = mapToEntity(dto);

        Registration saveReg = registrationRepository.save(reg);

//        KYC kyc = new KYC();
//        kyc.setPan(dto.getPan());
//        kycRepository.save(kyc);

        RegistrationDto dto1 = mapToEntity(saveReg);

        return dto1;
    }

    Registration mapToEntity(RegistrationDto dto){
        Registration reg = new Registration();
        reg.setName(dto.getName());
        reg.setEmail(dto.getEmail());
        reg.setMobile(dto.getMobile());
        return reg;
    }
    RegistrationDto mapToEntity(Registration registration){
        RegistrationDto dto = new RegistrationDto();
        dto.setName(registration.getName());
        dto.setEmail(registration.getEmail());
        dto.setMobile(registration.getMobile());
        return dto;
    }



















    // Delete Registration
    public void deleteRegistration(long id){
        registrationRepository.deleteById(id);
    }

    // get Registration
    public List<Registration> getRegistrationList(){
        return registrationRepository.findAll();
    }


    public Registration updateRegistration(long id, Registration registration) {
        // Check if the registration exists
        Registration existingReg = registrationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Registration with ID " + id + " not found"));

        // Update only the fields that are allowed to be modified
        existingReg.setName(registration.getName());
        existingReg.setEmail(registration.getEmail());
        existingReg.setMobile(registration.getMobile());

        // Save the updated registration
        return registrationRepository.save(existingReg);
    }

}

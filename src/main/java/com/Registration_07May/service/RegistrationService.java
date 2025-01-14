package com.Registration_07May.service;

//import com.Registration_07May.entity.KYC;
import com.Registration_07May.entity.Registration;
import com.Registration_07May.payload.RegistrationDto;
//import com.Registration_07May.repository.KYCRepository;
import com.Registration_07May.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;

    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }
//private KYCRepository kycRepository;



    //Post Registration
    public RegistrationDto createRegistration(RegistrationDto dto){
        Registration reg = mapToDto(dto);

        Registration saveReg = registrationRepository.save(reg);

//        KYC kyc = new KYC();
//        kyc.setPan(dto.getPan());
//        kycRepository.save(kyc);

        RegistrationDto dto1 = mapToDto(saveReg);

        return dto1;
    }

    Registration mapToDto(RegistrationDto dto){
        Registration reg = modelMapper.map(dto, Registration.class);
//        Registration reg = new Registration();
//        reg.setName(dto.getName());
//        reg.setEmail(dto.getEmail());
//        reg.setMobile(dto.getMobile());
        return reg;
    }
    RegistrationDto mapToDto(Registration registration){
        RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);
//        RegistrationDto dto = new RegistrationDto();
//        dto.setName(registration.getName());
//        dto.setEmail(registration.getEmail());
//        dto.setMobile(registration.getMobile());
        return dto;
    }





    // Delete Registration
    public void deleteRegistration(long id){
        registrationRepository.deleteById(id);
    }

    // get Registration
    public List<RegistrationDto> getRegistrationList(){
       List<Registration> registrations = registrationRepository.findAll();
       // Registration object in add in RegistrationDto using java 8
        List<RegistrationDto> dtos = registrations.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return dtos;
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

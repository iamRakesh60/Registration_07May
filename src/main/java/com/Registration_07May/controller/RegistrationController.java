package com.Registration_07May.controller;

import com.Registration_07May.entity.Registration;
import com.Registration_07May.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    private ResponseEntity<Registration> createRegistration(@RequestBody Registration registration){
        Registration reg = registrationService.createRegistration(registration);
        return new ResponseEntity<>(reg,HttpStatus.CREATED);
    }

    @DeleteMapping
    private ResponseEntity<String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Registration is deleted", HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity <List<Registration>> registrationList(){
        List<Registration> registrationList = registrationService.getRegistrationList();
        return new ResponseEntity<>(registrationList, HttpStatus.FOUND);
    }
}

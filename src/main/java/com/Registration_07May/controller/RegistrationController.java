package com.Registration_07May.controller;

import com.Registration_07May.entity.Registration;
import com.Registration_07May.payload.RegistrationDto;
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
    private ResponseEntity<RegistrationDto> createRegistration(@RequestBody RegistrationDto dto){
        RegistrationDto reg = registrationService.createRegistration(dto);
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

    @PutMapping("{id}")
    private ResponseEntity<Registration> updateRegistration(@PathVariable long id, @RequestBody Registration registration) {
        try {
            Registration updatedReg = registrationService.updateRegistration(id, registration);
            return new ResponseEntity<>(updatedReg, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

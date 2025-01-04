package com.Registration_07May.controller;

import com.Registration_07May.entity.Registration;
import com.Registration_07May.service.RegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    private List<Registration> registrationList(){
        List<Registration> registrationList = registrationService.getRegistrationList();
        return registrationList;
    }
}

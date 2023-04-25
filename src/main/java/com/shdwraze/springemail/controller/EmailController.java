package com.shdwraze.springemail.controller;

import com.shdwraze.springemail.service.EmailService;
import com.shdwraze.springemail.model.Email;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailController {

    private EmailService emailService;

    @PostMapping("/send")
    public void sendMail(@RequestBody Email email) {
        emailService.sendMail(email);
    }
}

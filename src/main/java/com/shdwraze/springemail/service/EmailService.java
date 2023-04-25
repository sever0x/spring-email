package com.shdwraze.springemail.service;

import com.shdwraze.springemail.model.Email;

public interface EmailService {

    void sendMail(Email email);

    void sendSimpleMessage(String to, String subject, String text);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}

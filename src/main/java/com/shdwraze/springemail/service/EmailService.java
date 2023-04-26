package com.shdwraze.springemail.service;

import com.shdwraze.springemail.model.request.ChangePasswordRequest;
import com.shdwraze.springemail.model.request.Email;
import jakarta.servlet.http.HttpServletRequest;

public interface EmailService {

    void sendMail(Email email);

    void sendSimpleMessage(String to, String subject, String text);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);

    void forgotPassword(HttpServletRequest request, String email);

    void recoveryPassword(String token, ChangePasswordRequest changePasswordRequest);
}

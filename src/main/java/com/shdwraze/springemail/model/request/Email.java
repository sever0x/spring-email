package com.shdwraze.springemail.model.request;

import jakarta.validation.constraints.NotBlank;

public record Email(
        @NotBlank
        String to,
        @NotBlank
        String subject,
        @NotBlank
        String text,
        String pathToAttachment
) {
}

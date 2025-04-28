package com.example.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.entities.Customer}
 */
@Value
public class CustomerLoginDto implements Serializable {
            @Schema(description = "Login Email",
            name = "email",
            type = "string",
            example = "ali@mail.com")
            @NotNull
             @Email
            @NotEmpty @Size(min = 2, max = 100)
            String email;

            @Schema(
            description = "Login Password",
            name = "password",
            type = "string",
            example = "12345")
            @NotNull
            @Size(min = 5, max = 30)
            @NotEmpty
            String password;
}
package com.example.entities.dto;

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
public class CustomerRegisterDto implements Serializable {
    @NotNull
    @Size(min = 2, max = 100)
    @NotEmpty
    String name;
    @NotNull
    @Email
    @NotEmpty
    String email;
    @NotNull
    @Size(min = 5, max = 30)
    @NotEmpty
    String password;
}
//Entitydeki validaysonların tamamı bu kısımda yazılacak entity katmanında
//validasyon yazılmayacak Servis katmanında save de yazmadık update de yazdık bunların da önüne geçmek için.
//Maliyet a
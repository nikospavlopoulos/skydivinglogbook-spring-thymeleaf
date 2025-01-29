package com.nikospavlopoulos.skydivinglogbook.dto;

import com.nikospavlopoulos.skydivinglogbook.core.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInsertDTO {

    @Email
    private String username;

    @Pattern(regexp = "^(?=(.*[A-Za-z]){1})(?=(.*\\d){1})(?=(.*[!@#$%^&*(),.?\":{}|<>]){1}).{8,}$\n") // At least 8 digits with both numbers and letters and one special character
    private String password;

    private String role;

}

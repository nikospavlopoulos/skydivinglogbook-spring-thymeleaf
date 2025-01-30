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

/**
 * Data Transfer Object (DTO) used for capturing user registration input.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInsertDTO {

    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 10) // Username should be between 3 and 10 characters
    private String username;

    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=(.*[A-Za-z]){1})(?=(.*\\d){1})(?=(.*[!@#$%^&*(),.?\":{}|<>]){1}).{8,}$", message = "Password must be at least 8 characters long, include letters, numbers, and one special character") // At least 8 characters with both numbers and letters and one special character
    private String password;

    private String role; // Stores the user's role
    // Webpage Registration Option is only available for SKYDIVER role. Login should be for both, but ADMINS should be already set up directly in database.

}

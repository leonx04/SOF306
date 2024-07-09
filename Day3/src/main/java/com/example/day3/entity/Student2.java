package com.example.day3.entity;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student2 {
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    String email;
    @NotBlank(message = "Full name is mandatory")
    String fullName;
    @NotNull(message = "Mark is mandatory")
    @Max(value = 10, message = "Mark must be less than 10")
    @PositiveOrZero(message = "Mark must be positive ")
    Double mark;
    @NotBlank(message = "Country is mandatory")
    String country;
    @NotNull(message = "Gender is mandatory")
    Boolean gender;
}

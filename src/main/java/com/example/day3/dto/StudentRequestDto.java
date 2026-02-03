package com.example.day3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    @NotBlank(message = "Name can not be blank")
    private String name;

    @Min(value =5, message = "Age cannot be less then 5")
    @Max(value = 45, message = "Age should not be more then 45")
    private int age;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

}

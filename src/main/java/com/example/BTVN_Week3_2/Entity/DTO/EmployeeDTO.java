package com.example.BTVN_Week3_2.Entity.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class EmployeeDTO {
    @NotNull(message = "Id not allow null")
    private long employeeId;
    @NotNull(message = "name is not allowed null")
    @Length(min=10, max=50)
    private String name;
    private Date birthDate;
    private String gender;
    @NotNull(message="Email is not null")
    @Email(message = "Format email is not valid")
    private String email;
}

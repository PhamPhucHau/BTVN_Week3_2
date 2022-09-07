package com.example.BTVN_Week3_2.Entity.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class DepartmentDTO {
    @NotNull
    private long departmentId;
    @NotNull(message = "Department Name is not allowed null")
    @Length(min=10,max=50,message = "Length of Department name from 10 to 50 ")
    private String deptName;
    @Valid
    private List<EmployeeDTO> employeeDTOlist;
}

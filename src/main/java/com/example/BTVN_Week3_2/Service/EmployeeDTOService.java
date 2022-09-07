package com.example.BTVN_Week3_2.Service;

import com.example.BTVN_Week3_2.Entity.DTO.EmployeeDTO;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

public interface EmployeeDTOService {
    public EmployeeDTO getEmployeeDTO(@Valid EmployeeDTO employeeDTO) throws Exception;
}

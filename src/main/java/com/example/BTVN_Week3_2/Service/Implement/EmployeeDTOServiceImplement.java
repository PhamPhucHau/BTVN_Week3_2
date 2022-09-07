package com.example.BTVN_Week3_2.Service.Implement;

import com.example.BTVN_Week3_2.Entity.DTO.EmployeeDTO;
import com.example.BTVN_Week3_2.Service.EmployeeDTOService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
@Service
public class EmployeeDTOServiceImplement implements EmployeeDTOService {

   public EmployeeDTO getEmployeeDTO(@Valid EmployeeDTO employeeDTO) throws Exception {
        if(employeeDTO.getEmployeeId()==0)
        {
            throw new Exception("Lỗi invalid ID");
        }
        else {
            return employeeDTO;
        }
    }


}

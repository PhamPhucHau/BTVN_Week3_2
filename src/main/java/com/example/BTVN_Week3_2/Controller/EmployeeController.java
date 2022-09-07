package com.example.BTVN_Week3_2.Controller;

import com.example.BTVN_Week3_2.Entity.DTO.EmployeeDTO;
import com.example.BTVN_Week3_2.Service.EmployeeDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeDTOService employeeDTOService;
    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployeeDTO(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception"+ bindingResult.getAllErrors());
        }
        return ResponseEntity.ok("Success");
    }
    @GetMapping("/getEmployee")
    public ResponseEntity<Object> getEmployee(@RequestBody  EmployeeDTO employeeDTO )
    {
        try {
            return ResponseEntity.ok(employeeDTOService.getEmployeeDTO(employeeDTO));
        }
        catch(Exception exception)
        {
            return ResponseEntity.badRequest().body("Exception");
        }
    }
}

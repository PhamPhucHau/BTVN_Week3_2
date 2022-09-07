package com.example.BTVN_Week3_2.Controller;

import com.example.BTVN_Week3_2.Entity.DTO.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
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
    public ResponseEntity<Object> getEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(employeeDTO);
    }
}

package com.example.BTVN_Week3_2.Controller;

import com.example.BTVN_Week3_2.Entity.DTO.DepartmentDTO;
import com.example.BTVN_Week3_2.Service.DepartmentDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentDTOService departmentDTOService;
    @PostMapping("/addDepartment")
    public ResponseEntity<String> addDepartment(@RequestBody @Valid DepartmentDTO departmentDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body("Exeption"+ bindingResult.getAllErrors());

        }
        return ResponseEntity.ok().body("Adding department Success");
    }
    @GetMapping("/getDepartment")
    public ResponseEntity<Object> getDepartment(@RequestBody @Valid DepartmentDTO departmentDTO,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

            return ResponseEntity.ok().body(departmentDTOService.getDepartmentDTO(departmentDTO));

    }

}

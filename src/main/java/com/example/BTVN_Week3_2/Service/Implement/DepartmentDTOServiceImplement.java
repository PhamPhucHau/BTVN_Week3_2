package com.example.BTVN_Week3_2.Service.Implement;

import com.example.BTVN_Week3_2.Entity.DTO.DepartmentDTO;
import com.example.BTVN_Week3_2.Service.DepartmentDTOService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDTOServiceImplement implements DepartmentDTOService {

    public DepartmentDTO getDepartmentDTO( DepartmentDTO departmentDTO)
    {
        return departmentDTO;
    }
}

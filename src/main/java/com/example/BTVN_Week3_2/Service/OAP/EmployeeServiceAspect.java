package com.example.BTVN_Week3_2.Service.OAP;

import com.example.BTVN_Week3_2.Service.EmployeeDTOService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeServiceAspect {
    private Logger logger= LoggerFactory.getLogger(EmployeeDTOService.class);
    @AfterThrowing("execution (* com/example/BTVN_Week3_2/Service/EmployeeDTOService.java )")
    public void afterThrowingGetEmployeeDTO(Exception exception)
    {
        logger.error("***LoggingAspect.Log after throwing called service get EmployeeDTO"+ exception.toString());
    }
}

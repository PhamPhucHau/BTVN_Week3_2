package com.example.BTVN_Week3_2.Service.OAP;

import com.example.BTVN_Week3_2.Service.DepartmentDTOService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DepartmetDTOServiceAspect {
    private Logger logger= LoggerFactory.getLogger(DepartmentDTOService.class);
    @Before("execution(* com.example.BTVN_Week3_2.Service.Implement.DepartmentDTOServiceImplement.*(..))")
    public void beforeDepartmentDTOService(JoinPoint joinPoint)
    {
        logger.info("before called service get DepartmentDTO"+ joinPoint.toString());
    }
    @After("execution(* com.example.BTVN_Week3_2.Service.Implement.DepartmentDTOServiceImplement.*(..))")
    public void afterGetDepartmentDTOService(JoinPoint joinPoint)
    {
        logger.info("***LoggingAspect.Log after called service get DepartmentDTO"+ joinPoint.toString());
    }
}

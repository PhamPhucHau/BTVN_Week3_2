package com.example.BTVN_Week3_2.Service.OAP;

import com.example.BTVN_Week3_2.Service.EmployeeDTOService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class EmployeeServiceAspect {
    private Logger logger= LoggerFactory.getLogger(EmployeeDTOService.class);
    @AfterThrowing(value = "execution (* com.example.BTVN_Week3_2.Service.Implement.EmployeeDTOServiceImplement.*(..))",throwing="exception")
    public void afterThrowingGetEmployeeDTO(JoinPoint joinPoint, Exception exception)
    {
        logger.error("***LoggingAspect.Log after throwing called service get EmployeeDTO" + joinPoint.getSignature()+ "Exception is"+ exception.toString());
    }
}

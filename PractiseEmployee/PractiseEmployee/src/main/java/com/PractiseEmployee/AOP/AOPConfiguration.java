package com.PractiseEmployee.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPConfiguration {

    @Around("execution(* com.PractiseEmployee.Controllers.EmployeeControllers.getEmployee(..))")
    public Object beforeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("⭐ Inside BeforeMethod Aspect - Executing getEmployee()");
        Object result = joinPoint.proceed();
        System.out.println("⭐ Inside AfterMethod Aspect - Executing getEmployee()");
        return result;
    }
}

package com.example.springfwk04.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

  @Around("execution(* com.example.springfwk04.delegate.B*.transfer(double))") // Pointcut
  public Object advice(ProceedingJoinPoint joinPoint) throws Throwable { // Advice
    log.info(">>> Iniciando transferencia");
    Object[] arguments = joinPoint.getArgs();
    double amount = (Double) arguments[0];
    /*if (amount >= 30) {
      throw new Exception("No se pueden procesar transferencias interbancarias mayores o iguales a 30 soles");
    }*/
    Object proceed = joinPoint.proceed();
    log.info("<<< Finalizando transferencia");
    return proceed;
  }

}

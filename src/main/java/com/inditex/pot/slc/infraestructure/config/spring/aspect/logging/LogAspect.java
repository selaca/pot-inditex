package com.inditex.pot.slc.infraestructure.config.spring.aspect.logging;

import com.inditex.pot.slc.infraestructure.config.spring.aspect.logging.annotation.Logging;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Around("@annotation(com.inditex.pot.slc.infraestructure.config.spring.aspect.logging.annotation.Logging)")
    public Object logDecorator(ProceedingJoinPoint joinPoint) throws Throwable {
        Object response;

        try {

            String message =
                String.join(
                    " ",
                    new String[] {"Invoking", joinPoint.getSignature().toString(), "method"});
            long start = System.currentTimeMillis();

            printLog(
                getLoginAnnotation(joinPoint).value(),
                message);

            response =
                joinPoint.proceed(joinPoint.getArgs());

            long executionTime = System.currentTimeMillis() -start;
            message =
                String.join(
                    " ",
                    new String[] {"Invoked", joinPoint.getSignature().toString(), "method executed in: ", String.valueOf(executionTime), "ms"});

            printLog(
                getLoginAnnotation(joinPoint).value(),
                message);
        } catch(Exception ex) {
            log.error(String.join(
                " ",
                new String[] {"Exception when invoking", joinPoint.getSignature().toString(), "method:"})
                , ex);
            throw ex;
        }

        return response;
    }

    private Logging getLoginAnnotation(ProceedingJoinPoint joinPoint) {
        return
            ((MethodSignature)joinPoint.getSignature())
                .getMethod().getAnnotation(Logging.class);
    }

    private void printLog(String value, String logMessage) {
        if ("INFO".equalsIgnoreCase(value)) {
            log.info(logMessage);
        } else {
            log.debug(logMessage);
        }
    }
}

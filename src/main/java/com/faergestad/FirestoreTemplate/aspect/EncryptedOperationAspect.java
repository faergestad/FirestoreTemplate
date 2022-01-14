package com.faergestad.FirestoreTemplate.aspect;

import com.faergestad.FirestoreTemplate.annotation.Encrypted;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class EncryptedOperationAspect {

    @Around("@annotation(com.faergestad.FirestoreTemplate.annotation.EncryptedOperation)")
    public Object encryptedOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();

        // This example only takes into account functions with one parameter, but can easily be changed
        for (Field declaredField : joinPoint.getArgs()[0].getClass().getDeclaredFields()) {
            Encrypted encryptedAnnotation = declaredField.getAnnotation(Encrypted.class);
            if (encryptedAnnotation != null) {
                log.info("Found 'Encrypted' annotation on field: {}", declaredField.getName());
                // Find default access for field
                boolean canAccess = declaredField.canAccess(joinPoint.getArgs()[0]);
                // Make the field accessible to us
                declaredField.setAccessible(true);

                // How to access the fields value
                String fieldValue = (String) declaredField.get(joinPoint.getArgs()[0]);
                // How to set the field value
                declaredField.set(joinPoint.getArgs()[0], "ENCRYPTED..");

                // Set access to the field back to what it was originally
                declaredField.setAccessible(canAccess);
            }
        }

        log.info("Finished in: {}ms", stopwatch.stop().elapsed(TimeUnit.MICROSECONDS));
        // Resume execution
        return joinPoint.proceed();
    }

}

package register.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorInterceptor {

    @Around("@annotation(register.interceptors.Monitor)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.err.println("++++++++++++++++");
            return joinPoint.proceed();
        } finally {
            System.err.println("----------------");
        }
    }
}

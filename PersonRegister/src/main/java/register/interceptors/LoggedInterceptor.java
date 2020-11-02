package register.interceptors;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggedInterceptor {

    final private MeterRegistry meterRegistry;

    final private Counter counter;

    public LoggedInterceptor(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        counter = meterRegistry.counter("custom_requests_total");
    }

    @Around("@annotation(register.interceptors.Logged)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("start " + joinPoint.getSignature().toLongString()+ Arrays.toString(joinPoint.getArgs()));
            counter.increment();
            return joinPoint.proceed();
        } finally {
            log.info("stop " + joinPoint.getSignature().toLongString()+ Arrays.toString(joinPoint.getArgs()));
        }
    }
}

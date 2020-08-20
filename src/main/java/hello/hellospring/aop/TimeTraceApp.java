package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceApp {

    @Around("execution(* hello.helloSpring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        try{
            Object result=joinPoint.proceed();
            return result;

        }finally {
            long finish =System.currentTimeMillis();
            long timeMs = finish - start;
        }


    }
}

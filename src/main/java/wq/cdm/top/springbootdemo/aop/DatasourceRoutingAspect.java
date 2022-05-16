package wq.cdm.top.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import wq.cdm.top.springbootdemo.config.datasource.DatasourceRouting;
import wq.cdm.top.springbootdemo.config.datasource.DatasourceRoutingContext;

@Aspect
@Slf4j
@Component
public class DatasourceRoutingAspect {

    @Around("@annotation(datasourceRouting)")
    public Object setDynamicDataSource(ProceedingJoinPoint joinPoint, DatasourceRouting datasourceRouting) throws Throwable {
        try {
            DatasourceRoutingContext.set(datasourceRouting.value());
            log.info("current request datasource: {}", DatasourceRoutingContext.get());
            return joinPoint.proceed();
        } finally {
            DatasourceRoutingContext.del();
        }
    }

}

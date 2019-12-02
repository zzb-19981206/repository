package com.xiaoshu.common.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.xiaoshu.admin.Enum.DBTypeEnum;
import com.xiaoshu.common.config.DataSource;
import com.xiaoshu.common.config.DbContextHolder;

/**
 * @author 迪富
 */
@Component
@Order(value = -1)
@Slf4j
@Aspect
public class DataSourceSwitchAspect {

	@Pointcut("execution(* com.xiaoshu.admin.service..*.*(..))")
    private void db1Aspect() {
    }
 
    @Pointcut("execution(* com.xiaoshu.admin.service.db2.*.*(..))")
    private void db2Aspect() {
    }
    
    
 
    @Before( "db1Aspect()" )
    public void db1() {
        log.info("切换到db1 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.db1);
    }
 
    @Before("db2Aspect()" )
    public void db2 () {
        log.info("切换到db2 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.db2);
    }
    
    
    
    @After("db1Aspect()")
    public void removeDataSoruce(JoinPoint joinPoint)
      throws Throwable {
    	DbContextHolder.clearDbType();
    }
    
    @After("db2Aspect()")
    public void removeDataSoruce1(JoinPoint joinPoint)
      throws Throwable {
    	DbContextHolder.clearDbType();
    }
    
    
}

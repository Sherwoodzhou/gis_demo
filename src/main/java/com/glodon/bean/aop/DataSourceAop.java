package com.glodon.bean.aop;

import com.glodon.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.glodon.bean.annotation.Master) " +
            "&& (execution(* com.glodon.service..*.select*(..)) " +
            "|| execution(* com.glodon.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.glodon.bean.annotation.Master) " +
            "|| execution(* com.glodon.service..*.insert*(..)) " +
            "|| execution(* com.glodon.service..*.add*(..)) " +
            "|| execution(* com.glodon.service..*.update*(..)) " +
            "|| execution(* com.glodon.service..*.edit*(..)) " +
            "|| execution(* com.glodon.service..*.delete*(..)) " +
            "|| execution(* com.glodon.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.glodon.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}

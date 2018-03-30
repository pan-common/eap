package com.taiji.eap.common.datasource.advice;

import com.taiji.eap.common.datasource.annotation.DataSource;
import com.taiji.eap.common.datasource.base.DataSourceHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * 切换数据源AOP拦截器
 * @author 潘宏智
 * @date
 */
@Aspect
@Component
@Order(1)//请注意：这里order一定要小于tx:annotation-driven的order，即先执行DataSourceAspect切面，再执行事务切面，才能获取到最终的数据源
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {

    private static String DATA_SOURCES_NAME = "targetDataSources";

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;

    @Pointcut("(execution(public * *..*.*(..)))&&@within(com.taiji.eap.common.datasource.annotation.DataSource)")
    public void aspect(){

    }

    /**
     * 配置前置通知
     */
    @Before("aspect()")
    public void before(JoinPoint point){
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = null;
        dataSource = this.getDataSource(target, method);
        if(dataSource==null){
            for (Class<?> clazz:target.getInterfaces()) {
                dataSource = getDataSource(clazz,method);
                if(dataSource != null){
                    break ;//从某个接口中一旦发现注解，不再循环
                }
            }
        }
        if(dataSource!=null&&!StringUtils.isEmpty(dataSource.value())){
            DataSourceHolder.setDataSource(dataSource.value());
            try {
                String databaseId =  sqlSessionFactory.getObject().getConfiguration().getDatabaseId();
                LOGGER.info(databaseId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用完清空
     */
    @After("aspect()")
    public void after(JoinPoint point){
        DataSourceHolder.setDataSource(null);
    }

    /**
     * 获取方法或类的注解对象DataSource
     * @param target 类class
     * @param method 方法
     * @return
     */
    private DataSource getDataSource(Class<?> target, Method method) {
        try {
            //优先方法注解
            Class<?>[] types = method.getParameterTypes();
            Method m = target.getMethod(method.getName(),types);
            if(m!=null&&m.isAnnotationPresent(DataSource.class)){
                return m.getAnnotation(DataSource.class);
            }
            //其次类注解
            if (target.isAnnotationPresent(DataSource.class)) {
                return target.getAnnotation(DataSource.class);
            }
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(MessageFormat.format("通过注解切换数据源时发生异常[class={0},method={1}]："
                    , target.getName(), method.getName()),e)  ;
        }
        return null;
    }

}

package com.taiji.eap.common.mybatis.intercept;

import com.taiji.eap.common.mybatis.bean.Log;
import com.taiji.eap.common.utils.DateUtils;
import com.taiji.eap.common.utils.GsonUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * @author panho
 * @date 2017年12月18日
 */
@Intercepts({@Signature(method = "update",type = Executor.class,args = {
        MappedStatement.class,Object.class
})})
public class PrintSqlIntercept implements Interceptor{

    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintSqlIntercept.class);

    private Properties properties;

    private String isPrint;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        //获取执行的方法
        if(args.length>1){
            //传入的对象
            Object obj = args[1];
            if(obj instanceof Log) {
                //若是日志对象 则直接跳过
                return invocation.proceed();
            }
            saveLog(args[0], obj);
        }

        return invocation.proceed();
    }

    private void saveLog(Object arg,Object obj){
        Log log = new Log();
        log.setCreateTime(new Date());
        log.setModifyTime(new Date());
        MappedStatement mappedStatement = (MappedStatement) arg;
        String name = mappedStatement.getSqlCommandType().name();
        String change = GsonUtils.toJson(obj);
        if(name.startsWith(INSERT)){
            log.setType("新增"+obj.getClass().getSimpleName());
            log.setNewContent(change);
        }else if(name.startsWith(UPDATE)){
            log.setType("修改"+obj.getClass().getSimpleName());
            log.setNewContent(change);
        }else if(name.startsWith(DELETE)){
            log.setType("删除"+obj.getClass().getSimpleName());
            log.setOldContent(change);
        }
        if("true".equals(isPrint)) {
            LOGGER.info("===============================================");
            LOGGER.info(GsonUtils.toJson(log));
            LOGGER.info("===============================================");
        }

    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}

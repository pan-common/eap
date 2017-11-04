package com.taiji.eap.common.easypoi.excel.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Excel {

    /**
     * 导入导出Excel.标题
     */
    String name();


    /**
     * 配置列的名称,对应A,B,C,D....
     */
    String column();

}

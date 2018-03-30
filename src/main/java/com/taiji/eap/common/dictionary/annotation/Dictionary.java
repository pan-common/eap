package com.taiji.eap.common.dictionary.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dictionary {
    /**
     * 数据源名称
     * @return
     */
    String dataSource();

    /**
     * 参数 多个参数使用逗号隔开
     * @return
     */
    String params();

}

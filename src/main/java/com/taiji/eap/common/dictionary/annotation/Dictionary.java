package com.taiji.eap.common.dictionary.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dictionary {

    float parentId() default -1;

}

package com.taiji.eap.common.base.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 潘宏智
 * @date
 */
public class CustomDateConverter implements Converter<String,Date>{

    private String pattern;

    public CustomDateConverter(String pattern) {
        super();
        this.pattern = pattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        try {
            return sd.parse(s);
        } catch (ParseException e) {
            throw new IllegalAccessError("日期转换出错！！");
        }
    }
}

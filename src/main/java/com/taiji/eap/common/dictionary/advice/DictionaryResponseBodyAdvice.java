package com.taiji.eap.common.dictionary.advice;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.annotation.Dictionary;
import com.taiji.eap.common.dictionary.annotation.DictionaryResponse;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.common.http.entity.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@ControllerAdvice
public class DictionaryResponseBodyAdvice implements ResponseBodyAdvice<PageInfo>{

    @Autowired
    private DictionaryService dictionaryService;

    private static Logger logger = LoggerFactory.getLogger(DictionaryResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getMethod().isAnnotationPresent(DictionaryResponse.class);
    }

    @Override
    public PageInfo beforeBodyWrite(PageInfo body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        for (int i = 0; i < body.getList().size(); i++) {
            Class cls = body.getList().get(i).getClass();
            Field[] fields = cls.getDeclaredFields();
            for (Field field: fields) {
                Dictionary dictionary = field.getAnnotation(Dictionary.class);
                if(dictionary!=null){
                    try {
                        field.setAccessible(true);
                        String keystone = (String) field.get(body.getList().get(i));
                        field.set(body.getList().get(i),dictionaryService.getValueByKey(keystone,dictionary.parentId()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return body;
    }
}

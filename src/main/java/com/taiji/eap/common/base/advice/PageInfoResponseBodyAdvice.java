package com.taiji.eap.common.base.advice;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.PageStautsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author 潘宏智
 * @date 2018年1月24日
 * 处理PageInfo返回值，适应layui的table插件
 */
@ControllerAdvice
public class PageInfoResponseBodyAdvice implements ResponseBodyAdvice<PageInfo>{

    private static final Logger LOGGER = LoggerFactory.getLogger(PageInfoResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        if(methodParameter.getMethod().getReturnType()==PageInfo.class){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo beforeBodyWrite(PageInfo pageInfo,
                                    MethodParameter methodParameter,
                                    MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                    ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        PageStautsInfo pageStautsInfo = new PageStautsInfo();
        pageStautsInfo.setEndRow(pageInfo.getEndRow());
        pageStautsInfo.setHasNextPage(pageInfo.isHasNextPage());
        pageStautsInfo.setHasPreviousPage(pageInfo.isHasPreviousPage());
        pageStautsInfo.setIsFirstPage(pageInfo.isIsFirstPage());
        pageStautsInfo.setIsLastPage(pageInfo.isIsLastPage());
        pageStautsInfo.setList(pageInfo.getList());
        pageStautsInfo.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
        pageStautsInfo.setNavigateLastPage(pageInfo.getNavigateLastPage());
        pageStautsInfo.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageStautsInfo.setNavigatePages(pageInfo.getNavigatePages());
        pageStautsInfo.setNextPage(pageInfo.getNextPage());
        pageStautsInfo.setPageNum(pageInfo.getPageNum());
        pageStautsInfo.setPages(pageInfo.getPages());
        pageStautsInfo.setPageSize(pageInfo.getPageSize());
        pageStautsInfo.setPrePage(pageInfo.getPrePage());
        pageStautsInfo.setSize(pageInfo.getSize());
        pageStautsInfo.setStartRow(pageInfo.getStartRow());
        pageStautsInfo.setTotal(pageInfo.getTotal());
        pageStautsInfo.setFirstPage(pageInfo.getFirstPage());
        pageStautsInfo.setLastPage(pageInfo.getLastPage());
        return pageStautsInfo;
    }
}

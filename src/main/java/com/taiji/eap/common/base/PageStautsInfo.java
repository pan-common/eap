package com.taiji.eap.common.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * layui table需要的返回值
 * @author 潘宏智
 * @date
 */
public class PageStautsInfo<T> extends PageInfo<T>{

    private int code = 0;
    private String msg = "请求成功";

    public PageStautsInfo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PageStautsInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

package com.taiji.eap.common.http.entity;

/**
 * 作者：panho on 2017-3-22 11:21
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class PageForQuery<T>{

    private String startSize;//起始行
    private String endSize;//结束行
    private String listTotalSize;//总行数

    private T genericity;//泛型类

    public PageForQuery(){
        super();
    }

    public PageForQuery(String listTotalSize, T genericity){
        this.listTotalSize = listTotalSize;
        this.genericity = genericity;
    }

    public PageForQuery(String startSize, String endSize, String listTotalSize, T genericity) {
        this.startSize = startSize;
        this.endSize = endSize;
        this.listTotalSize = listTotalSize;
        this.genericity = genericity;
    }


    public String getStartSize() {
        return startSize;
    }

    public void setStartSize(String startSize) {
        this.startSize = startSize;
    }

    public String getEndSize() {
        return endSize;
    }

    public void setEndSize(String endSize) {
        this.endSize = endSize;
    }

    public String getListTotalSize() {
        return listTotalSize;
    }

    public void setListTotalSize(String listTotalSize) {
        this.listTotalSize = listTotalSize;
    }

    public T getGenericity() {
        return genericity;
    }

    public void setGenericity(T genericity) {
        this.genericity = genericity;
    }
}

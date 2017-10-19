package com.taiji.eap.common.taglib.select.base;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 下拉框通用数据源处理类
 */
public abstract class SelectCommonDataSourceHandler<T> extends SelectDataSource<T>{

    protected SelectCommonDataSourceHandler nextHandler;

    protected static List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

    public void doHandler(String datasource,String param) throws Exception{
        if(isType(datasource)){
            doEcho(param);
        }else {
            if(nextHandler!=null){
                nextHandler.doHandler(datasource,param);
            }else {
                throw new Exception("未找到处理类");
            }
        }
    }

    protected abstract boolean isType(String type);

    public SelectCommonDataSourceHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(SelectCommonDataSourceHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void doEcho(String param){
        try {
            list.clear();
            list.addAll(getSelectDataSource(param));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}

package com.taiji.eap.common.query.bean;

import java.util.List;
import java.util.Map;

public class PageBean {

    private Integer total;

    private List<Map<String,Object>> rows;

    public PageBean(Integer total, List<Map<String, Object>> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageBean() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}

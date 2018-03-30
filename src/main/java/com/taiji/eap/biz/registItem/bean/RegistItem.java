
package com.taiji.eap.biz.registItem.bean;

import java.util.Date;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class RegistItem extends BaseModel{
    private Long id;//主键
    @Dictionary(dataSource = "dictionary",params = "69")
    private String name;//名称
    private Integer quantity;//数量
    @Dictionary(dataSource = "dictionary",params = "74")
    private String type;//登记类型
    private String registerTime;//登记时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }


}

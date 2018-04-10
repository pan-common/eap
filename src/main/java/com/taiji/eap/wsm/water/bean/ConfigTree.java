
package com.taiji.eap.wsm.water.bean;

import java.util.Date;

import com.taiji.eap.common.base.BaseTree;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ConfigTree extends BaseTree{
    private String id;//主键
    private String title;//标题
    private String parentId;//上级ID
    private String image;//图标图片
    private String jumpPage;//跳转页面 类名
    private String configType;//类型
    private String view;//使用的view类名
    private Integer seq;//排序

    public ConfigTree(String id,String title) {
        this.id = id;
        this.title = title;
    }

    public ConfigTree() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getJumpPage() {
        return jumpPage;
    }

    public void setJumpPage(String jumpPage) {
        this.jumpPage = jumpPage;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}

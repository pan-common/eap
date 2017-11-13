
package com.taiji.eap.common.area.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.generator.bean.LayuiTree;
public class Area extends LayuiTree{

    private static final long serialVersionUID = 4270170570634937361L;

    private Integer areaId;//主键
    private String areaName;//区划名称
    private Integer parentId;//上级区划代码
    private String shortName;//简写名称
    private String lng;//纬度
    private String lat;//经度
    private Integer level;//1.省 2.市 3.区 4.镇
    private String position;//定位
    private Integer sort;//排序

    public static final String OBJECT_KEY = "AREA";

    public Area(Integer areaId,String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public Area() {

    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }


    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public static String getObjectKey() {
        return OBJECT_KEY;
    }
}

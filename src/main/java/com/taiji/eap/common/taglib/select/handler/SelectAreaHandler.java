package com.taiji.eap.common.taglib.select.handler;

import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.common.area.service.AreaService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public class SelectAreaHandler extends SelectCommonDataSourceHandler<Area>{

    @Autowired
    private AreaService areaService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("area")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "areaId";
    }

    @Override
    public String getValueName() {
        return "areaName";
    }

    @Override
    public List<Area> getDataSource(String... params) throws Exception {
        List<Area> areas = new ArrayList<>();
        areas.add(areaService.selectByPrimaryKey(Integer.valueOf(params[0])));
        return areas;
    }

    @Override
    public Class<Area> getDataSourceClass() {
        return Area.class;
    }
}

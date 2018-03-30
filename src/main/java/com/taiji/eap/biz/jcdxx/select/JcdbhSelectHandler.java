package com.taiji.eap.biz.jcdxx.select;

import com.taiji.eap.biz.jcdxx.service.JcdxxService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 监测点编号下拉
 * @author 潘宏智
 * @date
 */
public class JcdbhSelectHandler extends SelectCommonDataSourceHandler<Dictionary>{

    @Autowired
    private JcdxxService jcdxxService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("jcdbh")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "keystone";
    }

    @Override
    public String getValueName() {
        return "value";
    }

    @Override
    public List<Dictionary> getDataSource(String... params) throws Exception {
        return jcdxxService.getJcdbhByQybh(params[0],params[1],params[2]);
    }

    @Override
    public Class<Dictionary> getDataSourceClass() {
        return Dictionary.class;
    }
}

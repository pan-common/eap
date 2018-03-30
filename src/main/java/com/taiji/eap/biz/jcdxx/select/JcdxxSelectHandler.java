package com.taiji.eap.biz.jcdxx.select;

import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.jcdxx.service.JcdxxService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public class JcdxxSelectHandler extends SelectCommonDataSourceHandler<Jcdxx>{

    @Autowired
    private JcdxxService jcdxxService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("jcdxx")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "jcdbh";
    }

    @Override
    public String getValueName() {
        return "jcdmc";
    }

    @Override
    public List<Jcdxx> getDataSource(String... params) throws Exception {
        return jcdxxService.selectByQybh(params[0],params[1]);
    }

    @Override
    public Class<Jcdxx> getDataSourceClass() {
        return Jcdxx.class;
    }
}

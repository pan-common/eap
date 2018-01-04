package com.taiji.eap.biz.jcxm.select;

import com.taiji.eap.biz.jcxm.service.JcxmService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 监测项目下拉
 * @author 潘宏智
 * @date
 */
public class JcxmSelectHandler extends SelectCommonDataSourceHandler<Dictionary>{

    @Autowired
    private JcxmService jcxmService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("jcxm")){
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
        return jcxmService.getJcxmByJcdbh(params[0],params[1]);
    }

    @Override
    public Class<Dictionary> getDataSourceClass() {
        return Dictionary.class;
    }
}

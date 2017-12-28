package com.taiji.eap.biz.qyjbxx.select;

import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
import com.taiji.eap.biz.qyjbxx.service.QyjbxxService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public class QyjbxxSelectHandler extends SelectCommonDataSourceHandler<Qyjbxx>{

    @Autowired
    private QyjbxxService qyjbxxService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("qyjbxx")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "qybh";
    }

    @Override
    public String getValueName() {
        return "qymc";
    }

    @Override
    public List<Qyjbxx> getDataSource(String... params) throws Exception {
        List<Qyjbxx> qyjbxxes = qyjbxxService.list("");
        return qyjbxxes;
    }

    @Override
    public Class<Qyjbxx> getDataSourceClass() {
        return Qyjbxx.class;
    }

}

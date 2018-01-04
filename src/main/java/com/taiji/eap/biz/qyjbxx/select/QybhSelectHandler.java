package com.taiji.eap.biz.qyjbxx.select;

import com.taiji.eap.biz.qyjbxx.service.QyjbxxService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 查询正式库企业编号下拉
 * @author 潘宏智
 * @date
 */
public class QybhSelectHandler extends SelectCommonDataSourceHandler<Dictionary>{

    @Autowired
    private QyjbxxService qyjbxxService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("qybh")){
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
        List<Dictionary> dictionaries = qyjbxxService.getQybhByQymc(params[0]);
        return dictionaries;
    }

    @Override
    public Class<Dictionary> getDataSourceClass() {
        return Dictionary.class;
    }
}

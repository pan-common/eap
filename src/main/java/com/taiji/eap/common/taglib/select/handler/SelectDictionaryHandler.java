package com.taiji.eap.common.taglib.select.handler;

import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SelectDictionaryHandler extends SelectCommonDataSourceHandler<Dictionary>{

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("dictionary")) {
            return true;
        } else {
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
        List<Dictionary> dictionaries = dictionaryService.listByPid(Long.valueOf(params[0]));
        return dictionaries;
    }

    @Override
    public Class<Dictionary> getDataSourceClass() {
        return Dictionary.class;
    }
}

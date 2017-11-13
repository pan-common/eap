package com.taiji.eap.common.taglib.select.handler;

import com.taiji.eap.common.form.formconf.service.FormconfService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import com.taiji.eap.common.form.formconf.bean.Formconf;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SelectFormHandler extends SelectCommonDataSourceHandler<Formconf>{

    @Autowired
    private FormconfService formconfService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("formconf")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "formId";
    }

    @Override
    public String getValueName() {
        return "formName";
    }

    @Override
    public List<Formconf> getDataSource(String... params) throws Exception {
        return formconfService.list("");
    }

    @Override
    public Class<Formconf> getDataSourceClass() {
        return Formconf.class;
    }
}

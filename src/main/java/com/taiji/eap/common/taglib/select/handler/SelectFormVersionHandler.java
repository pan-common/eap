package com.taiji.eap.common.taglib.select.handler;

import com.taiji.eap.common.form.formconfVersion.bean.FormconfVersion;
import com.taiji.eap.common.form.formconfVersion.service.FormconfVersionService;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SelectFormVersionHandler extends SelectCommonDataSourceHandler<FormconfVersion>{

    @Autowired
    private FormconfVersionService formconfVersionService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("formVersion")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getKeyName() {
        return "formVersionId";
    }

    @Override
    public String getValueName() {
        return "versionNumber";
    }

    @Override
    public List<FormconfVersion> getDataSource(String... params) throws Exception {
        List<FormconfVersion> formconfVersions = new ArrayList<>();
        if(params.length>0) {
            if(!params[0].equals("")) {
                formconfVersions.addAll(formconfVersionService.listByFormId(Long.valueOf(params[0])));
            }
        }
        return formconfVersions;
    }

    @Override
    public Class<FormconfVersion> getDataSourceClass() {
        return FormconfVersion.class;
    }
}

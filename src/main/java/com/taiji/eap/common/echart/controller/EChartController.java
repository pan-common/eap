package com.taiji.eap.common.echart.controller;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.echart.bean.EChartOption;
import com.taiji.eap.common.echart.service.EChartService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("echart")
public class EChartController extends BaseController{

    @Autowired
    private EChartService eChartService;

    @GetMapping(value = "getEChartOption")
    @ResponseBody
    public Response<EChartOption> getEChartOption(){
        return renderSuccess(eChartService.getEChartOption());
    }

}

package com.taiji.eap.wsm.water.controller;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.wsm.water.bean.WaterSource;
import com.taiji.eap.wsm.water.service.WaterSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
@Controller
@RequestMapping("waterSource")
public class WaterSourceController extends BaseController{

    @Autowired
    private WaterSourceService waterSourceService;

    /**
     *
     * @return
     */
    @GetMapping("selectAll")
    @ResponseBody
    public List<WaterSource> selectAll(){
        List<WaterSource> waterSources = new ArrayList<>();
        try {
            waterSources.addAll(waterSourceService.selectDjsAll());
            waterSources.addAll(waterSourceService.selectDjxAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return waterSources;
    }

}

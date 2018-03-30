package com.taiji.eap.biz.qywh.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.qyjbxx.bean.Qyjbxx;
import com.taiji.eap.biz.qywh.bean.HbSjcjQyJbxx;
import com.taiji.eap.biz.qywh.service.HbSjcjQyJbxxService;
import com.taiji.eap.common.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潘宏智
 * @date
 */
@Controller
@RequestMapping("hbSjcjQyJbxx")
public class HbSjcjQyJbxxController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(HbSjcjQyJbxxController.class);

    @Autowired
    private HbSjcjQyJbxxService hbSjcjQyJbxxService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<HbSjcjQyJbxx> list(Integer pageNum, Integer pageSize, String searchText){
        PageInfo<HbSjcjQyJbxx> pageInfo = null;
        try {
            pageInfo = hbSjcjQyJbxxService.selectByQymc(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }


}

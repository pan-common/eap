package com.taiji.eap.biz.qyjcxx.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.annotation.DictionaryResponse;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import com.taiji.eap.biz.qyjcxx.service.QyjcxxService;
import com.taiji.eap.common.http.entity.EasyuiFilter;
import com.taiji.eap.common.http.entity.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.jeecgframework.poi.excel.entity.vo.MapExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("qyjcxx")
public class QyjcxxController extends BaseController{

    @Autowired
    private QyjcxxService qyjcxxService;

    @GetMapping(value = "list")
    @ResponseBody
    @DictionaryResponse
    public PageInfo<Qyjcxx> list(Long parentId, Integer pageNum, Integer pageSize, String searchName,
                                 String searchText, String filterRules){

        PageInfo<Qyjcxx> pageInfo = null;
        try {
            pageInfo = qyjcxxService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Qyjcxx qyjcxx){
        try {
            int k = qyjcxxService.insert(qyjcxx);
            if(k>0){
                return renderSuccess("添加成功");
            }else {
                return renderError("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Response<String> edit(Qyjcxx qyjcxx){
        try {
            int k = qyjcxxService.updateByPrimaryKey(qyjcxx);
            if(k>0){
                return renderSuccess("修改成功");
            }else {
                return renderError("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Response<String> delete(Long id){
        try {
            int k = qyjcxxService.deleteByPrimaryKey(id);
            if(k>0){
                return renderSuccess("删除成功");
            }else {
                return renderError("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @GetMapping(value = "selectOne")
    @ResponseBody
    public Response<Qyjcxx> selectOne(Long id){
         try {
            return renderSuccess(qyjcxxService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @PostMapping(value = "easyuiSubmitData")
    @ResponseBody
    public Response<String> easyuiSubmitData(@RequestBody EasyUISubmitData<Qyjcxx> easyUISubmitData){
        int i = qyjcxxService.easyuiSubmitData(easyUISubmitData);
        if(i>0)
            return renderSuccess("提交成功");
        else
            return renderError("提交失败");
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<Qyjcxx>> getPath(Long id){
         try {
             return renderSuccess(qyjcxxService.getPath(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<Qyjcxx>> listByPid(Long parentId){
         List<Qyjcxx> list = null;
         try {
             list = qyjcxxService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<LayuiTree>> treeView(Long parentId){
        List<LayuiTree> layuiTrees = null;
        try {
            layuiTrees = qyjcxxService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }

    @GetMapping(value = "exportExcle")
    public void exportExcle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户数据表","UTF-8") + ".xls");
        //编码
        response.setCharacterEncoding("UTF-8");
        List<Qyjcxx> list = qyjcxxService.list("");
        ExportParams params = new ExportParams("企业信息", "创建时间:"+"2017年10月24日16:45:23", "张三");
        Workbook workbook = ExcelExportUtil.exportExcel(params, Qyjcxx.class, list);
        workbook.write(response.getOutputStream());
    }

    @GetMapping("/MapExportExcel")
    public String exportMerchantProfitQuery(ModelMap modelMap, HttpServletRequest request) {
        List<ExcelExportEntity> entityList = new ArrayList<ExcelExportEntity>();
        entityList.add(new ExcelExportEntity("编号", "id", 35));
        entityList.add(new ExcelExportEntity("监测日期", "jcrq", 15));
        entityList.add(new ExcelExportEntity("省", "shen", 15));
        entityList.add(new ExcelExportEntity("市", "shi", 15));
        entityList.add(new ExcelExportEntity("县", "xian", 15));
        entityList.add(new ExcelExportEntity("企业名称", "qymc", 15));
        entityList.add(new ExcelExportEntity("行业类型", "hylx", 15));
        entityList.add(new ExcelExportEntity("污染防治设施是否正常运行", "wrfzss", 15));
        entityList.add(new ExcelExportEntity("运行问题描述", "yxwtms", 15));
        entityList.add(new ExcelExportEntity("是否存在数据造假行为", "sfczsjzj", 15));
        entityList.add(new ExcelExportEntity("造假问题描述", "zjwtms", 15));
        entityList.add(new ExcelExportEntity("是否存在严重跑冒滴漏", "sfczyzpmdl", 15));
        entityList.add(new ExcelExportEntity("跑冒滴漏问题描述", "pmdlwtms", 15));
        List<Map<String, String>> dataResult = qyjcxxService.listMap("");

        modelMap.put(MapExcelConstants.ENTITY_LIST, entityList);
        modelMap.put(MapExcelConstants.MAP_LIST, dataResult);
        modelMap.put(MapExcelConstants.FILE_NAME, "商户利润");
        Date now = new Date();
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("商户利润详情", "创建时间" + now.toLocaleString(), "商户"));
        return MapExcelConstants.JEECG_MAP_EXCEL_VIEW;
    }

}
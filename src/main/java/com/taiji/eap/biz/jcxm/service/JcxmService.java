package com.taiji.eap.biz.jcxm.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.jcxm.bean.Jcxm;
import java.util.List;

public interface JcxmService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param jcxm
     * @return
     */
    int insert(Jcxm jcxm) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Jcxm selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param jcxm
     * @return
     */
    int updateByPrimaryKey(Jcxm jcxm) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Jcxm> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Jcxm> list(int pageNum, int pageSize, String searchText,String qybh,String jcdbh) throws Exception;
    /**
     * 通过监测点编号获取监测项目
     * @param qybh 企业编号
     * @param jcdbh 监测点编号
     * @return
     */
    List<Jcxm> listByJcdbh(String qybh, String jcdbh);

    /**
     * 通过监测点编号获取监测项目
     * @param qybh 企业编号
     * @param jcdbh 监测点编号
     * @return
     */
    List<Dictionary> getJcxmByJcdbh(String qybh, String jcdbh);
}
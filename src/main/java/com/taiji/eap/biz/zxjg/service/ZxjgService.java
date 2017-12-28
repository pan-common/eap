package com.taiji.eap.biz.zxjg.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import java.util.List;

public interface ZxjgService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
    /**
     * 插入数据
     * @param zxjg
     * @return
     */
    int insert(Zxjg zxjg) throws Exception;

    /**
     * 批量插入
     * @param zxjgs
     * @return
     * @throws Exception
     */
    int plInser(List<Zxjg> zxjgs) throws Exception;

     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Zxjg selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param zxjg
     * @return
     */
    int updateByPrimaryKey(Zxjg zxjg) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Zxjg> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Zxjg> list(int pageNum, int pageSize, String searchText) throws Exception;

}
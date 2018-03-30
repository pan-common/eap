package com.taiji.eap.biz.jcxmjg.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.jcxmjg.bean.Jcxmjg;
import java.util.List;

public interface JcxmjgService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param jcxmjg
     * @return
     */
    int insert(Jcxmjg jcxmjg) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Jcxmjg selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param jcxmjg
     * @return
     */
    int updateByPrimaryKey(Jcxmjg jcxmjg) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Jcxmjg> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Jcxmjg> list(int pageNum, int pageSize, String searchText) throws Exception;

}
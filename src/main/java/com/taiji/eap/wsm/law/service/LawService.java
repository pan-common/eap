package com.taiji.eap.wsm.law.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.wsm.law.bean.Law;
import java.util.List;

public interface LawService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 插入数据
     * @param law
     * @return
     */
    int insert(Law law) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Law selectByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param law
     * @return
     */
    int updateByPrimaryKey(Law law) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Law> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Law> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 选择性插入
    * @param law
    * @return
    */
    int insertSelective(Law law);
    /**
    * 选择性修改
    * @param law
    * @return
    */
    int updateByPrimaryKeySelective(Law law);
    /**
    * 按条件查询
    * @param law
    * @return
    */
    List<Law> queryAll(Law law);

    /**
     * 查询全部法律法规
     * @return
     */
    List<Law> selectAll() throws Exception;
}
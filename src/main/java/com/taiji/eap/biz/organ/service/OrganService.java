package com.taiji.eap.biz.organ.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.organ.bean.Organ;
import java.util.List;

public interface OrganService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param organ
     * @return
     */
    int insert(Organ organ) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Organ selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param organ
     * @return
     */
    int updateByPrimaryKey(Organ organ) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Organ> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Organ> list(int pageNum, int pageSize, String searchText) throws Exception;

     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<Organ> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<Organ> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<Organ> getPath(Long primaryKey) throws Exception;

}
package com.taiji.eap.biz.qyjcxx.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import java.util.List;
import java.util.Map;

public interface QyjcxxService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 插入数据
     * @param qyjcxx
     * @return
     */
    int insert(Qyjcxx qyjcxx) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Qyjcxx selectByPrimaryKey(Long primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param qyjcxx
     * @return
     */
    int updateByPrimaryKey(Qyjcxx qyjcxx) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Qyjcxx> list(String searchText) throws Exception;

    List<Map<String,String>> listMap(String searchText);

     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Qyjcxx> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * easyui提交数据
    * @return
    */
    int easyuiSubmitData(EasyUISubmitData<Qyjcxx> easyUISubmitData);
     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<Qyjcxx> listByPid(Long parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<Qyjcxx> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<Qyjcxx> getPath(Long primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<LayuiTree> treeView(Long parentId) throws Exception;

}
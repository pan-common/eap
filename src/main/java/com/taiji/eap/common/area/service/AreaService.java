package com.taiji.eap.common.area.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.area.bean.Area;
import java.util.List;

public interface AreaService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Integer primaryKey) throws Exception;
     /**
     * 插入数据
     * @param area
     * @return
     */
    int insert(Area area) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Area selectByPrimaryKey(Integer primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param area
     * @return
     */
    int updateByPrimaryKey(Area area) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Area> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Area> list(int pageNum, int pageSize, String searchText) throws Exception;
     /**
     * 通过父节点查询数据
     * @param parentId
     * @return
     */
    List<Area> listByPid(Integer parentId) throws Exception;
    /**
    * 通过父节点分页查询数据
    * @param parentId
    * @param pageNum
    * @param pageSize
    * @param searchText
    * @return
    * @throws Exception
    */
    PageInfo<Area> listByPid(Integer parentId, int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 通过当前节点主键获取路径列表
    * @param primaryKey
    * @return
    */
    List<Area> getPath(Integer primaryKey) throws Exception;
    /**
    * 显示树状视图
    * @param parentId
    * @return
    * @throws Exception
    */
    List<BaseTree> treeView(Integer parentId) throws Exception;

    /**
     * 查询全部区划数据
     * @return
     */
    List<Area> selectAll() throws Exception;

    List<Area> selectByIds(List<Integer> areaIds);
}
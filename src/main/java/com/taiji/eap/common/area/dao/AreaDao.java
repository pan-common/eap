package com.taiji.eap.common.area.dao;

import com.taiji.eap.common.area.bean.Area;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface AreaDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Integer primaryKey);
     /**
     * 添加数据
     * @param area
     * @return
     */
    int insert(Area area);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Area selectByPrimaryKey(Integer primaryKey);
     /**
     * 修改数据
     * @param area
     * @return
     */
    int updateByPrimaryKey(Area area);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Area> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Area> selectAll();

    /**
     * 查询三级区划数据
     * @return
     */
    List<Area> selectLevel3();

     /**
     * 通过父节点ID搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Area> listByPid(@Param("parentId") Integer parentId,@Param("searchText") String searchText);

}
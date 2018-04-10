package com.taiji.eap.common.app.device.dao;

import com.taiji.eap.common.app.device.bean.Device;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DeviceDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param device
     * @return
     */
    int insert(Device device);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Device selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param device
     * @return
     */
    int updateByPrimaryKey(Device device);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Device> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Device> selectAll();
    /**
     * 选择性插入
     * @param dmsctest
     * @return
     */
    int insertSelective(Device device);
    /**
     * 选择性修改
     * @param dmsctest
     * @return
     */
    int updateByPrimaryKeySelective(Device device);
    /**
     * 按条件查询
     * @param dmsctest
     * @return
     */
    List<Device> queryAll(Device device);
}
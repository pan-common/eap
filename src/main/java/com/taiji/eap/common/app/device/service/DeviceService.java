package com.taiji.eap.common.app.device.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.app.device.bean.Device;
import java.util.List;

public interface DeviceService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 插入数据
     * @param device
     * @return
     */
    int insert(Device device) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Device selectByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param device
     * @return
     */
    int updateByPrimaryKey(Device device) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Device> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Device> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 选择性插入
    * @param device
    * @return
    */
    int insertSelective(Device device);
    /**
    * 选择性修改
    * @param device
    * @return
    */
    int updateByPrimaryKeySelective(Device device);
    /**
    * 按条件查询
    * @param device
    * @return
    */
    List<Device> queryAll(Device device);
}
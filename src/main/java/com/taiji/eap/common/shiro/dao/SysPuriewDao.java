package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysPuriew;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysPuriewDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param sysPuriew
     * @return
     */
    int insert(SysPuriew sysPuriew);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    SysPuriew selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param sysPuriew
     * @return
     */
    int updateByPrimaryKey(SysPuriew sysPuriew);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<SysPuriew> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<SysPuriew> selectAll();


}
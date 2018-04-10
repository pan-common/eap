package com.taiji.eap.common.file.dao;

import com.taiji.eap.common.file.bean.CommonFileInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface FileDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param file
     * @return
     */
    int insert(CommonFileInfo file);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    CommonFileInfo selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param file
     * @return
     */
    int updateByPrimaryKey(CommonFileInfo file);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<CommonFileInfo> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<CommonFileInfo> selectAll();


}
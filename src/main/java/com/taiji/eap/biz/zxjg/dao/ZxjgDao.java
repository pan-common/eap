package com.taiji.eap.biz.zxjg.dao;

import com.taiji.eap.biz.zxjg.bean.Zxjg;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ZxjgDao{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param zxjg
     * @return
     */
    int insert(Zxjg zxjg);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Zxjg selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param zxjg
     * @return
     */
    int updateByPrimaryKey(Zxjg zxjg);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Zxjg> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Zxjg> selectAll();


}
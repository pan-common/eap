package com.taiji.eap.biz.jcxmjg.dao;

import com.taiji.eap.biz.jcxmjg.bean.Jcxmjg;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface JcxmjgDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param jcxmjg
     * @return
     */
    int insert(Jcxmjg jcxmjg);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Jcxmjg selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param jcxmjg
     * @return
     */
    int updateByPrimaryKey(Jcxmjg jcxmjg);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Jcxmjg> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Jcxmjg> selectAll();


}
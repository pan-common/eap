package com.taiji.eap.common.form.formconf.dao;

import com.taiji.eap.common.form.formconf.bean.Formconf;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface FormconfDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Long primaryKey);
     /**
     * 添加数据
     * @param formconf
     * @return
     */
    int insert(Formconf formconf);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Formconf selectByPrimaryKey(Long primaryKey);
     /**
     * 修改数据
     * @param formconf
     * @return
     */
    int updateByPrimaryKey(Formconf formconf);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Formconf> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Formconf> selectAll();


}
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
     * @param qybh 企业编号
      *@param jcdid 监测点ID
      * @param startDate 开始时间
      * @param endDate 结束时间
      * @return
     */
    List<Zxjg> list(@Param("searchText") String searchText,
                    @Param("qybh") String qybh,
                    @Param("jcdid") String jcdid,
                    @Param("startDate") String startDate,
                    @Param("endDate") String endDate);

     /**
     * 查询全部数据
     * @return
     */
    List<Zxjg> selectAll();

    /**
     *
     * @param qybh 企业编号
     * @param jcdbh 监测点编号
     * @param sj 时间
     * @return
     */
    int deleteByZxjg(@Param("qybh") String qybh,@Param("jcdbh") String jcdbh,@Param("sj") String sj);
}
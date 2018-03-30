package com.taiji.eap.wsm.baseInfo.dao;

import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BaseInfoDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param baseInfo
     * @return
     */
    int insert(BaseInfo baseInfo);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    BaseInfo selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param baseInfo
     * @return
     */
    int updateByPrimaryKey(BaseInfo baseInfo);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<BaseInfo> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<BaseInfo> selectAll();
    /**
     * 选择性插入
     * @param baseInfo
     * @return
     */
    int insertSelective(BaseInfo baseInfo);
    /**
     * 选择性修改
     * @param baseInfo
     * @return
     */
    int updateByPrimaryKeySelective(BaseInfo baseInfo);
    /**
     * 按条件查询
     * @param baseInfo
     * @return
     */
    List<BaseInfo> queryAll(BaseInfo baseInfo);

    /**
     * 通过任务ID查询成员列表
     * @param taskId 任务ID
     * @param isPrincipal 是否主要负责人
     * @return
     */
    List<BaseInfo> selectByTaskId(@Param("taskId") String taskId,@Param("isPrincipal")String isPrincipal);

    /**
     * 通过用户ID查询用户信息
     * @param userId 用户ID
     * @return
     */
    BaseInfo selectOneByUserId(Long userId);
}
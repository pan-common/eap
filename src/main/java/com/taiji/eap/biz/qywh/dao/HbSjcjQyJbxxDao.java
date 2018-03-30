package com.taiji.eap.biz.qywh.dao;

import com.taiji.eap.biz.qywh.bean.HbSjcjQyJbxx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public interface HbSjcjQyJbxxDao {

    /**
     * 通过企业名称查询企业基本信息
     * @param qymc
     * @return
     */
    List<HbSjcjQyJbxx> selectByQymc(@Param("qymc") String qymc);

}

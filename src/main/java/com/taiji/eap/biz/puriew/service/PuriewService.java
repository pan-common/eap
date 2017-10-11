
package com.taiji.eap.biz.puriew.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.biz.puriew.bean.Puriew;
import java.util.List;

public interface PuriewService{

    int deleteByPrimaryKey(Long primaryKey) throws Exception;

    int insert(Puriew puriew) throws Exception;

    Puriew selectByPrimaryKey(Long primaryKey) throws Exception;

    int updateByPrimaryKey(Puriew puriew) throws Exception;

    List<Puriew> list(String searchText) throws Exception;

    PageInfo<Puriew> list(int pageNum, int pageSize, String searchText) throws Exception;

}
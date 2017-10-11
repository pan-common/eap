
package com.taiji.eap.biz.puriew.dao;

import com.taiji.eap.biz.puriew.bean.Puriew;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PuriewDao {

    int deleteByPrimaryKey(Long primaryKey);

    int insert(Puriew puriew);

    Puriew selectByPrimaryKey(Long primaryKey);

    int updateByPrimaryKey(Puriew puriew);

    List<Puriew> list(@Param("searchText") String searchText);

}
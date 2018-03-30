package com.taiji.eap.biz.qywh.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.qywh.bean.HbSjcjQyJbxx;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HbSjcjQyJbxxService {

    PageInfo<HbSjcjQyJbxx> selectByQymc(int pageNum, int pageSize, String qymc);

}

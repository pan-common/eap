package com.taiji.eap.common.dictionary.service;

import com.taiji.eap.common.dictionary.bean.Dictionary;

import java.util.List;

public interface DictionaryService {

    public List<Dictionary> selectByPid(Long parentId);
}

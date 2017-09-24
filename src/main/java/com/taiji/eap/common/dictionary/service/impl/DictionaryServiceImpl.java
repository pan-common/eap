package com.taiji.eap.common.dictionary.service.impl;

import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService{

    @Override
    public List<Dictionary> selectByPid(Long parentId) {
        List<Dictionary> dictionaries = new ArrayList<Dictionary>();
        dictionaries.add(new Dictionary("01","书包"));
        dictionaries.add(new Dictionary("02","铅笔"));
        dictionaries.add(new Dictionary("03","橡皮"));
        dictionaries.add(new Dictionary("04","文具盒"));
        dictionaries.add(new Dictionary("05","铅笔刀"));
        return dictionaries;
    }

}

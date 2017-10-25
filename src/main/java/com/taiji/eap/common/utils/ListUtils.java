package com.taiji.eap.common.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<Long> stringToLongLst(List<String> inList){
        List<Long> iList =new ArrayList<Long>(inList.size());
        CollectionUtils.collect(inList,
                new Transformer(){
                    public java.lang.Object transform(java.lang.Object input){
                        return new Long((String)input);
                    }
                } ,iList );
        return iList;
    }

}

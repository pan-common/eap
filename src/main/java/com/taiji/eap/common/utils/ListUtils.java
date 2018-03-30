package com.taiji.eap.common.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    /**
     *
     * @param inList
     * @return
     */
    public static List<Long> stringToLongLst(List<String> inList){
        List<Long> iList =new ArrayList<Long>(inList.size());
        CollectionUtils.collect(inList,
                new Transformer(){
                    @Override
                    public java.lang.Object transform(java.lang.Object input){
                        return new Long((String)input);
                    }
                } ,iList );
        return iList;
    }

    /**
     *
     * @param inList
     * @return
     */
    public static List<Integer> stringToIntegerLst(List<String> inList){
        List<Integer> iList = new ArrayList<Integer>(inList.size());
        CollectionUtils.collect(inList,
                new Transformer() {
                    @Override
                    public Object transform(Object o) {
                        return new Integer(Integer.valueOf(o.toString()));
                    }
                },iList);
        return iList;
    }

}

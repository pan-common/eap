package com.taiji.eap.common.utils;

import com.google.gson.Gson;

/**
 * @author 潘宏智
 * @date
 */
public class GsonUtils {

    public static String toJson(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}

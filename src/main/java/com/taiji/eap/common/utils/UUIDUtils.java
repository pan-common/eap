package com.taiji.eap.common.utils;

import java.util.UUID;

public class UUIDUtils {
	
	/**
     * 获取32位guid的唯一表示
     */
    public static String getGUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}

package com.amayadream.shiro.utils;

import java.util.UUID;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 16:50
 */
public class UUIDHelper {

    /**
     * 生成32位uuid
     * @return
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

}

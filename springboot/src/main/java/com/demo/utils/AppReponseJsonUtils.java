package com.demo.utils;

import java.util.Map;

/**
 * 主要用于App返回数据的拼装
 * 主要用户判断 用户重复登录设备，和Session失效
 * */
public class AppReponseJsonUtils {


    /**
     *
     * 不设置返回信息的参数
     * */
    public static Map setData(Map map){
        map.put("code",0);
        map.put("msg","操作成功");
        map.put("sessionTerminate",false);
        return  map;
    }

    /**
     *
     * 返回成功的参数设置
     * */
    public static Map setMessage(Map map, String message){
        map.put("code",0);
        map.put("msg",message);
        map.put("sessionTerminate",false);
        return  map;
    }

    /**
     *
     * 操作失败的参数设置
     * */
    public static Map setFail(Map map, String message){
        map.put("code",1);
        map.put("msg",message);
        map.put("sessionTerminate",false);
        return  map;
    }
    /**
     *
     * session失效的参数返回
     * */
    public static Map setFailSession(Map map, String message){
        map.put("code",1);
        map.put("msg",message);
        map.put("sessionTerminate",true);
        return  map;
    }
}

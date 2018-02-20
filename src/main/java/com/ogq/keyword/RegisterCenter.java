package com.ogq.keyword;

import com.ogq.MoveDesk;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterCenter {
    public static Map<String, Object> OBJ_POOLS = new HashMap<String, Object>();
    public static Map<String, Map<String, Object>> KEYWORD_POOLS = new HashMap<String, Map<String, Object>>();

    static {
        // 对象池
        OBJ_POOLS.put(MoveDesk.class.getName(), new MoveDesk());
        // 关键字池
        KEYWORD_POOLS.put("张三", methodInfo(MoveDesk.class.getName(), "setZhangsan", new Class[]{}));
        KEYWORD_POOLS.put("把桌子从A地点搬到B地点", methodInfo(MoveDesk.class.getName(), "moveDeskFromA2B",new Class[]{String.class, String.class}));
    }


    public static Map<String, Object> methodInfo(String className, String methodName, Class<?>... paramTypes){
        Map<String,Object> methodInfo = new HashMap<String, Object>();
        methodInfo.put("class", className);
        methodInfo.put("method", methodName);
        methodInfo.put("paramTypes", paramTypes);
        return methodInfo;
    }
}

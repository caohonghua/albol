package org.caohh.albol.util;

import java.util.HashMap;
import java.util.Map;

public class RestUtil {
    private RestUtil(){}

    public Object success(Object object){
        Map<String,Object> map = new HashMap<>();
        map.put("code","20000");
        map.put("data",object);
        return map;
    }
}

package org.ep2.hrmsdt.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseJsonBuilder {
    // 返回正常 Map构造方法
    public static Map<String, Object> success(int code, String message, Object data) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", code);
        responseMap.put("message", message);
        responseMap.put("data", data);

        return responseMap;
    }

    // 返回错误 Map构造方法
    public static Map<String, Object> error(int code, String message) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", code);
        responseMap.put("message", message);
        responseMap.put("data", null);

        return responseMap;
    }
}

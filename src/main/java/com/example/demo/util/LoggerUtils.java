package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 项目名称：HengYuLogger
 * 项目版本：V1.0
 * 包名称：com.hengyu.logger
 * 创建人：yuqy
 * 创建时间：2017/3/29 18:24
 * 修改人：yuqy
 * 修改时间：2017/3/29 18:24
 * 修改备注：
 */
public final class LoggerUtils {

    private static final Gson gson = new Gson();

    public static final String LOGGER_RETURN = "_logger_return";

    private LoggerUtils() {}

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }

    /**
     * 获取请求参数
     */
    public static String getParameter(HttpServletRequest request) throws IOException {
        HashMap<String, Object> map = new LinkedHashMap<>();

        Map<String, String[]> getMap = request.getParameterMap();
        if (getMap != null && !getMap.isEmpty()) {
            map.putAll(getMap);
        }

        Map<String, Object> postMap = gson.fromJson(request.getReader(), Map.class);
        if (postMap != null && !postMap.isEmpty()) {
            map.putAll(postMap);
        }

        return JSON.toJSONString(map);
    }
}

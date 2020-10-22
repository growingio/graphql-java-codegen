package com.kobylynskyi.graphql.codegen.extension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Save operates map to [requests, projections]
 *
 * @author liguobin@growingio.com
 * @version 1.0, 2020/10/21
 */
final public class CodegenContext {

    /**
     * Configuration is not supported at the moment
     */
    public static final String RESOLVER_DEFAULT_IMPL_PREFIX = "Default";

    /**
     * To get request and project
     */
    private static Map<String, String> operateAndRequestMap = new ConcurrentHashMap<>();

    private static Map<String, String> operateAndProjectionMap = new ConcurrentHashMap<>();

    private static Map<String, String> entityAndProjectionMap = new ConcurrentHashMap<>();

    public static void addOperateRequestMapping(String key, String value) {
        operateAndRequestMap.put(key, value);
    }

    public static void addOperateProjectionMapping(String key, String value) {
        operateAndProjectionMap.put(key, value);
    }

    public static void addEntityProjectionMapping(String key, String value) {
        entityAndProjectionMap.put(key, value);
    }

    public static String getRequestByOperate(String key) {
        return operateAndRequestMap.get(key);
    }

    public static String getProjectionByOperate(String key) {
        return operateAndProjectionMap.get(key);
    }

    public static String getProjectionByEntity(String key) {
        return entityAndProjectionMap.get(key);
    }
}

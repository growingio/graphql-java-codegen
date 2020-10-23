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
     * To get request、response and project
     */
    private static Map<String, String> operateAndRequestMapping = new ConcurrentHashMap<>();

    private static Map<String, String> operateAndResponseMapping = new ConcurrentHashMap<>();


    private static Map<String, String> operateAndProjectionMapping = new ConcurrentHashMap<>();

    private static Map<String, String> entityAndProjectionMapping = new ConcurrentHashMap<>();

    public static void addOperateRequestMapping(String key, String value) {
        operateAndRequestMapping.put(key, value);
    }

    public static void addOperateProjectionMapping(String key, String value) {
        operateAndProjectionMapping.put(key, value);
    }

    public static void addEntityProjectionMapping(String key, String value) {
        entityAndProjectionMapping.put(key, value);
    }

    public static String getRequestByOperate(String key) {
        return operateAndRequestMapping.get(key);
    }

    public static String getProjectionByOperate(String key) {
        return operateAndProjectionMapping.get(key);
    }

    public static String getProjectionByEntity(String key) {
        return entityAndProjectionMapping.get(key);
    }

    public static String getResponseByOperate(String key) {
        return operateAndResponseMapping.get(key);
    }

    public static void addOperateResponseMapping(String key, String value) {
        operateAndResponseMapping.put(key, value);
    }


}

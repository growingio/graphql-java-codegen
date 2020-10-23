package com.kobylynskyi.graphql.codegen.extension.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liguobin@growingio.com
 * @version 1.0, 2020/10/22
 */
final public class JavaCollectionUtils {

    private JavaCollectionUtils() {

    }

    public static <K, V> Map<K, V> listToMap(final List<K> keys, final List<V> values) {
        return keys.stream().collect(Collectors.toMap(k -> k, k -> values.get(keys.indexOf(k))));

    }
}

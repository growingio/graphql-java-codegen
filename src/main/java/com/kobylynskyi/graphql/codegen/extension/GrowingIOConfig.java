package com.kobylynskyi.graphql.codegen.extension;

import java.util.Map;

/**
 * @author liguobin@growingio.com
 * @version 1.0, 2020/10/22
 */
public class GrowingIOConfig {

    private Integer responseProjectionMaxDepth = 3;
    private String graphQLServerHost;
    private Map<String, String> headers;

    public GrowingIOConfig(String graphQLServerHost) {
        this.graphQLServerHost = graphQLServerHost;
    }

    public GrowingIOConfig(String graphQLServerHost, Map<String, String> headers) {
        this.graphQLServerHost = graphQLServerHost;
        this.headers = headers;
    }

    public GrowingIOConfig(String graphQLServerHost, Integer responseProjectionMaxDepth) {
        this.responseProjectionMaxDepth = responseProjectionMaxDepth;
        this.graphQLServerHost = graphQLServerHost;
    }

    public GrowingIOConfig(String graphQLServerHost, Integer responseProjectionMaxDepth, Map<String, String> headers) {
        this.responseProjectionMaxDepth = responseProjectionMaxDepth;
        this.graphQLServerHost = graphQLServerHost;
        this.headers = headers;
    }


    private GrowingIOConfig() {
    }

    public Integer getResponseProjectionMaxDepth() {
        return responseProjectionMaxDepth;
    }

    public String getGraphQLServerHost() {
        return graphQLServerHost;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

}

package com.kobylynskyi.graphql.codegen.extension;

/**
 * @author liguobin@growingio.com
 * @version 1.0, 2020/10/22
 */
public class GrowingIOConfig {

    private Integer responseProjectionMaxDepth = 3;
    private String graphQLServerHost;
    private String authoritykey;
    private String authorityValue;


    public GrowingIOConfig(String graphQLServerHost) {
        this.graphQLServerHost = graphQLServerHost;
    }

    public GrowingIOConfig(Integer responseProjectionMaxDepth, String graphQLServerHost) {
        this.responseProjectionMaxDepth = responseProjectionMaxDepth;
        this.graphQLServerHost = graphQLServerHost;
    }

    public GrowingIOConfig(String graphQLServerHost, String authoritykey, String authorityValue) {
        this.graphQLServerHost = graphQLServerHost;
        this.authoritykey = authoritykey;
        this.authorityValue = authorityValue;
    }

    public GrowingIOConfig(Integer responseProjectionMaxDepth, String graphQLServerHost, String authoritykey, String authorityValue) {
        this.responseProjectionMaxDepth = responseProjectionMaxDepth;
        this.graphQLServerHost = graphQLServerHost;
        this.authoritykey = authoritykey;
        this.authorityValue = authorityValue;
    }


    private GrowingIOConfig() {
    }

    public String getAuthorityValue() {
        return authorityValue;
    }

    public String getAuthoritykey() {
        return authoritykey;
    }

    public Integer getResponseProjectionMaxDepth() {
        return responseProjectionMaxDepth;
    }

    public String getGraphQLServerHost() {
        return graphQLServerHost;
    }

}

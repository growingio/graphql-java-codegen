package com.kobylynskyi.graphql.codegen.extension.utils;

import com.kobylynskyi.graphql.codegen.extension.GrowingIOConfig;
import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLRequest;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * okhttp
 *
 * @author liguobin@growingio.com
 * @version 1.0, 2020/10/22
 */
final public class OkHttpUtils {

    private static OkHttpClient client;

    private static final String DEFAULT_MEDIA_TYPE = "application/json; charset=utf-8";

    private static final int CONNECT_TIMEOUT = 5;

    private static final int READ_TIMEOUT = 20;

    private static OkHttpClient getInstance() {
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient.Builder().
                            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).
                            readTimeout(READ_TIMEOUT, TimeUnit.MINUTES).build();
                }
            }
        }
        return client;
    }


    public static <T> T executeGraphQLRemote(final GrowingIOConfig growingIOConfig, final GraphQLRequest graphQLRequest, final Class<T> javaClass) throws IOException {

        if (growingIOConfig == null) {
            throw new IOException("exception in OkHttpUtils, GrowingIOConfig must be not equals to null");
        }

        if (growingIOConfig.getGraphQLServerHost() == null) {
            throw new IOException("exception in OkHttpUtils, graphQLServerHost must be not equals to null");
        }

        Request.Builder request = new Request.Builder()
                .url(growingIOConfig.getGraphQLServerHost())
                .post(RequestBody.create(graphQLRequest.toHttpJsonBody(), MediaType.parse(DEFAULT_MEDIA_TYPE)));

        Map<String, String> headers = growingIOConfig.getHeaders();

        if (!headers.isEmpty()) {
            for (String header : headers.keySet()) {
                request.addHeader(header, headers.get(header));
            }
        }
        Response response = getInstance().newCall(request.build()).execute();
        if (response.code() == 200 && response.body() != null) {
            T ret = Jackson.mapper().readValue(response.body().string(), javaClass);
            return ret;
        } else {
            throw new IOException("exception in OkHttpUtils, response body is: " + response.toString());
        }

    }

    private OkHttpUtils() {

    }

}
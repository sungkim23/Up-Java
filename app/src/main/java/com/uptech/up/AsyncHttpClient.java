package com.uptech.up;

import com.loopj.android.http.*;

/**
 * Created by sungkim on 6/12/16.
 */
public class AsyncHttpClient {
    private static final String BASE_URL = "http://demo-jdluna.rhcloud.com/api/identificador/0000045";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
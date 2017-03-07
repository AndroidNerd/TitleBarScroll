package com.example.nerd.rx_retrofit_okhttp.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nerd on 2017/3/1.
 */

public class HttpCommonInterceptor implements Interceptor {
    private Map<String, String> mHeaderParamsMap = new HashMap<>();

    public HttpCommonInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //get the old request
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.method(request.method(), request.body());
        //add common params into header
        if (mHeaderParamsMap.size() > 0) {
            for (Map.Entry<String, String> entry : mHeaderParamsMap.entrySet()) {
                requestBuilder.header(entry.getKey(), entry.getValue());
            }
        }
        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }

    public static class Builder {
        HttpCommonInterceptor mHttpCommonInterceptor;

        public Builder() {
            mHttpCommonInterceptor = new HttpCommonInterceptor();
        }

        public Builder addHeaderParams(String key, String value) {
            mHttpCommonInterceptor.mHeaderParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParams(String key, int value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, float value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, long value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, double value) {
            return addHeaderParams(key, String.valueOf(value));
        }


        public HttpCommonInterceptor build() {
            return mHttpCommonInterceptor;
        }
    }
}

package com.example.nerd.rx_retrofit_okhttp.http;

import com.example.nerd.rx_retrofit_okhttp.config.ApiConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nerd on 2017/3/1.
 */

public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 5;
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private static final int DEFAULT_WRITE_TIME_OUT = 10;

    private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();

    private Retrofit mRetrofit;

    private RetrofitServiceManager() {
        //create OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS);

        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("paltform", "android")
                .addHeaderParams("userToken", "1234343434dfdfd3434")
                .addHeaderParams("userId", "123445")
                .build();
        builder.addInterceptor(commonInterceptor);

        //create retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConfig.BASE_URL)
                .build();
    }

    public static RetrofitServiceManager getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new RetrofitServiceManager();
        }
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}

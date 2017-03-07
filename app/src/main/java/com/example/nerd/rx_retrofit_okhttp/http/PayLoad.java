package com.example.nerd.rx_retrofit_okhttp.http;

import rx.functions.Func1;

/**
 * Created by nerd on 2017/3/1.
 */

public class PayLoad<T> implements Func1<BaseResponse<T>, T> {
    @Override
    public T call(BaseResponse<T> tBaseResponse) {
        if (!tBaseResponse.isSuccess()) {
            throw new RunErr(tBaseResponse.status, tBaseResponse.message);
        }
        return tBaseResponse.data;
    }
}

package com.example.nerd.rx_retrofit_okhttp.http;

/**
 * Created by nerd on 2017/3/1.
 */

public class BaseResponse<T> {
    public int status;
    public String message;
    public T data;

    public boolean isSuccess() {
        return status == 200;
    }
}

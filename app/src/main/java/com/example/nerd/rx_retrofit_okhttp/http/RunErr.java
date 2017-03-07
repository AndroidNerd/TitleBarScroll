package com.example.nerd.rx_retrofit_okhttp.http;

/**
 * Created by nerd on 2017/3/1.
 */

public class RunErr extends RuntimeException {
    private int errCode;

    public RunErr(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}

package com.example.nerd.rx_retrofit_okhttp.http;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nerd on 2017/3/1.
 */

public class ObjectLoader {
    /**
     * @param observable
     * @param <T>
     * @return
     */
    protected <T> Observable<T> observe(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

package com.example.nerd.rx_retrofit_okhttp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * BaseActivity中统一处理 Sub
 * Created by nerd on 2017/3/1.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder;

    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mUnbinder = ButterKnife.bind(this);
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
        initSet();
    }

    /**
     * add subscription
     * @param subscription
     */
    public void addSubscription(Subscription subscription){
        mCompositeSubscription.add(subscription);
    }

    public abstract int getContentViewId();

    protected abstract void initSet();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if(mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }
}

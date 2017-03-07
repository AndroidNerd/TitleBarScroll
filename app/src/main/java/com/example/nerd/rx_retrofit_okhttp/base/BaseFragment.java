package com.example.nerd.rx_retrofit_okhttp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by nerd on 2017/3/1.
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder mUnbinder;

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView=inflater.inflate(getContentViewId(),container,false);
        mUnbinder= ButterKnife.bind(this,mRootView);
        mContext=getActivity();

        return mRootView;
    }
    protected abstract int getContentViewId();
    protected abstract int initSet(Bundle saveInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}

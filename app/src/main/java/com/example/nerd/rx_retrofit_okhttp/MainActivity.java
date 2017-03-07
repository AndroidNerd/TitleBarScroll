package com.example.nerd.rx_retrofit_okhttp;

import android.content.Intent;
import android.view.View;

import com.example.nerd.rx_retrofit_okhttp.activity.GankActivity;
import com.example.nerd.rx_retrofit_okhttp.activity.MovieActivity;
import com.example.nerd.rx_retrofit_okhttp.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initSet() {

    }
    @OnClick({R.id.btn_movie,R.id.btn_gank})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_movie:
                startActivity(new Intent(this,MovieActivity.class));
                break;
            case R.id.btn_gank:
                startActivity(new Intent(this,GankActivity.class));
                break;
        }
    }
}

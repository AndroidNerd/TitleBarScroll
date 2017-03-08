package com.example.nerd.rx_retrofit_okhttp;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.nerd.rx_retrofit_okhttp.activity.GankActivity;
import com.example.nerd.rx_retrofit_okhttp.activity.MovieActivity;
import com.example.nerd.rx_retrofit_okhttp.base.BaseActivity;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.banner)
    FlyBanner banner;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initSet() {
        //加载本地
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.headbg);
        images.add(R.drawable.headbg);
        banner.setImages(images);
        //加载网络图片
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("http://e.hiphotos.baidu.com/news/w%3D638/sign=4905f0747af082022d92923c73fafb8a/f9198618367adab4aea30f1482d4b31c8701e472.jpg");
        imgesUrl.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1681876004,4078626976&fm=23&gp=0.jpg");
        imgesUrl.add("https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E5%88%98%E6%B6%9B%E8%BD%AE%E6%92%AD%E5%9B%BE&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=1591682781,3548446950&os=3700920313,2021961178&simid=4236578991,744995290&pn=10&rn=1&di=194940847640&ln=1253&fr=&fmq=1488964280541_R&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fdynamic-image.yesky.com%2F1080x-%2FuploadImages%2F2015%2F336%2F18%2F65O40287011Z.jpg");
        imgesUrl.add("http://h.hiphotos.baidu.com/news/crop%3D0%2C1%2C321%2C192%3Bw%3D638/sign=a39c027772cb0a46916dd1795653da15/91ef76c6a7efce1b32792847a651f3deb58f65e9.jpg");
        banner.setImagesUrl(imgesUrl);
        banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick({R.id.btn_movie, R.id.btn_gank})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_movie:
                startActivity(new Intent(this, MovieActivity.class));
                break;
            case R.id.btn_gank:
                startActivity(new Intent(this, GankActivity.class));
                break;
        }
    }
}

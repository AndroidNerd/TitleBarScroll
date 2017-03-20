package com.example.nerd.rx_retrofit_okhttp;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.nerd.rx_retrofit_okhttp.activity.GankActivity;
import com.example.nerd.rx_retrofit_okhttp.activity.MovieActivity;
import com.example.nerd.rx_retrofit_okhttp.activity.MovieActivity2;
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
        imgesUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489986393351&di=465ff2f90ba9afaeefa9ddcecccfca02&imgtype=0&src=http%3A%2F%2Fdynamic-image.yesky.com%2F1080x-%2FuploadImages%2F2015%2F336%2F18%2F65O40287011Z.jpg");
        imgesUrl.add("http://h.hiphotos.baidu.com/news/crop%3D0%2C1%2C321%2C192%3Bw%3D638/sign=a39c027772cb0a46916dd1795653da15/91ef76c6a7efce1b32792847a651f3deb58f65e9.jpg");
        banner.setImagesUrl(imgesUrl);
        banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick({R.id.btn_movie, R.id.btn_movie2, R.id.btn_gank})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_movie:
                startActivity(new Intent(this, MovieActivity.class));
                break;
            case R.id.btn_movie2:
                startActivity(new Intent(this, MovieActivity2.class));
                break;
            case R.id.btn_gank:
                startActivity(new Intent(this, GankActivity.class));
                break;
        }
    }
}

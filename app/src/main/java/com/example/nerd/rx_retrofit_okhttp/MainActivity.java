package com.example.nerd.rx_retrofit_okhttp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nerd.rx_retrofit_okhttp.activity.GankActivity;
import com.example.nerd.rx_retrofit_okhttp.activity.MovieActivity;
import com.example.nerd.rx_retrofit_okhttp.base.BaseActivity;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NestedScrollView.OnScrollChangeListener {
    @BindView(R.id.banner)
    FlyBanner banner;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @BindView(R.id.ll_head)
    LinearLayout ll_head;
    @BindView(R.id.tv_scan)
    TextView tv_scan;
    @BindView(R.id.tv_gift)
    TextView tv_gift;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initSet() {
        Drawable scanDrawable = getResources().getDrawable(R.drawable.scan);
        scanDrawable.setBounds(0, 0, 40, 40);
        tv_scan.setCompoundDrawables(null, scanDrawable, null, null);

        Drawable gitDrawable = getResources().getDrawable(R.drawable.gift);
        gitDrawable.setBounds(0, 0, 40, 40);
        tv_gift.setCompoundDrawables(null, gitDrawable, null, null);

        ll_head.getBackground().setAlpha(0);
        scrollView.setOnScrollChangeListener(this);

        //加载本地
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.headbg);
        images.add(R.drawable.headbg);
        banner.setImages(images);
        //加载网络图片
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("http://e.hiphotos.baidu.com/news/w%3D638/sign=4905f0747af082022d92923c73fafb8a/f9198618367adab4aea30f1482d4b31c8701e472.jpg");
        imgesUrl.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1681876004,4078626976&fm=23&gp=0.jpg");
        imgesUrl.add("http://h.hiphotos.baidu.com/news/crop%3D0%2C1%2C321%2C192%3Bw%3D638/sign=a39c027772cb0a46916dd1795653da15/91ef76c6a7efce1b32792847a651f3deb58f65e9.jpg");
        banner.setImagesUrl(imgesUrl);
        banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
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

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY < ll_head.getHeight()) {
            float rate = (float) scrollY / ll_head.getHeight();
            ll_head.getBackground().setAlpha((int) (rate * 256));
        } else {
            ll_head.getBackground().setAlpha(255);
        }
    }
}

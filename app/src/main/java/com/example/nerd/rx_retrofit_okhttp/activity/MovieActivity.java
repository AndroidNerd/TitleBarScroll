package com.example.nerd.rx_retrofit_okhttp.activity;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nerd.rx_retrofit_okhttp.R;
import com.example.nerd.rx_retrofit_okhttp.base.BaseActivity;
import com.example.nerd.rx_retrofit_okhttp.http.RunErr;
import com.example.nerd.rx_retrofit_okhttp.movie.Movie;
import com.example.nerd.rx_retrofit_okhttp.movie.MovieAdapter;
import com.example.nerd.rx_retrofit_okhttp.movie.MovieLoader;

import java.util.List;

import butterknife.BindView;
import rx.functions.Action1;

/**
 * Created by nerd on 2017/3/1.
 */

public class MovieActivity extends BaseActivity {

    private MovieLoader mMovieLoader;
    private RecyclerView mRecycleView;
    private MovieAdapter mMovieAdapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rclv)
    RecyclerView rclv;

    @Override
    public int getContentViewId() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initSet() {
        mMovieLoader = new MovieLoader();

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setTitle(R.string.movie_list);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        mMovieAdapter = new MovieAdapter(this);
        rclv.addItemDecoration(new MoiveDecoration());
        rclv.setLayoutManager(manager);
        rclv.setAdapter(mMovieAdapter);

        getMovieList();
    }

    /**
     * getMovies
     */
    public void getMovieList() {
        mMovieLoader.getMovie(0, 10).subscribe(new Action1<List<Movie>>() {
            @Override
            public void call(List<Movie> movies) {
                mMovieAdapter.setMovies(movies);
                mMovieAdapter.notifyDataSetChanged();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                if (throwable instanceof RunErr) {

                }
            }
        });
    }

    public static class MoiveDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(0, 0, 0, 20);
        }
    }

}

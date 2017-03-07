package com.example.nerd.rx_retrofit_okhttp.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nerd.rx_retrofit_okhttp.R;

import java.util.List;

/**
 * Created by nerd on 2017/3/1.
 */

public class MovieAdapter extends RecyclerView.Adapter {
    private List<Movie> mMovies;
    private Context mContext;
    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }

    public MovieAdapter(Context context){
        mContext=context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Movie movie=mMovies.get(position);
        MovieHolder movieHolder=(MovieHolder)holder;
        Glide.with(mContext)
                .load(movie.images.small)
                .into(movieHolder.mImageView);
        Log.e("img", movie.images.small);
        movieHolder.time.setText("上映时间："+movie.year + "年");
        movieHolder.title.setText(movie.title);
        movieHolder.subTitle.setText(movie.original_title);
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView title;
        public TextView subTitle;
        public TextView time;

        public MovieHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_movie);
            title = (TextView) itemView.findViewById(R.id.tv_movie_title);
            subTitle = (TextView) itemView.findViewById(R.id.tv_sub_title);
            time = (TextView) itemView.findViewById(R.id.tv_movie_time);
        }
    }
}

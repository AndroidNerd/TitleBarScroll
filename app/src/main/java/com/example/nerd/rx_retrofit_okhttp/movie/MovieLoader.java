package com.example.nerd.rx_retrofit_okhttp.movie;

import com.example.nerd.rx_retrofit_okhttp.http.ObjectLoader;
import com.example.nerd.rx_retrofit_okhttp.http.RetrofitServiceManager;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nerd on 2017/3/2.
 */

public class MovieLoader extends ObjectLoader {
    private MovieService mMovieService;

    public MovieLoader() {
        mMovieService = RetrofitServiceManager.getInstance().create(MovieService.class);
    }

    public Observable<List<Movie>> getMovie(int start, int count) {
        return observe(mMovieService.getTop250(start, count))
                .map(new Func1<MovieSubject, List<Movie>>() {
                    @Override
                    public List<Movie> call(MovieSubject movieSubject) {
                        return movieSubject.subjects;
                    }
                });
    }

    public Observable<String> getWeatherList(String cityId, String key) {
        return observe(mMovieService.getWeather(cityId, key))
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return null;
                    }
                });
    }
}

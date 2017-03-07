package com.example.nerd.rx_retrofit_okhttp.movie;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by nerd on 2017/3/2.
 */

public interface MovieService {
    @GET("top250")
    Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);

    @FormUrlEncoded
    @POST("/x3/weather")
    Observable<String> getWeather(@Field("cityId") String cityId, @Field("key") String key);
}

package com.mindorks.example.android_dagger2_example.retrofit;

import com.mindorks.example.android_dagger2_example.pojo.Film;
import com.mindorks.example.android_dagger2_example.pojo.StarWars;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by HashWaney on 2019/3/10.
 */

public interface APIInterface {
    @GET("people/?")
    Call<StarWars> getPeople(@Query("formate") String format);

    @GET
    Call<Film> getFilmData(@Url String url, @Query("format") String format);
}

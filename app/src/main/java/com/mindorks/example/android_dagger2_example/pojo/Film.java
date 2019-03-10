package com.mindorks.example.android_dagger2_example.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HashWaney on 2019/3/10.
 */

public class Film {
    @SerializedName("title")
    public String title;
    @SerializedName("director")
    public String director;
}

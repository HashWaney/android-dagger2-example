package com.mindorks.example.android_dagger2_example.di.module;

import android.content.Context;

import com.mindorks.example.android_dagger2_example.MainActivity;
import com.mindorks.example.android_dagger2_example.di.component.MainActivityComponent;
import com.mindorks.example.android_dagger2_example.di.qualifier.ActivityContext;
import com.mindorks.example.android_dagger2_example.di.scrops.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HashWaney on 2019/3/10.
 */
@Module
public class MainActivityContextModule {


    private MainActivity mainActivity;

    public Context context;


    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }


    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }


}

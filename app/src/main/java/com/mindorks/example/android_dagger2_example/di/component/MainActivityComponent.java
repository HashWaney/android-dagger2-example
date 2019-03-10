package com.mindorks.example.android_dagger2_example.di.component;

import android.content.Context;

import com.mindorks.example.android_dagger2_example.MainActivity;
import com.mindorks.example.android_dagger2_example.di.module.AdapterModule;
import com.mindorks.example.android_dagger2_example.di.qualifier.ActivityContext;
import com.mindorks.example.android_dagger2_example.di.scrops.ActivityScope;

import dagger.Component;

/**
 * Created by HashWaney on 2019/3/10.
 */
@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponents.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);

}

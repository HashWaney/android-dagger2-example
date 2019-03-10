package com.mindorks.example.android_dagger2_example;

import android.app.Activity;
import android.app.Application;

import com.mindorks.example.android_dagger2_example.di.component.ApplicationComponents;
import com.mindorks.example.android_dagger2_example.di.component.DaggerActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.DaggerApplicationComponent;
import com.mindorks.example.android_dagger2_example.di.module.ContextModule;

import dagger.android.support.DaggerApplication;

/**
 * Created by HashWaney on 2019/3/10.
 */

public class MyApplication extends Application {
    ApplicationComponents applicationComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponents =
                DaggerApplicationComponent.builder()
                        .contextModule(new ContextModule(this))
                        .build();
        applicationComponents.injectApplication(this);
    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponents getApplicationComponents() {
        return applicationComponents;
    }
}

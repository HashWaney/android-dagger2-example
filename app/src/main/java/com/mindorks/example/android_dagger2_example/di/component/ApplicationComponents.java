package com.mindorks.example.android_dagger2_example.di.component;

import android.content.Context;

import com.mindorks.example.android_dagger2_example.MyApplication;
import com.mindorks.example.android_dagger2_example.di.module.ContextModule;
import com.mindorks.example.android_dagger2_example.di.module.RetrofitModule;
import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.scrops.ApplicationScope;
import com.mindorks.example.android_dagger2_example.retrofit.APIInterface;

import dagger.Component;

/**
 * Created by HashWaney on 2019/3/10.
 */
@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponents {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);




}

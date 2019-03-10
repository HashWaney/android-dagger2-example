package com.mindorks.example.android_dagger2_example.di.module;

import android.content.Context;

import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.scrops.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HashWaney on 2019/3/10.
 */
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }


}

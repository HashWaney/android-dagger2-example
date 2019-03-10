package com.mindorks.example.android_dagger2_example.di.component;

import com.mindorks.example.android_dagger2_example.DetailActivity;
import com.mindorks.example.android_dagger2_example.di.scrops.ActivityScope;

import dagger.Component;

/**
 * Created by HashWaney on 2019/3/10.
 */
@Component(dependencies = ApplicationComponents.class)
@ActivityScope
public interface DetailActivityComponent {

    void inject(DetailActivity detailActivity)
            ;


}

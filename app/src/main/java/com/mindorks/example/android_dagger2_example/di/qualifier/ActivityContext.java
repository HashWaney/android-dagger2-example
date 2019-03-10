package com.mindorks.example.android_dagger2_example.di.qualifier;

import javax.inject.Qualifier;

/**
 * Created by HashWaney on 2019/3/10.
 * qualifier:用于在运行时区分context是Activity还是
 * application
 */
@Qualifier
public @interface ActivityContext {
}

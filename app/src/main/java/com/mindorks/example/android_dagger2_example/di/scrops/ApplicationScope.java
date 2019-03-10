package com.mindorks.example.android_dagger2_example.di.scrops;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by HashWaney on 2019/3/10.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ApplicationScope {
}

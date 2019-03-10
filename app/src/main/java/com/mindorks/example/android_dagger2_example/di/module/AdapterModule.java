package com.mindorks.example.android_dagger2_example.di.module;

import com.mindorks.example.android_dagger2_example.MainActivity;
import com.mindorks.example.android_dagger2_example.adapter.RecyclerViewAdapter;
import com.mindorks.example.android_dagger2_example.di.scrops.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HashWaney on 2019/3/10.
 */
@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return (RecyclerViewAdapter.ClickListener) mainActivity;
    }


}

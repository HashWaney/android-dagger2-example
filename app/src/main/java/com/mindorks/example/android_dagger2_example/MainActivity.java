package com.mindorks.example.android_dagger2_example;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mindorks.example.android_dagger2_example.adapter.RecyclerViewAdapter;
import com.mindorks.example.android_dagger2_example.di.component.ApplicationComponents;
import com.mindorks.example.android_dagger2_example.di.component.DaggerMainActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.MainActivityComponent;
import com.mindorks.example.android_dagger2_example.di.module.MainActivityContextModule;
import com.mindorks.example.android_dagger2_example.di.qualifier.ApplicationContext;
import com.mindorks.example.android_dagger2_example.pojo.StarWars;
import com.mindorks.example.android_dagger2_example.retrofit.APIInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {


    private RecyclerView recyclerView;

    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context activityContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(MainActivity.class.getSimpleName(), "onCreate");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        ApplicationComponents applicationComponents = MyApplication.get(this).getApplicationComponents();

        mainActivityComponent = DaggerMainActivityComponent
                .builder()
                .mainActivityContextModule(new MainActivityContextModule(
                        this
                ))
                .applicationComponents(applicationComponents)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        apiInterface.getPeople("json")
                .enqueue(new Callback<StarWars>() {
                    @Override
                    public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                        populateRecycleView(response.body().results)
                        ;
                    }

                    @Override
                    public void onFailure(Call<StarWars> call, Throwable t) {
                        Log.e("MainActivity", "error:" + t.getMessage());
                    }
                });
    }

    private void populateRecycleView(List<StarWars.People> results) {
        recyclerViewAdapter.setData(results);
    }


    @Override
    public void launchIntent(String film) {
//        Log.e("MainActivity", "注入了监听器");
        Toast.makeText(activityContext, "当前点击:" + film, Toast.LENGTH_SHORT).show();
    }
}

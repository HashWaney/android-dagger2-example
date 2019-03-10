package com.mindorks.example.android_dagger2_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(MainActivity.class.getSimpleName(), "onCreate");
        setContentView(R.layout.activity_main);

    }


}

package com.example.androidpl_hw_2.task_1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidpl_hw_2.R;

public class MainActivityTask_1 extends AppCompatActivity {

    private static final String TAG = "MainActivityTask_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_task_1);
    }


    public void onClick(View view) {
        MyAsyncTaskTask myAsyncTaskTask = new MyAsyncTaskTask();
        myAsyncTaskTask.execute();

        Log.d(TAG, "The method that called AsyncTask is complete!");
    }
}

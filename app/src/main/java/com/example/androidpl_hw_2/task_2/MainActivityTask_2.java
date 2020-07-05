package com.example.androidpl_hw_2.task_2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidpl_hw_2.R;

public class MainActivityTask_2 extends AppCompatActivity {

    private Spam spam = new Spam();
    private static final String TAG = "MainActivityTask_2";
    private int currentSpam = 0;
    private int currentSubscriber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_task_2);
    }

    public void onClickRegister(View view) {
        currentSubscriber++;
        Subscriber subscriber = new Subscriber("Subscriber №" + currentSubscriber);
        spam.subscriber(subscriber);
    }

    public void onClickUnregister(View view) {
        spam.unSubscriber();
    }

    public void onClickEmitter(View view) {
        currentSpam++;
        spam.newSpam("Spam №" + currentSpam);
    }
}

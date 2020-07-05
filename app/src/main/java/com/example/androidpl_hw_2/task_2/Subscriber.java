package com.example.androidpl_hw_2.task_2;

import android.util.Log;

public class Subscriber implements Observer {

    private String nameSubscriber;
    private static final String TAG = "Subscriber";

    public Subscriber(String nameSubscriber) {
        this.nameSubscriber = nameSubscriber;
    }

    public String getNameSubscriber() {
        return nameSubscriber;
    }

    @Override
    public void mailingSpam(String name) {
        Log.d(TAG, "Пришел спам: " + name + ", получил подпичик: " + nameSubscriber);
    }
}

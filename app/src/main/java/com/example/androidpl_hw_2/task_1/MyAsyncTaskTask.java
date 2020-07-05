package com.example.androidpl_hw_2.task_1;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyAsyncTaskTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "MyAsyncTaskTask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 1; i < 6; i++) {
                TimeUnit.SECONDS.sleep(1);
                Log.d(TAG, Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}

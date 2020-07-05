package com.example.androidpl_hw_2.task_3;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MyPresenter {

    private static final String TAG = "Presenter";

    public Observable<Integer> startThread() {

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

                try {
                    for (int i = 1; i < 6; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String seconds = "second: " + i;
                        Log.d(TAG, Thread.currentThread().getName() + ": " + seconds);
                        emitter.onNext(i);
                    }
                } catch (InterruptedException e) {
                    Log.e(TAG, "Поток приостановлен!");
                }

                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }

}

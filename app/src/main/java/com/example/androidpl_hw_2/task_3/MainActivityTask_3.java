package com.example.androidpl_hw_2.task_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidpl_hw_2.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivityTask_3 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyPresenter myPresenter;
    private Observable<Integer> observable;
    private Disposable disposable;
    EditText textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_task_3);

        textResult = findViewById(R.id.text_result);
        myPresenter = new MyPresenter();
        observable = myPresenter.startThread();
    }

    public void onClickStart(View view) {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "Метод onSubscribe: Потое " + Thread.currentThread().getName() + ": Старт потока!");
                disposable = d;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "Метод onNext: Поток " + Thread.currentThread().getName() + ": second " + integer);
                textResult.setText("second: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Метод onComplete: Поток " + Thread.currentThread().getName() + ": Поток завершен");
                textResult.setText("Поток завершен");
            }
        });

        Log.d(TAG, "Метод onClickStart в потоке " + Thread.currentThread().getName() + " завершен.");
    }

    public void onClickStop(View view) {
        disposable.dispose();
        textResult.setText("Поток остановлен!");
    }
}

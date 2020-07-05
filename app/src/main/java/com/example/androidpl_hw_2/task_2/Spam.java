package com.example.androidpl_hw_2.task_2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Spam implements Observable {

    private List<Observer> subscribers;
    private static final String TAG = "Spam";
    private String nameSpam;

    public Spam() {
        subscribers = new ArrayList<>();
    }

    public void newSpam(String nameSpam) {
        this.nameSpam = nameSpam;
        notifyAllObserver();
    }

    @Override
    public void subscriber(Observer Observer) {
        Log.d(TAG, "На спам подписался: " + ((Subscriber) Observer).getNameSubscriber());
        subscribers.add(Observer);
    }

    @Override
    public void unSubscriber() {
        if (!subscribers.isEmpty()) {
            Log.d(TAG, "Отписался от спама: " + ((Subscriber) subscribers.get(subscribers.size() - 1)).getNameSubscriber());
            subscribers.remove(subscribers.size() - 1);
        } else {
            Log.d(TAG, "Некого отписывать!");
        }
    }

    @Override
    public void notifyAllObserver() {
        if (!subscribers.isEmpty()) {
            Log.d(TAG, "Рассылка спама:");
            for (int i = 0; i < subscribers.size(); i++) {
                subscribers.get(i).mailingSpam(nameSpam);
            }
        } else {
            Log.d(TAG, "Никто не подписан!");
        }
    }
}

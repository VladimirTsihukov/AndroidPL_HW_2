package com.example.androidpl_hw_2.task_2;

public interface Observable {
    void subscriber(Observer Observer);

    void unSubscriber();

    void notifyAllObserver();
}

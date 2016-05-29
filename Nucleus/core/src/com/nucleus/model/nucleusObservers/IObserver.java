package com.nucleus.model.nucleusObservers;

public interface IObserver<E> {
    void onObservation(IObservable<E> o, E arg);
}

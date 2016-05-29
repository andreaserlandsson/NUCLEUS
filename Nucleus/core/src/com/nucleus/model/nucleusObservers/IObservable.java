package com.nucleus.model.nucleusObservers;

public interface IObservable<E> {
    void addObserver(IObserver<E> o);
    void removeObserver(IObserver<E> o);
}

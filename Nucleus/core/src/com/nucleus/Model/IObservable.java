package com.nucleus.Model;

/**
 * Created by erik on 26/05/16.
 */
public interface IObservable<E> {
    void addObserver(IObserver<E> o);
    void removeObserver(IObserver<E> o);
}

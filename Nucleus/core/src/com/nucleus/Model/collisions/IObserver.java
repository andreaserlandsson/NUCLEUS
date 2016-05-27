package com.nucleus.Model.collisions;

/**
 * Created by erik on 26/05/16.
 */
public interface IObserver<E> {
    void onObservation(IObservable<E> o, E arg);
}

package com.nucleus.Model.level;

import com.nucleus.Model.nucleusObservers.IObservable;
import com.nucleus.Model.nucleusObservers.IObserver;

import java.util.ArrayList;

/**
 * Created by erik on 26/05/16.
 */
public class ObservableHelper<E> implements IObservable<E> {

    private ArrayList<IObserver<E>> observers;

    public ObservableHelper() {
        this.observers = new ArrayList<IObserver<E>>();
    }

    public void update(IObservable<E> o, E arg){
        for(IObserver<E> obs : observers){
            obs.onObservation(o,arg);
        }
    }

    @Override
    public void addObserver(IObserver<E> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver<E> o) {
        observers.remove(o);
    }
}
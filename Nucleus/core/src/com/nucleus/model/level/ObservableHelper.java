package com.nucleus.model.level;

import com.nucleus.model.nucleusObservers.IObservable;
import com.nucleus.model.nucleusObservers.IObserver;

import java.util.ArrayList;

public class ObservableHelper<E> implements IObservable<E> {

    private ArrayList<IObserver<E>> observers;

    public ObservableHelper() {
        this.observers = new ArrayList<IObserver<E>>();
    }

    /**
     * Sends updates to all observers in the internal observer list.
     * @param o the observable itself
     * @param arg an argument of generic type
     */
    public void update(IObservable<E> o, E arg){
        for(IObserver<E> obs : observers){
            obs.onObservation(o,arg);
        }
    }

    @Override
    public void addObserver(IObserver<E> o) {
        if(!observers.contains(o))
            observers.add(o);
    }

    @Override
    public void removeObserver(IObserver<E> o) {
        if(observers.contains(o))
            observers.remove(o);
    }
}
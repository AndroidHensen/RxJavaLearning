package com.hensen.rxjavalearning.Chapter10.Chapter10o1o2;

import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.ObservableOnSubscribe;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Observer;

/**
 * Created by handsomexu on 2018/10/8.
 */

public class ObservableCreate<T> extends Observable{

    private ObservableOnSubscribe source;

    public ObservableCreate(ObservableOnSubscribe observableOnSubscribe) {
        this.source = observableOnSubscribe;
    }

    @Override
    public void subscribeActual(Observer observer) {
        EmitterCreate<T> emitterCreate = new EmitterCreate<>(observer);
        observer.onSubscribe();

        source.subscribe(emitterCreate);
    }
}

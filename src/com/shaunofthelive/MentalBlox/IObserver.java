package com.shaunofthelive.MentalBlox;

public interface IObserver {

    enum State {
        ROLL_FOR_FIRST,
        PEG_PLACED
    }
    void update(State state);
}

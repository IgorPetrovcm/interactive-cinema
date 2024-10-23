package com.igorpetrovcm.interactive_cinema.usecase.port;

public interface CheckpointService{
    void let();

    void let(int sleepTime);
}
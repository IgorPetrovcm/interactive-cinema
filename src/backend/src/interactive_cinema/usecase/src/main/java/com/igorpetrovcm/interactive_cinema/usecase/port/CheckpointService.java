package com.igorpetrovcm.interactive_cinema.usecase.port;

public interface CheckpointService{
    void let() throws CheckpointServiceException;

    void let(int sleepTime) throws CheckpointServiceException;
}
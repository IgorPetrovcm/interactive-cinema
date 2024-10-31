package com.igorpetrovcm.interactive_cinema.usecase.port;

public class CheckpointServiceException extends Exception{
    public CheckpointServiceException(String message){
        super(message);
    }

    public CheckpointServiceException(String message, Throwable cause){
        super(message, cause);
    }
}

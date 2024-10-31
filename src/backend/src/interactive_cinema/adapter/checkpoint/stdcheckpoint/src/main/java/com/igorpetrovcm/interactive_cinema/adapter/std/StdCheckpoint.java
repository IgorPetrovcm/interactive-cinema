package com.igorpetrovcm.interactive_cinema.adapter.std;

import com.igorpetrovcm.interactive_cinema.usecase.port.CheckpointService;
import com.igorpetrovcm.interactive_cinema.usecase.port.CheckpointServiceException;
import com.igorpetrovcm.interactive_cinema.domain.Theater;

import java.util.concurrent.Semaphore;

public class StdCheckpoint implements CheckpointService{
    private final Theater theater;

    private final Semaphore semaphore;

    public StdCheckpoint(Theater theater){
        this.theater = theater;

        semaphore = new Semaphore(theater.getLimit());
    }
    
    @Override
    public void let() throws CheckpointServiceException{
        
    }

    @Override
    public void let(int sleepTime) throws CheckpointServiceException{
        try {
            semaphore.acquire();

            theater.increaseVisitors();
            
            Thread.sleep(sleepTime);

            theater.decreaseVisitors();
            
            semaphore.release();
        }
        catch (Exception exe){
            throw new CheckpointServiceException("", exe);
        }
    }
}
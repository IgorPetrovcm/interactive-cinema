package com.igorpetrovcm.interactive_cinema;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.igorpetrovcm.interactive_cinema.domain.Theater;
import com.igorpetrovcm.interactive_cinema.adapter.std.StdCheckpoint;
import com.igorpetrovcm.interactive_cinema.usecase.port.CheckpointServiceException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;

public class StdCheckpointTest {
    Theater theater = new Theater(3);

    @Test
    public void shouldWorkAllThreadPoolWhenCheckpointInvokePoolThroughLet()
        throws InterruptedException{
        StdCheckpoint checkpoint = new StdCheckpoint(theater);

        int numberOfVisitors = 5;
        CountDownLatch latch = new CountDownLatch(numberOfVisitors);

        ExecutorService threadPool = 
            Executors.newFixedThreadPool(numberOfVisitors);

        for (int i = 0; i < numberOfVisitors; i++){
            threadPool.submit(() ->{
                try{
                    checkpoint.let(100);
                }
                catch (CheckpointServiceException exe){
                    exe.printStackTrace();
                }

                latch.countDown();
            });
        }
        
        latch.await();

        Assertions.assertEquals(latch.getCount(), 0);
    }
}

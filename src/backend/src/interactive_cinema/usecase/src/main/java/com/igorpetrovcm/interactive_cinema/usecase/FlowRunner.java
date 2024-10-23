package com.igorpetrovcm.interactive_cinema.usecase;

// import com.igorpetrovcm.interactice_cinema.domain.Flow;
import com.igorpetrovcm.interactive_cinema.domain.Flow;
import com.igorpetrovcm.interactive_cinema.domain.FlowException;
import com.igorpetrovcm.interactive_cinema.usecase.port.CheckpointService;
import java.util.Random;
import java.util.Map.Entry;

public class FlowRunner implements Interactor<Object, Flow>{
    private final CheckpointService checkpoint;

    private final Random rand;

    /**
     * This is flow count, it is used to track 
     * the history of running flow 
     */
    private int flowCount = 0;

    public FlowRunner(CheckpointService checkpoint){
        this.checkpoint = checkpoint;

        rand = new Random();
    }
    
    public Object execute(Flow flow){
        Entry<Integer,Integer> sleepRange = flow.getSleepRange();

        flowCount++;
        
        int sleepTime = rand.nextInt(
            sleepRange.getKey(),
            sleepRange.getValue()
        );

        while (flow.getNumberOfVisitors() > 0){
            Thread
                .ofPlatform()
                .name("flow" + flowCount + "-visitor-" + flow.getNumberOfVisitors())
                .start(() -> { 
                    checkpoint.let(sleepTime);
                    /**
                    * This section of code needs to be logged
                    * Этот участок кода нужно логгировать
                    */
                });
            
            try{
                flow.completeVisitor();
            }
            catch(FlowException exe){
                /**
                 * This section of code needs to be logged
                 * Этот участок кода нужно логгировать
                 */
                exe.printStackTrace();
            }
        }
        
        return null;
    }


}

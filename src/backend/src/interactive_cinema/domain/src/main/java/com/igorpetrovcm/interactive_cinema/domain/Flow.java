package com.igorpetrovcm.interactive_cinema.domain;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Flow {
    private Entry<Integer, Integer> sleepRange;
    private int numberOfVisitors;

    public void completeVisitor() throws FlowException{
        if (numberOfVisitors - 1 < 0){
            throw new FlowException("The number of visitors cannot be less than 0");
        }
        numberOfVisitors--;
    }
    
    public Flow(){
    }

    public Flow(Entry<Integer, Integer> sleepRange){
        this.sleepRange = sleepRange; 
    }

    public Flow(int numberOfVisitors){
        this.numberOfVisitors = numberOfVisitors;
    }

    public Flow(SimpleEntry<Integer,Integer> sleepRange,
                int numberOfVisitors
    ){
        this.numberOfVisitors = numberOfVisitors;
        this.sleepRange = sleepRange;
    }

    public Entry<Integer, Integer> getSleepRange(){
        return sleepRange;
    }

    public void setSleepRange(SimpleEntry<Integer, Integer> sleepRange){
        this.sleepRange = sleepRange;
    }

    public int getNumberOfVisitors(){
        return numberOfVisitors;
    }

    public void setNumberOfVisitors(int numberOfVisitors){
        this.numberOfVisitors = numberOfVisitors;
    }
}

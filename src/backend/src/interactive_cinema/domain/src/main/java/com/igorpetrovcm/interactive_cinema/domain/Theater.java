package com.igorpetrovcm.interactive_cinema.domain;

public class Theater{
    private final int limit;

    private int visitors = 0;

    public Theater(int limit){
        this.limit = limit;
    }

    public int getLimit(){
        return limit;
    }

    public int getVisitors(){
        return visitors;
    }

    public void increaseVisitors() throws TheaterException{
        if (visitors == limit){
            throw new TheaterException("The visitor limit has been exceeded");
        }
        visitors++;
    }

    public void decreaseVisitors() throws TheaterException{
        if (visitors == 0){
            throw new TheaterException("The number of visitors cannot be less than 0");
        }
        visitors--;
    }
}
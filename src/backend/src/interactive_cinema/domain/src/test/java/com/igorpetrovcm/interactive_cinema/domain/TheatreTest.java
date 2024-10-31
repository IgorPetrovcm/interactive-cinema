package com.igorpetrovcm.interactive_cinema.domain;

import org.junit.jupiter.api.*;

public class TheatreTest{
    @Test
    public void shouldThrowAnExceptionWhenExceededLimit(){
        Theater theater = new Theater(0);

        Assertions.assertThrows(TheaterException.class, theater::increaseVisitors);
    }

    @Test
    public void shouldThrowAnExceptionWhenNumberVisitorIsBelowZero(){
        Theater theater = new Theater(0);

        Assertions.assertThrows(TheaterException.class, theater::decreaseVisitors);
    }
}
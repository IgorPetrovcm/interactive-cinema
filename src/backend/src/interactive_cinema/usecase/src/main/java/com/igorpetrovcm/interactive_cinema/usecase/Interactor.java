package com.igorpetrovcm.interactive_cinema.usecase;

public interface Interactor<T, E> {
    T execute(E data);
}

package com.decerto.dataProcessor;

public interface Processor<T> {
    T process(T[] data);
}

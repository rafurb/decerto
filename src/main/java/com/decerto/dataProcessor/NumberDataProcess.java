package com.decerto.dataProcessor;

public class NumberDataProcess implements DataProcess<Integer> {

    private final Integer value;

    public NumberDataProcess(Integer value){
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }

    @Override
    public String toString() {
        return "NumberDataProcess{" +
                "value=" + value +
                '}';
    }
}

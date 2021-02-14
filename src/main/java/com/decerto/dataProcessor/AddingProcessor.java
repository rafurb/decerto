package com.decerto.dataProcessor;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AddingProcessor implements Processor<NumberDataProcess> {

    @Override
    public NumberDataProcess process(NumberDataProcess[] data) {
        return Arrays.stream(data)
                .reduce(new NumberDataProcess(0), (sum, e) -> new NumberDataProcess(sum.get() + e.get()));
    }

    public static AddingProcessor getInstance() {
        return new AddingProcessor();
    }
}

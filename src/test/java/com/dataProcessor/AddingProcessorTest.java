package com.dataProcessor;

import com.decerto.dataProcessor.AddingProcessor;
import com.decerto.dataProcessor.NumberDataProcess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddingProcessorTest {

    @Test
    public void veryfiyProcess(){

        NumberDataProcess[] data = {
                new NumberDataProcess(1),
                new NumberDataProcess(2),
                new NumberDataProcess(3)};

        Assertions.assertEquals(AddingProcessor.getInstance().process(data).get(), 6);
    }
}

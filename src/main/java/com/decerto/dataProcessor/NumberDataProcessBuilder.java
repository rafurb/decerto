package com.decerto.dataProcessor;

import com.decerto.repo.NumberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class NumberDataProcessBuilder implements DataProcessBuilder<NumberDataProcess> {


    public static final String RANDOM_URL = "https://www.random.org/integers/";
    public static final String PARAMS = "?num=1&min=1&max=1000&col=1&base=10&format=plain&rnd=new";

    private final List<NumberDataProcess> data = new LinkedList<>();

    public NumberDataProcessBuilder addFromRandom(Random random){
        data.add(new NumberDataProcess(random.nextInt()));
        return this;
    }

    public NumberDataProcessBuilder addFromRepo(NumberRepository repo){
        data.add(new NumberDataProcess(new Integer(repo.getNumber().getValuee())));
        return this;
    }

    public NumberDataProcessBuilder addFromRest(RestTemplate rest){
        String random = callRestRandom(rest, RANDOM_URL, PARAMS);
        data.add(new NumberDataProcess(new Integer(random)));
        return this;
    }


    private String callRestRandom(RestTemplate rest, String url, String params){
        ResponseEntity<String> response
                = rest.getForEntity(url + params, String.class);
        try {
            return Objects.requireNonNull(response.getBody()).replaceAll("\\s+", "");
        } catch (NullPointerException e){
            return "0";
        }
    }

    @Override
    public NumberDataProcess[] build() {
        return data.toArray(new NumberDataProcess[0]);
    }
}

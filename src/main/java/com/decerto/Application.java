package com.decerto;

import java.util.Arrays;
import java.util.Random;

import com.decerto.dataProcessor.AddingProcessor;
import com.decerto.dataProcessor.NumberDataProcess;
import com.decerto.dataProcessor.NumberDataProcessBuilder;
import com.decerto.repo.NumberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static Logger LOG = LoggerFactory
            .getLogger(Application.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            NumberDataProcessBuilder builder = new NumberDataProcessBuilder();
            NumberDataProcess[] data = builder.addFromRandom(new Random())
                    .addFromRepo(ctx.getBean(NumberRepository.class))
                    .addFromRest(ctx.getBean(RestTemplate.class))
                    .build();
            Arrays.stream(data).forEach(e -> LOG.info(e.toString()));
            LOG.info("Sum=" + ctx.getBean(AddingProcessor.class).process(data).get().toString());
        };
    }

}
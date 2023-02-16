package com.example.pg_queque;

import com.example.pg_queque.service.TaskConsumer;
import com.example.pg_queque.service.TaskErrorConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class PgQuequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgQuequeApplication.class, args);
    }


    private final TaskConsumer taskConsumer;
    private final TaskErrorConsumer taskErrorConsumer;

    @Autowired
    public PgQuequeApplication(TaskConsumer taskConsumer, TaskErrorConsumer taskErrorConsumer) {
        this.taskConsumer = taskConsumer;
        this.taskErrorConsumer = taskErrorConsumer;
    }

    @Bean
    CommandLineRunner lineRunner() {
        return (args) -> {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(taskConsumer);
            executor.submit(taskErrorConsumer);
        };
    }
}

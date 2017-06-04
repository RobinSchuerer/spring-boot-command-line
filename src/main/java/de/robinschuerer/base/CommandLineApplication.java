package de.robinschuerer.base;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineApplication implements CommandLineRunner {

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(args[0]);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommandLineApplication.class, args);
    }
}

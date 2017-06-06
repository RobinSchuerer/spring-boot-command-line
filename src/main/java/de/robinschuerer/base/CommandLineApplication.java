package de.robinschuerer.base;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.robinschuerer.base.argument.ArgumentParser;
import de.robinschuerer.base.argument.IndexerConfiguration;
import de.robinschuerer.base.indexservice.ElasticSearchIndexService;

@SpringBootApplication
public class CommandLineApplication implements CommandLineRunner {

    @Autowired
    private ArgumentParser argumentParser;

    @Autowired
    private ElasticSearchIndexService indexService;

    @Override
    public void run(final String... args) throws Exception {
        final IndexerConfiguration configuration = argumentParser.parse(args);

        if (configuration.isInValid()) {
            throw new IllegalArgumentException(configuration.getErrorMessage());
        }

        final File file = configuration.getDataFile();

        indexService.index(file);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommandLineApplication.class, args);
    }
}

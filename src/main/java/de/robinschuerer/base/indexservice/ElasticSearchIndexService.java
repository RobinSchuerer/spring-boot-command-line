package de.robinschuerer.base.indexservice;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ElasticSearchIndexService {

    private final static String INDEX_NAME = "data";

    public void index(final File dataFile) {

    }
}

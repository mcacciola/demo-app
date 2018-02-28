package com.homedepot.demo;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.homedepot.demo.config.GoogleCloudProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Profile("integration-test")
@Configuration
public class SpannerClient {


    private RemoteSpannerHelper helper;
    private GoogleCloudProperties googleCloudProperties;
    private static final Logger log = LoggerFactory.getLogger(SpannerClient.class);

    @Autowired
    public SpannerClient(RemoteSpannerHelper helper, GoogleCloudProperties googleCloudProperties){
        this.helper = helper;
        this.googleCloudProperties = googleCloudProperties;
    }

    /**
     * Read ddl file and convert to String
     *
     * @param input
     * @return
     * @throws IOException
     */
    private static String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input, "UTF-8"))) {
            return buffer.lines().filter(s -> !s.trim().isEmpty()).collect(Collectors.joining(System.lineSeparator()));
        }
    }

    /**
     * Create a Spanner database client and execute DDL file mentioned in the application.yml (ddls)
     *
     * @return
     * @throws Throwable
     */
    @Bean
    public DatabaseClient createDatabaseClient() throws Throwable {
        Database db;
        if(this.googleCloudProperties.getSpanner().getDdls() != null && this.googleCloudProperties.getSpanner().getDdls().exists()){
            List<String> ddls = Arrays.asList(read(this.googleCloudProperties.getSpanner().getDdls().getInputStream()).replaceAll("[^\\p{ASCII}]", "").split(";"));
            db = helper.createTestDatabase(ddls);
            log.info("Google cloud props exist.");
        } else {
            db = helper.createTestDatabase();
            log.info("Google cloud props DOES NOT exist.");
        }
        DatabaseClient client = helper.getDatabaseClient(db);
        return client;
    }

}

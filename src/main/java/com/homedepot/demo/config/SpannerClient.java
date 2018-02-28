package com.homedepot.demo.config;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud-spanner")

@ConfigurationProperties(prefix = "google.cloud")
public class SpannerClient {

    private static final Logger log = LoggerFactory.getLogger(SpannerClient.class);


    private GoogleCloudProperties googleCloudProperties;

    @Autowired
    public SpannerClient(GoogleCloudProperties googleCloudProperties) {
        this.googleCloudProperties = googleCloudProperties;
    }

    @Bean
    public DatabaseClient getDatabaseClient() {

        SpannerOptions spannerOptions = SpannerOptions
                .newBuilder()
                .build();

        DatabaseClient dbClient = SpannerOptions
                .newBuilder()
                .build()
                .getService()
                .getDatabaseClient(DatabaseId.of(googleCloudProperties.getProjectId(), googleCloudProperties.getSpanner().getInstance(), googleCloudProperties.getSpanner().getDatabase()));

        //Test the client instance using the connection test sql to make sure connection success and avoid long wait on first DB call
        dbClient.singleUse().executeQuery(Statement.of(googleCloudProperties.getSpanner().getTestConnectionQuery()));
        return dbClient;

    }

}

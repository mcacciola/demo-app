package com.homedepot.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "google.cloud")
public class GoogleCloudProperties {
    private Spanner spanner;
    private Pubsub pubsub;
    private String projectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Pubsub getPubsub() {
        return pubsub;
    }

    public void setPubsub(Pubsub pubsub) {
        this.pubsub = pubsub;
    }

    public Spanner getSpanner() {
        return spanner;
    }

    public void setSpanner(Spanner spanner) {
        this.spanner = spanner;
    }


    public static class Spanner {
        private String instance;
        private String database;
        private String projectId;
        private String testConnectionQuery;
        private Resource ddls;

        public Resource getDdls() {
            return ddls;
        }

        public void setDdls(Resource ddls) {
            this.ddls = ddls;
        }

        public String getInstance() {
            return instance;
        }

        public void setInstance(String instance) {
            this.instance = instance;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public String getTestConnectionQuery() {
            return testConnectionQuery;
        }

        public void setTestConnectionQuery(String testConnectionQuery) {
            this.testConnectionQuery = testConnectionQuery;
        }
    }

    public static class Pubsub {
        private Integer capacity;
        private PubsubTopic inventoryCore;
        private PubsubTopic asnCore;
        private String inventoryAsnCoreSub;

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

        public PubsubTopic getInventoryCore() {
            return inventoryCore;
        }

        public void setInventoryCore(PubsubTopic inventoryCore) {
            this.inventoryCore = inventoryCore;
        }
        public PubsubTopic getAsnCore() {
            return asnCore;
        }

        public void setAsnCore(PubsubTopic asnCore) {
            this.asnCore = asnCore;
        }
        public String getInventoryAsnCoreSub() {
            return inventoryAsnCoreSub;
        }

        public void setInventoryAsnCoreSub(String inventoryAsnCoreSub) {
            this.inventoryAsnCoreSub = inventoryAsnCoreSub;
        }
    }
    public static class PubsubTopic {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

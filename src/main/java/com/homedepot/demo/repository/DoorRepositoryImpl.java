package com.homedepot.demo.repository;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.homedepot.demo.domain.Door;
import com.homedepot.di.dc.osc.commons.spanner.ResultSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Component
public class DoorRepositoryImpl implements DoorRepository {
    private DatabaseClient databaseClient;

    @Autowired
    public DoorRepositoryImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }



    public List<Door> getDoors() {
        Statement statement = Statement.newBuilder("SELECT * FROM door").build();

        try (ResultSet resultSet = databaseClient.singleUse().executeQuery(statement)) {
            ResultSetMapper<Door> doorResultSetMapper = new ResultSetMapper<>(Door.class);
            List<Door> results = doorResultSetMapper.mapResultToObject(resultSet);
            return !results.isEmpty() ? results : null;
        }

    }


    public void addDoor(Door door) {
        door.setDoorId(UUID.randomUUID().toString());
        ResultSetMapper<Door> map = new ResultSetMapper<>(Door.class);
        databaseClient.write(map.mapToInsertMutation(door));
    }
}

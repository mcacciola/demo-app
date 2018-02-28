package com.homedepot.demo.repository;

import java.util.List;

import com.homedepot.demo.domain.Door;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Repository;

@Repository
public interface DoorRepository
{


    @NewSpan
    List<Door> getDoors();
    @NewSpan
    void addDoor(Door door);
}

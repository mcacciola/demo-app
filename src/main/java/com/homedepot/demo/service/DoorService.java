package com.homedepot.demo.service;

import com.homedepot.demo.domain.Door;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Component;

import java.util.List;

public interface DoorService {
    @NewSpan
    List<Door> getAllDoors();

    @NewSpan
    void addDoor(Door door);
}

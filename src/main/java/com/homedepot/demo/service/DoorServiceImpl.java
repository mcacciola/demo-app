package com.homedepot.demo.service;

import com.homedepot.demo.domain.Door;
import com.homedepot.demo.exception.EntityNotFoundException;
import com.homedepot.demo.exception.InvalidRequestException;
import com.homedepot.demo.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DoorServiceImpl implements DoorService {

    private DoorRepository doorRepository;

    @Autowired
    public DoorServiceImpl(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public List<Door> getAllDoors() {
        List<Door> doors = doorRepository.getDoors();
        if(doors == null){
            throw new EntityNotFoundException("No Doors Found.");
        }
        return doors;
    }


    public void addDoor(Door door) {
        if(StringUtils.isEmpty(door.getName())){
            throw new InvalidRequestException("Dock door name is required.");
        }
        doorRepository.addDoor(door);
    }
}

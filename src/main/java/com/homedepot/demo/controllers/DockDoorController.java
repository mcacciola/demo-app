package com.homedepot.demo.controllers;

import com.homedepot.demo.domain.Door;
import com.homedepot.demo.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DockDoorController {

     DoorService doorService;
    @Autowired
    public DockDoorController(DoorService doorService){
        this.doorService = doorService;
    }


    @RequestMapping(path = "/getAllDoors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Door> getAllDoors() {
        return doorService.getAllDoors();
    }

    //POST 'api/addDoor'
    @RequestMapping(path = "/addDoor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addDoor(@RequestBody Door door){

        doorService.addDoor(door);
    }
}

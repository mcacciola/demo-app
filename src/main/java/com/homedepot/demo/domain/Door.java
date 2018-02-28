package com.homedepot.demo.domain;

import com.homedepot.di.dc.osc.commons.spanner.SpannerColumn;
import com.homedepot.di.dc.osc.commons.spanner.SpannerTable;

import java.util.UUID;

@SpannerTable(name="door")
public class Door {
    @SpannerColumn(name = "door_id", nullable = false)
    private String doorId;

    @SpannerColumn(name = "name", nullable = false)
    private String name;


    public Door() {
    }

    public Door( String name) {
        this.doorId = UUID.randomUUID().toString();
        this.name = name;
    }

    public Door(String doorId, String name) {
        this.doorId = doorId;
        this.name = name;
    }

    public String getDoorId() {
        return doorId;
    }

    public void setDoorId(String doorId) {
        this.doorId = doorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }

}

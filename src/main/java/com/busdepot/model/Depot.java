package com.busdepot.model;

public class Depot {
    private Integer depotId;
    private String depotName;
    private String location;

    public Depot() {}

    public Depot(String depotName, String location) {
        this.depotName = depotName;
        this.location = location;
    }

    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
    public String getDepotName() { return depotName; }
    public void setDepotName(String depotName) { this.depotName = depotName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
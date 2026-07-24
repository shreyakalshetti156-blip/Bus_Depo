package com.busdepot.model;

public class Bus {
    private Integer busId;
    private String busNumber;
    private String busType;
    private Integer capacity;
    private Integer depotId;
    private String depotName;

    public Bus() {}

    public Bus(String busNumber, String busType, Integer capacity, Integer depotId) {
        this.busNumber = busNumber;
        this.busType = busType;
        this.capacity = capacity;
        this.depotId = depotId;
    }

<<<<<<< HEAD
    public Integer getBusId() { 
    	return busId; 
    	}
    public void setBusId(Integer busId) { 
    	this.busId = busId; 
    	}
    public String getBusNumber() {
    	return busNumber;
    	}
    public void setBusNumber(String busNumber) { 
    	this.busNumber = busNumber; 
    	}
=======
    public Integer getBusId() { return busId; }
    public void setBusId(Integer busId) { this.busId = busId; }
    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
>>>>>>> 543e668ada4b0481b99425993b713150c4bc0146
    public String getBusType() { return busType; }
    public void setBusType(String busType) { this.busType = busType; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
    public String getDepotName() { return depotName; }
    public void setDepotName(String depotName) { this.depotName = depotName; }
}
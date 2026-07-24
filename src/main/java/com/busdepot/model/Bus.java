package com.Bus.dto;

public class Bus {
private Integer   bus_id;
private String bus_number;
private  String bus_type;
private Integer capacity;
private Integer depot_id;
public Integer getBus_id() {
	return bus_id;
}
public void setBus_id(Integer bus_id) {
	this.bus_id = bus_id;
}
public String getBus_number() {
	return bus_number;
}
public void setBus_number(String bus_number) {
	this.bus_number = bus_number;
}
public String getBus_type() {
	return bus_type;
}
public void setBus_type(String bus_type) {
	this.bus_type = bus_type;
}
public Integer getCapacity() {
	return capacity;
}
public void setCapacity(Integer capacity) {
	this.capacity = capacity;
}
public Integer getDepot_id() {
	return depot_id;
}
public void setDepot_id(Integer depot_id) {
	this.depot_id = depot_id;
}

@Override
public String toString() {
	return "Bus [bus_id=" + bus_id + ", bus_number=" + bus_number + ", bus_type=" + bus_type + ", capacity=" + capacity
			+ ", depot_id=" + depot_id + "]";
}


}

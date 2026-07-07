package com.Bus.dto;

import java.util.Date;

public class Assignment {
private Integer assignment_id;
private Integer driver_id;
private Integer bus_id;
private Date assignment_date;
private String shift;
public Integer getAssignment_id() {
	return assignment_id;
}
public void setAssignment_id(Integer assignment_id) {
	this.assignment_id = assignment_id;
}
public Integer getDriver_id() {
	return driver_id;
}
public void setDriver_id(Integer driver_id) {
	this.driver_id = driver_id;
}
public Integer getBus_id() {
	return bus_id;
}
public void setBus_id(Integer bus_id) {
	this.bus_id = bus_id;
}
public Date getAssignment_date() {
	return assignment_date;
}
public void setAssignment_date(Date assignment_date) {
	this.assignment_date = assignment_date;
}
public String getShift() {
	return shift;
}
public void setShift(String shift) {
	this.shift = shift;
}

@Override
public String toString() {
	return "Assignment [assignment_id=" + assignment_id + ", driver_id=" + driver_id + ", bus_id=" + bus_id
			+ ", assignment_date=" + assignment_date + ", shift=" + shift + "]";
}

}

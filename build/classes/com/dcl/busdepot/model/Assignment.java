package com.busdepot.model;

import java.sql.Date;

public class Assignment {
    private Integer assignmentId;
    private Integer driverId;
    private Integer busId;
    private Integer routeId;
    private Date assignmentDate;
    private String shift;
    private String driverName;
    private String busNumber;
    private String routeName;

    public Assignment() {}

    public Assignment(Integer driverId, Integer busId, Integer routeId, Date assignmentDate, String shift) {
        this.driverId = driverId;
        this.busId = busId;
        this.routeId = routeId;
        this.assignmentDate = assignmentDate;
        this.shift = shift;
    }

    public Integer getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Integer assignmentId) { this.assignmentId = assignmentId; }
    public Integer getDriverId() { return driverId; }
    public void setDriverId(Integer driverId) { this.driverId = driverId; }
    public Integer getBusId() { return busId; }
    public void setBusId(Integer busId) { this.busId = busId; }
    public Integer getRouteId() { return routeId; }
    public void setRouteId(Integer routeId) { this.routeId = routeId; }
    public Date getAssignmentDate() { return assignmentDate; }
    public void setAssignmentDate(Date assignmentDate) { this.assignmentDate = assignmentDate; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }
}
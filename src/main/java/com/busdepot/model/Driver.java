package com.busdepot.model;

public class Driver {
    private Integer driverId;
    private String driverName;
    private String licenseNumber;
    private String phone;
    private Integer depotId;
    private String depotName;

    public Driver() {}

    public Driver(String driverName, String licenseNumber, String phone, Integer depotId) {
        this.driverName = driverName;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.depotId = depotId;
    }

    public Integer getDriverId() { return driverId; }
    public void setDriverId(Integer driverId) { this.driverId = driverId; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
    public String getDepotName() { return depotName; }
    public void setDepotName(String depotName) { this.depotName = depotName; }
}
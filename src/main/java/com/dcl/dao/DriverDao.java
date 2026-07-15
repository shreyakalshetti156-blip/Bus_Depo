package com.dcl.dao;

import java.util.List;

import com.Bus.dto.Driver;

public interface DriverDao {
	
    public boolean insertDriver(Driver driver);
    public boolean updateDriver(Driver driver);
    public boolean deleteDriver(int driverId);
    Driver getDriverById(int driverId);
    List<Driver> getAllDrivers();
	
}

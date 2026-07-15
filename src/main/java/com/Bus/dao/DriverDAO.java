package com.Bus.dao;

import java.util.List;

import com.Bus.dto.Driver;

public interface DriverDAO {
	
	    public boolean insertDriver(Driver driver);
	    public boolean updateDriver(Driver driver);
	    public boolean deleteDriver(int driverId);
	    Driver getDriverById(int driverId);
	    List<Driver> getAllDrivers();

	}

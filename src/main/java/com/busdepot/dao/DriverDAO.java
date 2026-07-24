package com.busdepot.dao;

import java.util.List;
import com.busdepot.model.Driver;

public interface DriverDAO {
    List<Driver> getAllDrivers();
    List<Driver> getDriversByDepot(Integer depotId);
    Driver getDriverById(Integer id);
    boolean addDriver(Driver driver);
    boolean updateDriver(Driver driver);
    boolean deleteDriver(Integer id);
}
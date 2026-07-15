package com.dcl.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bus.dto.Driver;
import com.dcl.dao.DriverDao;

public class Driverimpl implements DriverDao {

	private Connection con;

    public Driverimpl(Connection con) {
        this.con = con;
    }


	public boolean insertDriver(Driver driver) {
        String query = "INSERT INTO Driver(driver_name, licence_number, phone, depot_id) VALUES(?,?,?,?)";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, driver.getDriver_name());
            ps.setString(2, driver.getLicence_number());
            ps.setString(3, driver.getPhone());
            ps.setInt(4, driver.getDepot_id());

            int i = ps.executeUpdate();

            return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

//	@Override
	public boolean updateDriver(Driver driver) {
        String query = "UPDATE Driver SET driver_name=?, licence_number=?, phone=?, depot_id=? WHERE driver_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			 ps.setString(1, driver.getDriver_name());
	            ps.setString(2, driver.getLicence_number());
	            ps.setString(3, driver.getPhone());
	            ps.setInt(4, driver.getDepot_id());
	            ps.setInt(5, driver.getDriver_id());

	            int i = ps.executeUpdate();

	            return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

//	@Override
	public boolean deleteDriver(int driverId) {
        String query = "DELETE FROM Driver WHERE driver_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, driverId);

            int i = ps.executeUpdate();

            return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

//	@Override
	public Driver getDriverById(int driverId) {
        String query = "SELECT * FROM Driver WHERE driver_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, driverId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Driver driver = new Driver();

                driver.setDriver_id(rs.getInt("driver_id"));
                driver.setDriver_name(rs.getString("driver_name"));
                driver.setLicence_number(rs.getString("licence_number"));
                driver.setPhone(rs.getString("phone"));
                driver.setDepot_id(rs.getInt("depot_id"));

                return driver;
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

//	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> driverList = new ArrayList<>();

        String query = "SELECT * FROM Driver";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriver_id(rs.getInt("driver_id"));
                driver.setDriver_name(rs.getString("driver_name"));
                driver.setLicence_number(rs.getString("licence_number"));
                driver.setPhone(rs.getString("phone"));
                driver.setDepot_id(rs.getInt("depot_id"));
                driverList.add(driver);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driverList;
	}

}



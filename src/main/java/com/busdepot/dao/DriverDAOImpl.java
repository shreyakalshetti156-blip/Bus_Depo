package com.busdepot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.busdepot.model.Driver;
import com.busdepot.utility.DBConnection;

public class DriverDAOImpl implements DriverDAO {
    private Connection con = DBConnection.getConnection();

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT d.*, dp.depot_name FROM driver d LEFT JOIN depot dp ON d.depot_id = dp.depot_id";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Driver dr = new Driver();
                dr.setDriverId(rs.getInt("driver_id"));
                dr.setDriverName(rs.getString("driver_name"));
                dr.setLicenseNumber(rs.getString("license_number"));
                dr.setPhone(rs.getString("phone"));
                dr.setDepotId(rs.getInt("depot_id"));
                dr.setDepotName(rs.getString("depot_name"));
                list.add(dr);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<Driver> getDriversByDepot(Integer depotId) {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT d.*, dp.depot_name FROM driver d LEFT JOIN depot dp ON d.depot_id = dp.depot_id WHERE d.depot_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, depotId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Driver dr = new Driver();
                dr.setDriverId(rs.getInt("driver_id"));
                dr.setDriverName(rs.getString("driver_name"));
                dr.setLicenseNumber(rs.getString("license_number"));
                dr.setPhone(rs.getString("phone"));
                dr.setDepotId(rs.getInt("depot_id"));
                dr.setDepotName(rs.getString("depot_name"));
                list.add(dr);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Driver getDriverById(Integer id) {
        String sql = "SELECT d.*, dp.depot_name FROM driver d LEFT JOIN depot dp ON d.depot_id = dp.depot_id WHERE d.driver_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Driver dr = new Driver();
                dr.setDriverId(rs.getInt("driver_id"));
                dr.setDriverName(rs.getString("driver_name"));
                dr.setLicenseNumber(rs.getString("license_number"));
                dr.setPhone(rs.getString("phone"));
                dr.setDepotId(rs.getInt("depot_id"));
                dr.setDepotName(rs.getString("depot_name"));
                return dr;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addDriver(Driver driver) {
        String sql = "INSERT INTO driver (driver_name, license_number, phone, depot_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, driver.getDriverName());
            ps.setString(2, driver.getLicenseNumber());
            ps.setString(3, driver.getPhone());
            ps.setInt(4, driver.getDepotId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateDriver(Driver driver) {
        String sql = "UPDATE driver SET driver_name = ?, license_number = ?, phone = ?, depot_id = ? WHERE driver_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, driver.getDriverName());
            ps.setString(2, driver.getLicenseNumber());
            ps.setString(3, driver.getPhone());
            ps.setInt(4, driver.getDepotId());
            ps.setInt(5, driver.getDriverId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteDriver(Integer id) {
        String sql = "DELETE FROM driver WHERE driver_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
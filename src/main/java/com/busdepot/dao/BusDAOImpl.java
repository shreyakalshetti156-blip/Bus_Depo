package com.busdepot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.busdepot.model.Bus;
import com.busdepot.utility.DBConnection;


public class BusDAOImpl implements BusDAO {
    private Connection con = DBConnection.getConnection();

    @Override
    public List<Bus> getAllBuses() {
        List<Bus> list = new ArrayList<>();
        String sql = "SELECT b.*, d.depot_name FROM bus b LEFT JOIN depot d ON b.depot_id = d.depot_id";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Bus b = new Bus();
                b.setBusId(rs.getInt("bus_id"));
                b.setBusNumber(rs.getString("bus_number"));
                b.setBusType(rs.getString("bus_type"));
                b.setCapacity(rs.getInt("capacity"));
                b.setDepotId(rs.getInt("depot_id"));
                b.setDepotName(rs.getString("depot_name"));
                list.add(b);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<Bus> getBusesByDepot(Integer depotId) {
        List<Bus> list = new ArrayList<>();
        String sql = "SELECT b.*, d.depot_name FROM bus b LEFT JOIN depot d ON b.depot_id = d.depot_id WHERE b.depot_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, depotId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bus b = new Bus();
                b.setBusId(rs.getInt("bus_id"));
                b.setBusNumber(rs.getString("bus_number"));
                b.setBusType(rs.getString("bus_type"));
                b.setCapacity(rs.getInt("capacity"));
                b.setDepotId(rs.getInt("depot_id"));
                b.setDepotName(rs.getString("depot_name"));
                list.add(b);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Bus getBusById(Integer id) {
        String sql = "SELECT b.*, d.depot_name FROM bus b LEFT JOIN depot d ON b.depot_id = d.depot_id WHERE b.bus_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Bus b = new Bus();
                b.setBusId(rs.getInt("bus_id"));
                b.setBusNumber(rs.getString("bus_number"));
                b.setBusType(rs.getString("bus_type"));
                b.setCapacity(rs.getInt("capacity"));
                b.setDepotId(rs.getInt("depot_id"));
                b.setDepotName(rs.getString("depot_name"));
                return b;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addBus(Bus bus) {
        String sql = "INSERT INTO bus (bus_number, bus_type, capacity, depot_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bus.getBusNumber());
            ps.setString(2, bus.getBusType());
            ps.setInt(3, bus.getCapacity());
            ps.setInt(4, bus.getDepotId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateBus(Bus bus) {
        String sql = "UPDATE bus SET bus_number = ?, bus_type = ?, capacity = ?, depot_id = ? WHERE bus_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bus.getBusNumber());
            ps.setString(2, bus.getBusType());
            ps.setInt(3, bus.getCapacity());
            ps.setInt(4, bus.getDepotId());
            ps.setInt(5, bus.getBusId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteBus(Integer id) {
        String sql = "DELETE FROM bus WHERE bus_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
package com.busdepot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.busdepot.model.Assignment;
import com.busdepot.utility.DBConnection;


public class AssignmentDAOImpl implements AssignmentDAO {
    private Connection con = DBConnection.getConnection();

    @Override
public List<Assignment> getAllAssignments() {
    	List<Assignment> list = new ArrayList<>();
        String sql = "SELECT a.*, dr.driver_name, b.bus_number, r.route_name " +
                     "FROM assignment a " +"LEFT JOIN driver dr ON a.driver_id = dr.driver_id " +"LEFT JOIN bus b ON a.bus_id = b.bus_id " +
                     "LEFT JOIN route r ON a.route_id = r.route_id";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setAssignmentId(rs.getInt("assignment_id"));
                a.setDriverId(rs.getInt("driver_id"));
                a.setBusId(rs.getInt("bus_id"));
                a.setRouteId(rs.getInt("route_id"));
                a.setAssignmentDate(rs.getDate("assignment_date"));
                a.setShift(rs.getString("shift"));
                a.setDriverName(rs.getString("driver_name"));
                a.setBusNumber(rs.getString("bus_number"));
                a.setRouteName(rs.getString("route_name"));
                list.add(a);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<Assignment> getAssignmentsByDriver(Integer driverId) {
        List<Assignment> list = new ArrayList<>();
        String sql = "SELECT a.*, dr.driver_name, b.bus_number, r.route_name " +
                     "FROM assignment a " +
                     "LEFT JOIN driver dr ON a.driver_id = dr.driver_id " +
                     "LEFT JOIN bus b ON a.bus_id = b.bus_id " +
                     "LEFT JOIN route r ON a.route_id = r.route_id " +
                     "WHERE a.driver_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, driverId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setAssignmentId(rs.getInt("assignment_id"));
                a.setDriverId(rs.getInt("driver_id"));
                a.setBusId(rs.getInt("bus_id"));
                a.setRouteId(rs.getInt("route_id"));
                a.setAssignmentDate(rs.getDate("assignment_date"));
                a.setShift(rs.getString("shift"));
                a.setDriverName(rs.getString("driver_name"));
                a.setBusNumber(rs.getString("bus_number"));
                a.setRouteName(rs.getString("route_name"));
                list.add(a);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<Assignment> getAssignmentsByBus(Integer busId) {
        List<Assignment> list = new ArrayList<>();
        String sql = "SELECT a.*, dr.driver_name, b.bus_number, r.route_name " +
                     "FROM assignment a " +
                     "LEFT JOIN driver dr ON a.driver_id = dr.driver_id " +
                     "LEFT JOIN bus b ON a.bus_id = b.bus_id " +
                     "LEFT JOIN route r ON a.route_id = r.route_id " +
                     "WHERE a.bus_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, busId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setAssignmentId(rs.getInt("assignment_id"));
                a.setDriverId(rs.getInt("driver_id"));
                a.setBusId(rs.getInt("bus_id"));
                a.setRouteId(rs.getInt("route_id"));
                a.setAssignmentDate(rs.getDate("assignment_date"));
                a.setShift(rs.getString("shift"));
                a.setDriverName(rs.getString("driver_name"));
                a.setBusNumber(rs.getString("bus_number"));
                a.setRouteName(rs.getString("route_name"));
                list.add(a);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<Assignment> getAssignmentsByDate(java.sql.Date date) {
        List<Assignment> list = new ArrayList<>();
        String sql = "SELECT a.*, dr.driver_name, b.bus_number, r.route_name " +
                     "FROM assignment a " +
                     "LEFT JOIN driver dr ON a.driver_id = dr.driver_id " +
                     "LEFT JOIN bus b ON a.bus_id = b.bus_id " +
                     "LEFT JOIN route r ON a.route_id = r.route_id " +
                     "WHERE a.assignment_date = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setAssignmentId(rs.getInt("assignment_id"));
                a.setDriverId(rs.getInt("driver_id"));
                a.setBusId(rs.getInt("bus_id"));
                a.setRouteId(rs.getInt("route_id"));
                a.setAssignmentDate(rs.getDate("assignment_date"));
                a.setShift(rs.getString("shift"));
                a.setDriverName(rs.getString("driver_name"));
                a.setBusNumber(rs.getString("bus_number"));
                a.setRouteName(rs.getString("route_name"));
                list.add(a);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Assignment getAssignmentById(Integer id) {
        String sql = "SELECT a.*, dr.driver_name, b.bus_number, r.route_name " +
                     "FROM assignment a " +
                     "LEFT JOIN driver dr ON a.driver_id = dr.driver_id " +
                     "LEFT JOIN bus b ON a.bus_id = b.bus_id " +
                     "LEFT JOIN route r ON a.route_id = r.route_id " +
                     "WHERE a.assignment_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Assignment a = new Assignment();
                a.setAssignmentId(rs.getInt("assignment_id"));
                a.setDriverId(rs.getInt("driver_id"));
                a.setBusId(rs.getInt("bus_id"));
                a.setRouteId(rs.getInt("route_id"));
                a.setAssignmentDate(rs.getDate("assignment_date"));
                a.setShift(rs.getString("shift"));
                a.setDriverName(rs.getString("driver_name"));
                a.setBusNumber(rs.getString("bus_number"));
                a.setRouteName(rs.getString("route_name"));
                return a;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addAssignment(Assignment assignment) {
        String sql = "INSERT INTO assignment (driver_id, bus_id, route_id, assignment_date, shift) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assignment.getDriverId());
            ps.setInt(2, assignment.getBusId());
            ps.setInt(3, assignment.getRouteId());
            ps.setDate(4, assignment.getAssignmentDate());
            ps.setString(5, assignment.getShift());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateAssignment(Assignment assignment) {
        String sql = "UPDATE assignment SET driver_id = ?, bus_id = ?, route_id = ?, assignment_date = ?, shift = ? WHERE assignment_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assignment.getDriverId());
            ps.setInt(2, assignment.getBusId());
            ps.setInt(3, assignment.getRouteId());
            ps.setDate(4, assignment.getAssignmentDate());
            ps.setString(5, assignment.getShift());
            ps.setInt(6, assignment.getAssignmentId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteAssignment(Integer id) {
        String sql = "DELETE FROM assignment WHERE assignment_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
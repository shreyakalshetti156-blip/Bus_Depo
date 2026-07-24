package com.busdepot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.busdepot.model.Depot;
import com.busdepot.utility.DBConnection;

public class DepotDAOImpl implements DepotDAO {
    private Connection con = DBConnection.getConnection();

    @Override
    public List<Depot> getAllDepots() {
        List<Depot> list = new ArrayList<>();
        String sql = "SELECT * FROM depot";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Depot d = new Depot();
                d.setDepotId(rs.getInt("depot_id"));
                d.setDepotName(rs.getString("depot_name"));
                d.setLocation(rs.getString("location"));
                list.add(d);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Depot getDepotById(Integer id) {
        String sql = "SELECT * FROM depot WHERE depot_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Depot d = new Depot();
                d.setDepotId(rs.getInt("depot_id"));
                d.setDepotName(rs.getString("depot_name"));
                d.setLocation(rs.getString("location"));
                return d;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addDepot(Depot depot) {
        String sql = "INSERT INTO depot (depot_name, location) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, depot.getDepotName());
            ps.setString(2, depot.getLocation());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateDepot(Depot depot) {
        String sql = "UPDATE depot SET depot_name = ?, location = ? WHERE depot_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, depot.getDepotName());
            ps.setString(2, depot.getLocation());
            ps.setInt(3, depot.getDepotId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteDepot(Integer id) {
        String sql = "DELETE FROM depot WHERE depot_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
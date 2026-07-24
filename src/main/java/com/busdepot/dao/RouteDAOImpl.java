package com.busdepot.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.busdepot.model.Route;
import com.busdepot.utility.DBConnection;

public class RouteDAOImpl implements RouteDAO {
    private Connection con = DBConnection.getConnection();

    @Override
    public List<Route> getAllRoutes() {
        List<Route> list = new ArrayList<>();
        String sql = "SELECT * FROM route";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Route r = new Route();
                r.setRouteId(rs.getInt("route_id"));
                r.setRouteName(rs.getString("route_name"));
                r.setStartPoint(rs.getString("start_point"));
                r.setEndPoint(rs.getString("end_point"));
                list.add(r);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Route getRouteById(Integer id) {
        String sql = "SELECT * FROM route WHERE route_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Route r = new Route();
                r.setRouteId(rs.getInt("route_id"));
                r.setRouteName(rs.getString("route_name"));
                r.setStartPoint(rs.getString("start_point"));
                r.setEndPoint(rs.getString("end_point"));
                return r;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addRoute(Route route) {
        String sql = "INSERT INTO route (route_name, start_point, end_point) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, route.getRouteName());
            ps.setString(2, route.getStartPoint());
            ps.setString(3, route.getEndPoint());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateRoute(Route route) {
        String sql = "UPDATE route SET route_name = ?, start_point = ?, end_point = ? WHERE route_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, route.getRouteName());
            ps.setString(2, route.getStartPoint());
            ps.setString(3, route.getEndPoint());
            ps.setInt(4, route.getRouteId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteRoute(Integer id) {
        String sql = "DELETE FROM route WHERE route_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
package com.dcl.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bus.dto.Route;
import com.dcl.dao.RouteDao;

public class Routeimpl implements RouteDao{

	
	private Connection con;
	
	public Routeimpl(Connection con) {
		this.con=con;
	}
	public boolean insertRoute(Route route) {
        String query = "INSERT INTO Route(route_name, start_point, end_point) VALUES(?,?,?)";
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, route.getRoute_name());
            ps.setString(2, route.getStart_point());
            ps.setString(3, route.getEnd_point());

            int i = ps.executeUpdate();
            return i > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return false;
	}

//	@Override
	public boolean updateRoute(Route route) {
        String query = "UPDATE Route SET route_name=?, start_point=?, end_point=? WHERE route_id=?";
        
        try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, route.getRoute_name());
            ps.setString(2, route.getStart_point());
            ps.setString(3, route.getEnd_point());
            ps.setInt(4, route.getRoute_id());

            int i = ps.executeUpdate();
            return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteRoute(int routeId) {
        String query = "DELETE FROM Route WHERE route_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, routeId);

            int i = ps.executeUpdate();

            return i > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

//	@Override
	public Route getRouteById(int routeId) {
        String query = "SELECT * FROM Route WHERE route_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			 ps.setInt(1, routeId);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Route route = new Route();
	                route.setRoute_id(rs.getInt("route_id"));
	                route.setRoute_name(rs.getString("route_name"));
	                route.setStart_point(rs.getString("start_point"));
	                route.setEnd_point(rs.getString("end_point"));

	                return route;
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

//	@Override
	public List<Route> getAllRoutes() {
		List<Route> routeList = new ArrayList<>();
        String query = "SELECT * FROM Route";
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Route route = new Route();
                route.setRoute_id(rs.getInt("route_id"));
                route.setRoute_name(rs.getString("route_name"));
                route.setStart_point(rs.getString("start_point"));
                route.setEnd_point(rs.getString("end_point"));
                routeList.add(route);
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return routeList;
	}

}


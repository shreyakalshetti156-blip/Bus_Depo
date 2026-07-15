package com.Bus.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bus.dao.BusDAO;
import com.Bus.dto.Bus;

public class BusImpl implements BusDAO {
	private Connection con;

    public BusImpl(Connection con) {
        this.con = con;
    }

	@Override
	public boolean insertBus(Bus bus) {
        String query = "INSERT INTO Bus(bus_number, bus_type, capacity, depot_id) VALUES(?,?,?,?)";
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bus.getBus_number());
            ps.setString(2, bus.getBus_type());
            ps.setInt(3, bus.getCapacity());
            ps.setInt(4, bus.getDepot_id());

            int i = ps.executeUpdate();

            if (i > 0) {
                return true;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateBus(Bus bus) {
        String query = "UPDATE Bus SET bus_number=?, bus_type=?, capacity=?, depot_id=? WHERE bus_id=?";

        try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bus.getBus_number());
            ps.setString(2, bus.getBus_type());
            ps.setInt(3, bus.getCapacity());
            ps.setInt(4, bus.getDepot_id());
            ps.setInt(5, bus.getBus_id());
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBus(int busId) {
        String query = "DELETE FROM Bus WHERE bus_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, busId);
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Bus getBusById(int busId) {
        String query = "SELECT * FROM Bus WHERE bus_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			 ps.setInt(1, busId);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Bus bus = new Bus();
	                bus.setBus_id(rs.getInt("bus_id"));
	                bus.setBus_number(rs.getString("bus_number"));
	                bus.setBus_type(rs.getString("bus_type"));
	                bus.setCapacity(rs.getInt("capacity"));
	                bus.setDepot_id(rs.getInt("depot_id"));
	                return bus;
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bus> getAllBus() {
        List<Bus> busList = new ArrayList<>();
        String query = "SELECT * FROM Bus";
        
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setBus_id(rs.getInt("bus_id"));
                bus.setBus_number(rs.getString("bus_number"));
                bus.setBus_type(rs.getString("bus_type"));
                bus.setCapacity(rs.getInt("capacity"));
                bus.setDepot_id(rs.getInt("depot_id"));
                busList.add(bus);
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return busList;
	}

}

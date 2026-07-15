package com.Bus.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bus.dao.DepoDAO;
import com.Bus.dto.Depo;

public class DepoImpl implements DepoDAO {
	private Connection con;
	
	public DepoImpl(Connection con) {
    this.con=con;
}

	@Override
	public boolean insertDepot(Depo depot) {
		 String query="INSERT INTO Depot(depot_name, location) VALUES(?,?)";
		 int i=0;
		 try {
			PreparedStatement ps= con.prepareStatement(query);
			  ps.setString(1, depot.getDepot_name());
	           ps.setString(2, depot.getLocation());
				i=ps.executeUpdate();
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 if(i>0) {
				return true;
			}
			else {
		 return false;
			}
	}

	@Override
	public boolean updateDepot(Depo depot) {
        String query = "UPDATE Depot SET depot_name=?, location=? WHERE depot_id=?";
		int i=0;
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, depot.getDepot_name());
            ps.setString(2, depot.getLocation());
            ps.setInt(3, depot.getDepot_id());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	@Override
	public boolean deleteDepot(int depotId) {
        String query = "DELETE FROM Depot WHERE depot_id=?";
		int i=0;
        try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, depotId);
			i=ps.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(i>0) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public Depo getDepotById(int depotId) {
        String query = "SELECT * FROM Depot WHERE depot_id=?";
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, depotId);
			ResultSet rs=ps.executeQuery();
			
			 if (rs.next()) {

	                Depo depot = new Depo();

	                depot.setDepot_id(rs.getInt("depot_id"));
	                depot.setDepot_name(rs.getString("depot_name"));
	                depot.setLocation(rs.getString("location"));
	                
	                return depot;
	                
			 }

		} catch (SQLException e) {
			
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public List<Depo> getAllDepots() {
		List<Depo> depotList = new ArrayList<>();

        String query = "SELECT * FROM Depot";
        try {
			PreparedStatement ps = con.prepareStatement(query);
			 ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Depo depot = new Depo();

	                depot.setDepot_id(rs.getInt("depot_id"));
	                depot.setDepot_name(rs.getString("depot_name"));
	                depot.setLocation(rs.getString("location"));

	                depotList.add(depot);
	            }	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return depotList;
	}
	

}

package com.dcl.Daoimp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bus.dto.Assignment;
import com.dcl.dao.AssignmentDao;

public class Assignmentimpl implements AssignmentDao {
	private Connection con;

    public Assignmentimpl(Connection con) {
        this.con = con;
    }

	@Override
	public boolean insertAssignment(Assignment assignment) {
	String query = "INSERT INTO Assignment(driver_id, bus_id, assignment_date, shift) VALUES(?,?,?,?)";

	        try {
				PreparedStatement ps =con.prepareStatement(query);
				ps.setInt(1, assignment.getDriver_id());
	            ps.setInt(2, assignment.getBus_id());
	            ps.setDate(3, new Date(assignment.getAssignment_date().getTime()));
	            ps.setString(4, assignment.getShift());

	            int i = ps.executeUpdate();

	            return i > 0;
	            } catch (SQLException e) {
				
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateAssignment(Assignment assignment) {
		  String query = "UPDATE Assignment SET driver_id=?, bus_id=?, assignment_date=?, shift=? WHERE assignment_id=?";
			try {
				PreparedStatement ps =con.prepareStatement(query);
				 ps.setInt(1, assignment.getDriver_id());
		            ps.setInt(2, assignment.getBus_id());
		            ps.setDate(3, new Date(assignment.getAssignment_date().getTime()));
		            ps.setString(4, assignment.getShift());
		            ps.setInt(5, assignment.getAssignment_id());
		            int i = ps.executeUpdate();
		            return i > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public boolean deleteAssignment(Assignment assignment) {
	    String query = "DELETE FROM Assignment WHERE assignment_id=?";

			try {
				PreparedStatement ps =con.prepareStatement(query);
	            ps.setInt(1, assignment.getAssignment_id());
	            int i = ps.executeUpdate();

	            return i > 0;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public Assignment getAssignmentById(int assignmentId) {
	
		   String query = "SELECT * FROM Assignment WHERE assignment_id=?";
	        
	        try {
				PreparedStatement ps = con.prepareStatement(query);
				 ps.setInt(1, assignmentId);
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		                Assignment assignment = new Assignment();
		                assignment.setAssignment_id(rs.getInt("assignment_id"));
		                assignment.setDriver_id(rs.getInt("driver_id"));
		                assignment.setBus_id(rs.getInt("bus_id"));
		                assignment.setAssignment_date(rs.getDate("assignment_date"));
		                assignment.setShift(rs.getString("shift"));

		                return assignment;
		            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Assignment> getAllAssignment() {
		List<Assignment> assignmentList = new ArrayList<>();
        String query = "SELECT * FROM Assignment";
        
        try {
			PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Assignment assignment = new Assignment();
                assignment.setAssignment_id(rs.getInt("assignment_id"));
                assignment.setDriver_id(rs.getInt("driver_id"));
                assignment.setBus_id(rs.getInt("bus_id"));
                assignment.setAssignment_date(rs.getDate("assignment_date"));
                assignment.setShift(rs.getString("shift"));
                assignmentList.add(assignment);
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return assignmentList;
	}

}

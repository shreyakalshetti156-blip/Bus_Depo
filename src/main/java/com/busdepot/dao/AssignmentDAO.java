package com.Bus.dao;

import java.util.List;

import com.Bus.dto.Assignment;

public interface AssignmentDAO {
	public boolean insertAssignment(Assignment assignment);
	public boolean updateAssignment(Assignment assignment);
	public boolean deleteAssignment(Assignment assignment);
	Assignment getAssignmentById(int assignmentId);
	
	List<Assignment>getAllAssignment();
}

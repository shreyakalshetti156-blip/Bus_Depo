package com.busdepot.dao;

import java.util.List;
import com.busdepot.model.Assignment;

public interface AssignmentDAO {
    List<Assignment> getAllAssignments();
    List<Assignment> getAssignmentsByDriver(Integer driverId);
    List<Assignment> getAssignmentsByBus(Integer busId);
    List<Assignment> getAssignmentsByDate(java.sql.Date date);
    Assignment getAssignmentById(Integer id);
    boolean addAssignment(Assignment assignment);
    boolean updateAssignment(Assignment assignment);
    boolean deleteAssignment(Integer id);
}
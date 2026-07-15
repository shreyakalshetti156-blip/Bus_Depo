package com.Bus.Test;

import java.sql.Connection;

import com.Bus.dto.Assignment;
import com.Bus.dto.Bus;
import com.Bus.dto.Depo;
import com.Bus.dto.Driver;
import com.Bus.dto.Route;
import com.Bus.utility.Connector;
import com.dcl.Daoimp.Depoimpl;
import com.dcl.dao.DepoDao;

public class Test {
public static void main (String[]args) {
	
	
	// Test Depot
	// ==========================


    Connection con = Connector.requestConnection();

    Depo depot = new Depo();
    depot.setDepot_name("Central Depot");
    depot.setLocation("Bangalore");

    DepoDao depotDao = new Depoimpl(con);

    int result = depotDao.saveDepot(depot);

    if (result > 0) {
        System.out.println("Depot Inserted Successfully");
    } else {
        System.out.println("Depot Insertion Failed");
    }
}

				// Test Depot
		
//			Bus bus = new Bus();
//
//			bus.setBusNumber("KA01AB1234");
//			bus.setBusType("AC");
//			bus.setCapacity(45);
//			bus.setDepotId(1);
//
//			BusDao busDao = new BusDao();
//
//			if (busDao.saveBus(bus) > 0) {
//				System.out.println("Bus Inserted Successfully");
//			} else {
//				System.out.println("Bus Insertion Failed");
//			}
//
//
//			// Test Driver
//			
//
//			Driver driver = new Driver();
//
//			driver.setDriverName("Ravi Kumar");
//			driver.setLicenseNumber("DL12345");
//			driver.setPhone("9876543210");
//			driver.setDepotId(1);
//
//			DriverDao driverDao = new DriverDao();
//
//			if (driverDao.saveDriver(driver) > 0) {
//				System.out.println("Driver Inserted Successfully");
//			} else {
//				System.out.println("Driver Insertion Failed");
//			}
//
//			// Test Route
//
//			Route route = new Route();
//
//			route.setRouteName("Route-1");
//			route.setStartPoint("Majestic");
//			route.setEndPoint("Whitefield");
//
//			RouteDao routeDao = new RouteDao();
//
//			if (routeDao.saveRoute(route) > 0) {
//				System.out.println("Route Inserted Successfully");
//			} else {
//				System.out.println("Route Insertion Failed");
//			}
//
//			// Test Assignment
//
//
//			Assignment assignment = new Assignment();
//
//			assignment.setDriverId(1);
//			assignment.setBusId(1);
//			assignment.setAssignmentDate("2026-07-15");
//			assignment.setShift("Morning");
//
//			AssignmentDao assignmentDao = new AssignmentDao();
//
//			if (assignmentDao.saveAssignment(assignment) > 0) {
//				System.out.println("Assignment Inserted Successfully");
//			} else {
//				System.out.println("Assignment Insertion Failed");
//			}
}


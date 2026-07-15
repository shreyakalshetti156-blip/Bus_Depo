package com.dcl.dao;

import java.util.List;

import com.Bus.dto.Bus;

public interface BusDao {
 
	public boolean insertBus(Bus bus);
	public 	boolean updateBus(Bus bus);
	public boolean deleteBus(int busId);
	
	Bus getBusById(int busId);
	List<Bus>getAllBus();
}

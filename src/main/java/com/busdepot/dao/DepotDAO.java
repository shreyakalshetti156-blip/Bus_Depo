package com.Bus.dao;

import java.util.List;

import com.Bus.dto.Depo;

public interface DepoDAO {
	
   public boolean insertDepot(Depo depot);
	public  boolean updateDepot(Depo depot);
	public  boolean deleteDepot(int depotId);
	Depo getDepotById(int depotId);
	List<Depo>getAllDepots();

}


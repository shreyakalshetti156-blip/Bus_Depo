package com.dcl.dao;

import java.util.List;

import com.Bus.dto.Depo;

public interface DepoDao {

	 public boolean insertDepot(Depo depot);
		public  boolean updateDepot(Depo depot);
		public  boolean deleteDepot(int depotId);
		Depo getDepotById(int depotId);
		List<Depo>getAllDepot();
		public int saveDepot(Depo depot);
	
}

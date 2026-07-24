package com.busdepot.dao;

import java.util.List;
import com.busdepot.model.Depot;

public interface DepotDAO {
    List<Depot> getAllDepots();
    Depot getDepotById(Integer id);
    boolean addDepot(Depot depot);
    boolean updateDepot(Depot depot);
    boolean deleteDepot(Integer id);
}
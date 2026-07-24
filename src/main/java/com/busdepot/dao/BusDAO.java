package com.busdepot.dao;

import java.util.List;
import com.busdepot.model.Bus;

public interface BusDAO {
    List<Bus> getAllBuses();
    List<Bus> getBusesByDepot(Integer depotId);
    Bus getBusById(Integer id);
    boolean addBus(Bus bus);
    boolean updateBus(Bus bus);
    boolean deleteBus(Integer id);
}
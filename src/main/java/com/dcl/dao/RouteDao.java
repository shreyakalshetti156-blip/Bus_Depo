package com.dcl.dao;

import java.util.List;

import com.Bus.dto.Route;

public interface RouteDao {
 
	boolean insertRoute(Route route);
    boolean updateRoute(Route route);
    boolean deleteRoute(int routeId);
    Route getRouteById(int routeId);
    List<Route> getAllRoutes();
	
}

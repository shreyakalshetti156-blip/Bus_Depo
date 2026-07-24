package com.busdepot.dao;

import java.util.List;
import com.busdepot.model.Route;

public interface RouteDAO {
    List<Route> getAllRoutes();
    Route getRouteById(Integer id);
    boolean addRoute(Route route);
    boolean updateRoute(Route route);
    boolean deleteRoute(Integer id);
}
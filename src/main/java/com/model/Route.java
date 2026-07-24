package com.busdepot.model;

public class Route {
    private Integer routeId;
    private String routeName;
    private String startPoint;
    private String endPoint;

    public Route() {}

    public Route(String routeName, String startPoint, String endPoint) {
        this.routeName = routeName;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Integer getRouteId() { return routeId; }
    public void setRouteId(Integer routeId) { this.routeId = routeId; }
    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }
    public String getStartPoint() { return startPoint; }
    public void setStartPoint(String startPoint) { this.startPoint = startPoint; }
    public String getEndPoint() { return endPoint; }
    public void setEndPoint(String endPoint) { this.endPoint = endPoint; }
}
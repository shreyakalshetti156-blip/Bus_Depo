package com.Bus.dto;

public class Route {
private Integer route_id;
private String route_name;
private String start_point;
private String end_point;
public Integer getRoute_id() {
	return route_id;
}
public void setRoute_id(Integer route_id) {
	this.route_id = route_id;
}
public String getRoute_name() {
	return route_name;
}
public void setRoute_name(String route_name) {
	this.route_name = route_name;
}
public String getStart_point() {
	return start_point;
}
public void setStart_point(String start_point) {
	this.start_point = start_point;
}
public String getEnd_point() {
	return end_point;
}
public void setEnd_point(String end_point) {
	this.end_point = end_point;
}

@Override
public String toString() {
	return "Route [route_id=" + route_id + ", route_name=" + route_name + ", start_point=" + start_point
			+ ", end_point=" + end_point + "]";
}


}

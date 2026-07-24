package com.Bus.dto;

public class Depo {
 private Integer depot_id;
 private String depot_name;
 private String location;
 public Integer getDepot_id() {
	return depot_id;
 }
 public void setDepot_id(Integer depot_id) {
	this.depot_id = depot_id;
 }
 public String getDepot_name() {
	return depot_name;
 }
 public void setDepot_name(String depot_name) {
	this.depot_name = depot_name;
 }
 public String getLocation() {
	return location;
 }
 public void setLocation(String location) {
	this.location = location;
 }
 @Override
 public String toString() {
	return "Depo [depot_id=" + depot_id + ", depot_name=" + depot_name + ", location=" + location + "]";
 }
 
}

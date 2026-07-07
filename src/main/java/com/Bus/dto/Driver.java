package com.Bus.dto;

public class Driver {
private Integer driver_id;
private String driver_name;
private String licence_number;
private String phone;
private Integer depot_id;
public Integer getDriver_id() {
	return driver_id;
}
public void setDriver_id(Integer driver_id) {
	this.driver_id = driver_id;
}
public String getDriver_name() {
	return driver_name;
}
public void setDriver_name(String driver_name) {
	this.driver_name = driver_name;
}
public String getLicence_number() {
	return licence_number;
}
public void setLicence_number(String licence_number) {
	this.licence_number = licence_number;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Integer getDepot_id() {
	return depot_id;
}
public void setDepot_id(Integer depot_id) {
	this.depot_id = depot_id;
}

@Override
public String toString() {
	return "Driver [driver_id=" + driver_id + ", driver_name=" + driver_name + ", licence_number=" + licence_number
			+ ", phone=" + phone + ", depot_id=" + depot_id + "]";
}

}

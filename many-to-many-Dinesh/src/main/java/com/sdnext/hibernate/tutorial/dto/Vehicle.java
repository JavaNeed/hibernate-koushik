package com.sdnext.hibernate.tutorial.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private Integer vehicleId;
	
	@Column(name="VEHICLE_NAME")
	private String vehicleName; 
	
	@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> user = new ArrayList<UserDetails>();

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<UserDetails> getUser() {
		return user;
	}

	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}
}

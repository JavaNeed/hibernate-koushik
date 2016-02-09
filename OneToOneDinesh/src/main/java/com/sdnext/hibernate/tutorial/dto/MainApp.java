package com.sdnext.hibernate.tutorial.dto;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("--- Hibernate One To One mapping ---");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		// Vehicle
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Maruti Car");
		
		// User Details
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("First User");
		userDetails.setVehicle(vehicle);
		
		session.save(vehicle);
		session.save(userDetails);
		
		session.getTransaction().commit();
		session.close();
	}
}

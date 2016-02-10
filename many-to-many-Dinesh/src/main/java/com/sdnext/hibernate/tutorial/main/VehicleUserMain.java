package com.sdnext.hibernate.tutorial.main;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.dto.UserDetails;
import com.sdnext.hibernate.tutorial.dto.Vehicle;
import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class VehicleUserMain {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();  
        UserDetails user2 = new UserDetails();  
          
        Vehicle vehicle1 = new Vehicle();  
        Vehicle vehicle2 = new Vehicle();  
          
        vehicle1.setVehicleName("Car");  
        vehicle1.getUser().add(user1);  
        vehicle1.getUser().add(user2);  
          
        vehicle2.setVehicleName("Jeep");  
        vehicle2.getUser().add(user2);  
        vehicle2.getUser().add(user1);  
          
        user1.setUserName("First User");  
        user2.setUserName("Second User");
        
        user1.getVehicle().add(vehicle1);  
        user1.getVehicle().add(vehicle2);  
        
        user2.getVehicle().add(vehicle1);  
        user2.getVehicle().add(vehicle2);  
          
        Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();  
        
        // save vehicle1 and vehicle2
        session.save(vehicle1);  
        session.save(vehicle2);  
        
        // save user1 and user2
        session.save(user1);  
        session.save(user2);  
        
        session.getTransaction().commit();  
        session.close();  
	}
}

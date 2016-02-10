package com.sdnext.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.dto.UserDetails;
import com.sdnext.hibernate.tutorial.dto.Vehicle;
import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class UserVehicleMain{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        // Create Vehicle-1
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("BMW Car");
        
        // Create Vehicle-2
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Maruti Car");
        
        // Add All vehicles
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        
        UserDetails user = new UserDetails();
        user.setUserName("John Kerr");
        user.setVehicle(vehicles);
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(vehicle1);
        session.save(vehicle2);
        session.save(user);
        
        session.getTransaction().commit();
        session.close();
    }
}

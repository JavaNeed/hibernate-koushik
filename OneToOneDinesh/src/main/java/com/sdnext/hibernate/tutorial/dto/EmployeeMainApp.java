package com.sdnext.hibernate.tutorial.dto;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class EmployeeMainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
        Employee employee = new Employee("Nina", "Mayers", new Date(121212),"114-857-965");

        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);
        
        session.save(employee);
        
        List<Employee> employees = session.createQuery(" from Employee").list();
		for (Employee emp : employees) {
			System.out.println("---------------------");
			System.out.println(emp.getFirstname());
			System.out.println(emp.getLastname());
			System.out.println(emp.getBirthDate());
			System.out.println(emp.getCellphone());
			System.out.println(emp.getEmployeeId());
		}
		
		session.getTransaction().commit();
        session.close();
	}
}

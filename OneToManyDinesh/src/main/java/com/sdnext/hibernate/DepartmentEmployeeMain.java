package com.sdnext.hibernate;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.dto.Department;
import com.sdnext.hibernate.tutorial.dto.Employee;
import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class DepartmentEmployeeMain {
	public static void main(String[] args) {
		System.out.println("=== One To Many Relationship Examples ===");
		
		Department department = new Department();
		department.setDepartmentName("Sales");
		
		Employee emp1 = new Employee("Nina", "Mayers", "111");
        Employee emp2 = new Employee("Tony", "Almeida", "222");
 
        emp1.setDepartment(department);
        emp2.setDepartment(department);
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(emp1);
        session.save(emp2);
       // session.save(department);
        
        session.getTransaction().commit();
        session.close();
	}
}

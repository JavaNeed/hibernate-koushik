package com.sdnext.hibernate.tutorial.main;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.dto.UserGroup;
import com.sdnext.hibernate.tutorial.dto.User;
import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class UserGroupMain {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();  
        
        UserGroup groupAdmin = new UserGroup("Administrator Group");
        UserGroup groupGuest = new UserGroup("Guest Group");
         
        User user1 = new User("Tom", "tomcat", "tom@codejava.net");
        User user2 = new User("Mary", "mary", "mary@codejava.net");
         
        groupAdmin.addUser(user1);
        groupAdmin.addUser(user2);
         
        groupGuest.addUser(user1);
         
        user1.addGroup(groupAdmin);
        user2.addGroup(groupAdmin);
        user1.addGroup(groupGuest);
         
        session.save(groupAdmin);
        session.save(groupGuest);
         
        session.getTransaction().commit();
        session.close();       
	}
}

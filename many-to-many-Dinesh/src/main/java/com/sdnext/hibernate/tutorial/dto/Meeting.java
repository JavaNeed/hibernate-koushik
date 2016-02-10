package com.sdnext.hibernate.tutorial.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
public class Meeting {
	@Id
	@GeneratedValue
	private Long meetingId;
	private String subject;
	private Date meetingDate;
	
	@ManyToMany(mappedBy="meetings")
	private Set<Employee> employees = new HashSet<Employee>();
	
	
	public Meeting(){}
	
	public Meeting(String subject) {
        this.subject = subject;
        this.meetingDate = new Date();
    }

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}

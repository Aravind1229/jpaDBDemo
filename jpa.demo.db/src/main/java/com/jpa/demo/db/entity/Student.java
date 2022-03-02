package com.jpa.demo.db.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
@Id
@GeneratedValue
private Long id;
@Column(nullable=false)
private String name;
@OneToOne
private Passport passport;
@ManyToMany
@JoinTable(name="STUDENT_COURSE",joinColumns= @JoinColumn(name="STUDENT_ID"),inverseJoinColumns= @JoinColumn(name="COURSE_ID"))
private List<Course>courses=new ArrayList<>();
public Student() {
	
}
public Student(String name) {
	this.name=name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Passport getPassport() {
	return passport;
}
public void setPassport(Passport passport) {
	this.passport = passport;
}
public List<Course> getCourses() {
	return courses;
}
public void addCourse(Course course) {
	this.courses.add(course);
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Student name=" + name;
}
}

package com.jpa.demo.db.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
@Id
@GeneratedValue
private Long id;
@Column(nullable=false)
private String name;
@OneToMany(mappedBy="course")
private List<Review> reviews=new ArrayList<>();
@ManyToMany(mappedBy="courses")
private List<Student>students=new ArrayList<>();
public Course() {
	
}
public Course(String name) {
	this.name=name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Review> getReviews() {
	return reviews;
}
public void addReview(Review review) {
	this.reviews.add(review);
}
public void removeReview(Review review) {
	this.reviews.remove(review);
}
public List<Student> getStudents() {
	return students;
}
public void addStudent(Student student) {
	this.students.add(student);
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Course name=" + name;
}
}

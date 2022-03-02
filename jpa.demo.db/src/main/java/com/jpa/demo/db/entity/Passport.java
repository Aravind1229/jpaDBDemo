package com.jpa.demo.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
@Id
@GeneratedValue
private Long id;
@Column(nullable=false)
private String number;
@OneToOne(mappedBy="passport")
private Student student;
public Passport() {
	
}
public Passport(String number) {
	this.number=number;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Passport number=" + number;
}
}

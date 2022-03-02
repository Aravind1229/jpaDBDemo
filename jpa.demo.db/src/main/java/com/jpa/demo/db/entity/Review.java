package com.jpa.demo.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {
@Id
@GeneratedValue
private Long id;
private String rating;
private String description;
public Review() {
	
}
public Review(String rating,String description) {
	this.rating=rating;
	this.description=description;
}
public String getDescription() {
	return description;
}
public void setName(String description) {
	this.description = description;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Review  rating="+rating+" description=" + description;
}
}

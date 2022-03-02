package com.jpa.demo.db.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.demo.db.entity.Course;
import com.jpa.demo.db.entity.Review;
import com.jpa.demo.db.entity.Student;

import jakarta.persistence.EntityManager;
@Repository
@Transactional
public class CourseRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired
EntityManager em;
public Course findById(Long id) {
	return em.find(Course.class,id);
}
public Course save(Course course) {
	if (course.getId() == null) {
		em.persist(course);
	}
	else {
		em.merge(course);
	}
	return course;
}
public void deleteById(Long id) {
	Course course = findById(id);
	em.remove(course);
}
public void playwithEM() {
	logger.info("start");
	Course course1=new Course("web services");
	Course course2=new Course("Angular");
	em.persist(course1);
	em.persist(course2);
	em.flush();
	em.clear();
	em.detach(course2);
	course1.setName("web services updated");
}
public void addHardCodedReview() {
	Course course =findById(10002L);
	logger.info("Reviews -> {}",course.getReviews());
	Review review1=new Review("5","Great Hands-on stuff");
	Review review2=new Review("5","Hats off");
	course.addReview(review1);
	review1.setCourse(course);
	course.addReview(review2);
	review2.setCourse(course);
	em.persist(review1);
	em.persist(review2);
}
public void addReview(long courseId,List<Review> reviews) {
	Course course =findById(courseId);
	logger.info("Reviews -> {}",course.getReviews());
	for(Review review:reviews) {
	course.addReview(review);
	review.setCourse(course);
	em.persist(review);
	}
}
public void retrieveCourseWithStudents() {
	Course course=em.find(Course.class,10001L);
	logger.info("Course -> {}",course);
	logger.info("Students -> {}",course.getStudents());
}
}

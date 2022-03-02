package com.jpa.demo.db.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.demo.db.entity.Course;

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
}

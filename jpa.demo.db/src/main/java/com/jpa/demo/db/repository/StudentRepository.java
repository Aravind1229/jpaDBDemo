package com.jpa.demo.db.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.demo.db.entity.Course;
import com.jpa.demo.db.entity.Passport;
import com.jpa.demo.db.entity.Student;

import jakarta.persistence.EntityManager;
@Repository
@Transactional
public class StudentRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired
EntityManager em;
public Student findById(Long id) {
	return em.find(Student.class,id);
}
public Student save(Student student) {
	if (student.getId() == null) {
		em.persist(student);
	}
	else {
		em.merge(student);
	}
	return student;
}
public void deleteById(Long id) {
	Student student = findById(id);
	em.remove(student);
}
public void saveStudentWithPassport() {
	Passport passport=new Passport("Z123456");
	em.persist(passport);
	Student student=new Student("Mike");
	student.setPassport(passport);
	em.persist(student);
}
public void retrieveStudentWithPassport() {
	Student student=em.find(Student.class,20001L);
	logger.info("Student -> {}",student);
	logger.info("Passport -> {}",student.getPassport());
}
public void retrieveStudentWithCourses() {
	Student student=em.find(Student.class,20001L);
	logger.info("Student -> {}",student);
	logger.info("Courses -> {}",student.getCourses());
}
public void insertHardCodedStudentandCourse() {
	Student student =new Student("Jack");
	Course course=new Course("MICRO SERVICES");
	em.persist(student);
	em.persist(course);
	student.addCourse(course);
	course.addStudent(student);
	em.persist(student);
}
public void insertStudentandCourse(Student student,Course course) {
	student.addCourse(course);
	course.addStudent(student);
	em.persist(student);
	em.persist(course);
}
}

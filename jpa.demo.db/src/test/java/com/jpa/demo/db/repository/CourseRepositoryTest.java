package com.jpa.demo.db.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.demo.db.Application;
import com.jpa.demo.db.entity.Course;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
class CourseRepositoryTest {
	@Autowired
	CourseRepository repository;
	@Test
	void findByIdTest() {
		Course course = repository.findById(10001L);
		assertEquals("JPA",course.getName());
	}
	@Test
	@DirtiesContext
	void deleteByIdTest() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	@Test
	@DirtiesContext
	void saveTest() {
		Course course = repository.findById(10001L);
		assertEquals("JPA",course.getName());
		course.setName("JPA Updated");
		repository.save(course);
		Course course1 = repository.findById(10001L);
		assertEquals("JPA Updated",course1.getName());
	}
	@Test
	@DirtiesContext
	void playwithem() {
		repository.playwithEM();
	}

}

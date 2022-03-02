package com.jpa.demo.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.demo.db.entity.Course;
import com.jpa.demo.db.repository.CourseRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired
private CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001L);
		logger.info("course 10001 -> {}",course);
		//repository.deleteById(10001L);
		repository.playwithEM();
	}

}

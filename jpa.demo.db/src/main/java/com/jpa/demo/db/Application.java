package com.jpa.demo.db;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.demo.db.entity.Course;
import com.jpa.demo.db.entity.Review;
import com.jpa.demo.db.entity.Student;
import com.jpa.demo.db.repository.CourseRepository;
import com.jpa.demo.db.repository.StudentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired
private CourseRepository courseRepository;
@Autowired
private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Course course = courseRepository.findById(10001L);
		//logger.info("course 10001 -> {}",course);
		//courseRepository.deleteById(10001L);
		//courseRepository.playwithEM();
		//studentRepository.saveStudentWithPassport();
		//studentRepository.retrieveStudentWithPassport();
		//courseRepository.addHardCodedReview();
		//List<Review> reviews=new ArrayList<>();
		//reviews.add(new Review("5","Great Hands-on stuff"));
		//reviews.add(new Review("5","Hats off"));
		//courseRepository.addReview(10003L,reviews);
		//studentRepository.retrieveStudentWithCourses();
		//courseRepository.retrieveCourseWithStudents();
		//studentRepository.insertHardCodedStudentandCourse();
		studentRepository.insertStudentandCourse(new Student("Jack"),new Course("MICRO SERVICES"));	
	}

}

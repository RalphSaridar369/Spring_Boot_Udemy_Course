package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
			deleteCourse(appDAO);
			System.out.println("Running");
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id =10;
		appDAO.deleteCourse(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id =10;

		Course course = appDAO.findCourseById(id);

		course.setTitle("New Course");

		appDAO.updateCourse(course);

	}

	private void updateInstructor(AppDAO appDAO) {
		int id =1;
		Instructor instructor= appDAO.findInstructorById(id);

		instructor.setLastName("Tester");

		appDAO.updateInstructor(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		Instructor instructor= appDAO.findInstructorById(id);
		List<Course> courses=appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=1;
		Instructor instructor= appDAO.findInstructorById(id);
		System.out.println("instructor: "+instructor);
		System.out.println("instructor: "+instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor temp = new Instructor("Chad","Darby","cd@hotmail.com");

		InstructorDetail tempDetail = new InstructorDetail("https://www.youtube.com","Youtuber");

		temp.setInstructorDetail(tempDetail);

		System.out.println(temp);
		appDAO.save(temp);

		Course tempC1 = new Course("Air Guitar");
		Course tempC2 = new Course("Electric Guitar");


		System.out.println(tempC1+""+tempC1);
		temp.add(tempC1);
		temp.add(tempC2);

		System.out.println(temp);
		appDAO.save(temp);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructorById(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int id=1;

		Instructor instructor= appDAO.findInstructorById(id);

		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor temp = new Instructor("Chad","Darby","cd@hotmail.com");

		InstructorDetail tempDetail = new InstructorDetail("https://www.youtube.com","Youtuber");

				temp.setInstructorDetail(tempDetail);

		System.out.println(temp);
		appDAO.save(temp);
	}

}

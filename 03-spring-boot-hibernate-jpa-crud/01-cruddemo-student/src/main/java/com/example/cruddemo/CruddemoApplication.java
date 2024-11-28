package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);

		};


	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("Updated");
		studentDAO.update(student);
		System.out.println("Student updated "+student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create
		Student ts = new Student("J","D","JD@gmail.com");
		//save
		studentDAO.save(ts);
		//display id of saved
		System.out.println(ts.getId());
		int id = ts.getId();
		//retrieve student
		Student st = studentDAO.findById(id);
		//display student
		System.out.println(""+st);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		Student tempStudent = new Student("John1","Doe","JohnDoe@gmail.com");
		Student tempStudent2 = new Student("John2","Doe","JohnDoe@gmail.com");

		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);
	}

	private void createStudent(StudentDAO studentDAO) {
		//		create the student object

		Student tempStudent = new Student("John","Doe","JohnDoe@gmail.com");
		//		save the student object

		studentDAO.save(tempStudent);
	// 		display the id
		System.out.println(tempStudent.getId());
	}
}

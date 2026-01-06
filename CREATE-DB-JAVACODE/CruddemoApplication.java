package com.spring.example.cruddemo;

import com.spring.example.cruddemo.DAO.StudentDAO;
import com.spring.example.cruddemo.DAO.StudentDAOImpl;
import com.spring.example.cruddemo.entity.Student;
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
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			retriveStudent(studentDAO);
//			findAll(studentDAO);
//			update(studentDAO);
//			remove(studentDAO);
			removeAll(studentDAO);
		};
	}

	public void removeAll(StudentDAO studentDAO){
		studentDAO.removeAll();
		List<Student> li = studentDAO.findAll();
		for(Student s: li){
			System.out.println(li);
		}
	}


	public void remove(StudentDAO studentDAO){
		studentDAO.remove(1);
		List<Student> li = studentDAO.findAll();
		for(Student s : li){
			System.out.println(s);
		}
	}


	public void update(StudentDAO studentDAO){
		Student stu = studentDAO.update(1);
		System.out.println(stu);
	}

	public void findAll(StudentDAO studentDAO){
		List<Student> St = studentDAO.findAll();

		for(Student Stu : St){
			System.out.println(Stu);
		}
	}


	private void retriveStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.retrive(1));
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}




}

package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class StudentMgmtApp {
	
//	private static final String PERSISTENCE_UNIT_NAME = "MyStudentMgmtApp";
//    private static EntityManagerFactory factory;
//    
//    public StudentMgmtApp() {
//    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//    }
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}
	
	public void run(String... args) throws Exception {
		//Task1
		System.out.println("Start Task1...");
		Student s = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019, 5, 24));
		Student savedStudent = saveStudent(s);
		System.out.println("Saved Student ...");
		System.out.println(savedStudent);

	}

	private Student saveStudent(Student stu) {

		return studentRepository.save(stu);
	}
	
	

}

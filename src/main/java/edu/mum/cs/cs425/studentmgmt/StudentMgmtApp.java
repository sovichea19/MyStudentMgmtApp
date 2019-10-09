package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Student;

@SpringBootApplication
public class StudentMgmtApp {
	
	private static final String PERSISTENCE_UNIT_NAME = "MyStudentMgmtApp";
    private static EntityManagerFactory factory;
    
    public StudentMgmtApp() {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
		
		System.out.println("Starting application...");
		StudentMgmtApp app = new StudentMgmtApp();
		
		//Student data: s1: { studentId:1, studentNumber: 000-61-0001, firstName:Anna, middleName: Lynn, LastName: Smith, cgpa:3.45, dateOfEnrollment:2019/5/24 }
		
		Student stu1 = new Student(1, "000-61-0001", "Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019, 5, 24));
		
		saveStudent(stu1);
		
		System.out.println("Done save student...");
		
	}
	
	
	private static void saveStudent(Student stu) {
		if (stu != null) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(stu);
			em.getTransaction();
			em.close();
			factory.close();
		}
	}

}

package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentMgmtApp {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TranscriptRepository transcriptRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}
	
	public void run(String... args) throws Exception {
		//Task1
		System.out.println("Start Task1...");
		Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019, 5, 24));
		Student savedStudent = saveStudent(s1);
		System.out.println("Saved Student ...");
		System.out.println(savedStudent);
		
		//Task2
		//Student & Transcript
		Transcript transcript = new Transcript("BS Computer Science");
		s1.setTranscript(transcript);
		transcript.setStudent(s1);
		Student savedStudent2 = saveStudent(s1);
		System.out.println(savedStudent2);

	}

	private Student saveStudent(Student stu) {

		return studentRepository.save(stu);
	}
	
	

}

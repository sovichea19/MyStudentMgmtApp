package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentMgmtApp {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TranscriptRepository transcriptRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
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
		transcript.setStudent(s1);
		s1.setTranscript(transcript);
		Transcript savedTranscript = saveTranscript(transcript);
		System.out.println(savedTranscript);
		
		//Task3
		//Student & Classroom
		Classroom classroom = new Classroom("McLaughlin building", "M105");			
		classroom.addStudent(s1);	
		s1.setClassroom(classroom);
		Classroom savedClassRoom = saveClassroom(classroom);
		System.out.println(savedClassRoom);

	}

	private Classroom saveClassroom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	private Transcript saveTranscript(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}

	private Student saveStudent(Student stu) {

		return studentRepository.save(stu);
	}
	
	
	
	

}

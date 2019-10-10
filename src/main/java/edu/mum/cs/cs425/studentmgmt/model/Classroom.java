package edu.mum.cs.cs425.studentmgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Classrooms")
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long classroomId;
	private String buildingName;
	private String roomNumber;
	
	@OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student s) {
		this.students.add(s);
	}

	public Classroom(String buildingName, String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@Override
	public String toString() {		
		return String.format("classroomId:  %d, buildingName: %s, roomNumber: %s" , this.classroomId, this.buildingName, this.roomNumber);
	}

}
package kr.co.exam06;

import java.util.Objects;

public class Student {

	private String name;
	private int senior;
	private int classroom;
	private int number;
	
	
	public Student(String name, int senior, int classroom, int number) {
		this.name = name;
		this.senior = senior;
		this.classroom = classroom;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSenior() {
		return senior;
	}
	public void setSenior(int senior) {
		this.senior = senior;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classroom, name, number, senior);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classroom == other.classroom && Objects.equals(name, other.name) && number == other.number
				&& senior == other.senior;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", senior=" + senior + ", classroom=" + classroom + ", number=" + number + "]";
	}
}

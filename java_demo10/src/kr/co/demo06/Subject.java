package kr.co.demo06;

import java.io.Serializable;

public class Subject implements Serializable{ // 직렬화 조치 취함.
	private String name;
	private double score;
	
	public Subject(String name, double score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + "]";
	}
	
}

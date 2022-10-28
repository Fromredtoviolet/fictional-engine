package kr.co.exam01.school;

import kr.co.exam01.school.exception.NumberRangeOverException;

public class Subject {
	
	private static final int SCORE_MAX = 100;
	private static final int SCORE_MIN = 0;
	private String name;
	private double score;
	private char grade;
	
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
		if(score >= SCORE_MIN && score <= SCORE_MAX) {
			this.score = score;
			this.setGrade();
			return;
		} else if(score < SCORE_MIN) {
			throw new NumberRangeOverException();
		}
		throw new NumberRangeOverException(SCORE_MIN, SCORE_MAX);
	}
		
	public char getGrade() {
		return grade;
	}
	
	private void setGrade() {
		switch((int)this.score / 10) {
		case 10:
		case 9:
			this.grade = 'A'; break;
		case 8:
		case 7: 
			this.grade = 'B'; break;
		case 6:
		case 5: 
			this.grade = 'C'; break;
		default:
			this.grade = 'F'; 
		}
	}
	
	public Subject grateThen(Subject subject) {
		if(this.score > subject.score) {
			return this;
		}
		return subject;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%c: %.2f)", name, grade, score);
	}
	
}

package kr.co.exam01.school;

import kr.co.exam01.school.exception.NegativeNumberException;
import kr.co.exam01.school.exception.NumberRangeOverException;

public class Subject {
	
	private static final int SCORE_MAX = 100;
	private static final int SCORE_MIN = 0;
	
	protected String name;
	protected double score;
	protected String grade;
	
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
			throw new NegativeNumberException();
		}
		throw new NumberRangeOverException(SCORE_MIN, SCORE_MAX);
	}
		
	public String getGrade() {
		return grade;
	}
	
	private void setGrade() {
		int offset = (int)this.score / 10;
		offset = offset >= 9 ? 9 : offset <= 4 ? 4 : offset;
		this.grade = "" + (char)(74 - offset);
	}
	
	public Subject grateThen(Subject subject) {
		if(this.score > subject.score) {
			return this;
		}
		return subject;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s: %.2f)", name, grade, score);
	}
	
}

package kr.co.exam05;

public class Score {

	private double score;
	private char grade;
	
	public Score(double score) {
		this.score = score;
		this.setGrade();
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		// A~F까지의 등급 계산
		switch((int)this.score / 10) {
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
		default:
			this.grade = 'F';
		}
		
	}
	
	public void setGrade() {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + ", grade=" + grade + "]";
	}


}

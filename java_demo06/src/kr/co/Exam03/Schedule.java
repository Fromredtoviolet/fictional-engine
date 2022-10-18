package kr.co.Exam03;

public class Schedule {
	private int year;
	private int month;
	private int day;
	private boolean allDay;
	private Clock startTime;
	private Clock endTime;
	private boolean leaf; // 윤년
	private int lastDayForMonth[] = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 // 매달 말일
	}; 
	
	
	public Schedule(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		this.allDay = false; // 어차피 논리형은 기본 초기화값이 false이므로 생략 가능.
		this.startTime = new Clock(9, 0, 0);
		this.endTime = new Clock(10, 0, 0);
	}
	
	private void setYear(int year) {
		this.year = year;
		this.leaf = false;
		if(this.year % 4 == 0) { 		// 윤년 구하는 if문
			if(this.year % 100 == 0) {	
				if(this.year % 400 == 0) {
					this.leaf = true;	// 기본은 false지만 윤년이면 true로 바꿔라.
				}
			} else {
				this.leaf = true;
			}
		}
	}
	
	private void setMonth(int month) {
		this.month = 1; // 잘못 입력하면 무조건 1이 되도록 세팅.(13월, 14월 등)
		if(month >= 1 && month <= 12) {
			this.month = month;
		}
	}
	
	private void setDay(int day) {
		this.day = 1; // 일자 설정을 0, -1 등 잘못 입력하면 무조건 1로 세팅.
		int lastDay = this.lastDayForMonth[this.month - 1];
		
		if(this.month == 2 && this.leaf) {
			lastDay += 1; // 윤년이면 마지막일(28일)에 1을 더하라.
		}
		
		if(day >= 1) {
			if(day <= lastDay) {
				this.day = day;
		} else {
			this.day = lastDay; // 사용자가 마지막일을 잘못 입력할 경우 고쳐주는 것.
		}
		}
	}
		
	public void changeAllDay() {
		this.allDay = true;
		this.startTime = new Clock(0, 0, 0);
		this.endTime = new Clock(23, 59, 59);
	}
	
	public void changeTime(Clock startTime, Clock endTime) {
		this.allDay = false;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void changeDate(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
			// ↓ String이 아닌 void를 사용한다면 반환이 안 되므로 메서드가 끝나면 str이 소멸됨.
	public String getSchedule() { 
		String str = ""; // str은 이 메서드 안에서만 쓰이는 지역변수.
		str += this.year + "년 " + this.month + "월 " + this.day + "일 \n";
		str += this.startTime.getTime() + " 부터 " + this.endTime.getTime() + " 까지\n";
		str += this.allDay ? "하루종일 " : "";
		str += "스케쥴이 잡혀 있습니다.";
		return str; 
		// 만들어진 지역변수 str(문자열)을 호출 시에 반환return해주므로, 메서드가 끝나도 소멸되지 않게 한다.
	} 	// 누적합을 해야하므로 +=를 사용한다. 그냥 =을 사용하면 마지막 문장으로 덮어씌워진다.
} 		// str += abcd 의 경우, str = str + abcd와 같은 말이다!





	/*
	 * 내가...찌끄려본...코드^^~~~
	 * 이런 클래스는 되도록 프린트 출력구문 쓰지 말기~~ 프린트문은 웬만하면 이그잼에 쓰기
	public void changeFullDay(boolean fullDay, int startTime, int endTime) {
		this.startTime = 0;
		this.endTime = 24;
		this.fullDay = true;
	}
	
	public void changeToTime() {
		
	}
	
	public void changeDays() {
		
	}
	
	public void confirm() {
		
	}
}
	*/
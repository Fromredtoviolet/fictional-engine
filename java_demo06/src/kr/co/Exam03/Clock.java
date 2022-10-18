package kr.co.Exam03;

public class Clock {
	private int hour;
	private int minute;
	private int second;
	private boolean am;
	private boolean pm;
	
	public Clock(int hour, int minute, int second) {
		this.hour = hour % 24; // 25시로 입력되면 나머지인 1로 출력되게끔.
		this.minute = minute % 60;
		this.second = second % 60;
		setAmPm(); // 호출에 의해 동작하므로 선언보다 앞에 있어도 OK
	} // 요기까지 생성자!
	
	private void setAmPm() {
		if(this.hour >= 12) {
			this.am = false;
			this.pm = true;
		} else {
			this.am = true;
			this.pm = false;
		}
	}
	
	public String getAmPm() {
		return this.am ? "오전" : "오후";
	}
	
	public String getTime() {
		String str = "";
		
		str += this.hour <= 9 ? "0" + this.hour : this.hour;
		str += ":";
		
		str += this.minute <= 9 ? "0" + this.minute : this.minute;
		str += ":";
		
		str += this.second <= 9 ? "0" + this.second : this.second;
		
		return str;
	} // 출력 형식을 00:00:00 로 맞추기 위한 과정
	
	
	public void nextSecond() {
		this.second++;
		if(this.second >= 60) {
			this.nextMinute();
			this.second = 0;
		}
	} // 59초 + 1초는 60초가 되므로 1분 00초로 변경되게 하는 식.
	
	public void nextMinute() {
		this.minute++;
		if(this.minute >= 60) {
			this.nextHour();
			this.minute = 0;
		}
	} // 마찬가지로 59분+1분은 60분이니 1시간 00분.
	
	public void nextHour() {
		this.hour++;
		this.hour %= 24;
		this.setAmPm(); // 일자 설정까지는 안 했으므로 시간은 위와 같은 설정을 하지 않고,
						// 대신 오전 오후 바뀌게끔 메서드 호출만.
	} 
	
	public void prevSecond() {
		this.second--;
		if(this.second <= -1) {
			this.prevMinute();
			this.second = 59;
		}
	}
	
	public void prevMinute() {
		this.minute--;
		if(this.minute <= -1) {
			this.prevHour();
			this.minute = 59;
		}
	}
	
	public void prevHour() {
		this.hour--;
		this.hour %= 24;
		setAmPm();
	}


	/*
	 * 내가 얼레벌레 쓴 코드.......ㅋ
	 * 
	public void oneSecAgo(int second) {
		this.second = second - 1;
		System.out.println("시간을 1초 전으로 옮겼습니다.");
	}
	public void oneSecAfter(int second) {
		this.second = second + 1;
		System.out.println("시간을 1초 후로 옮겼습니다.");
	}
	
	public void oneMinAgo(int minute) {
		this.minute = minute - 1;
		System.out.println("시간을 1분 전으로 옮겼습니다.");
	}
	
	public void oneMinAfter(int minute) {
		this.minute = minute + 1;
		System.out.println("시간을 1분 후로 옮겼습니다.");
	}
	
	public void oneHourAgo(int hour) {
		this.hour = hour - 1;
		System.out.println("시간을 1시간 전으로 옮겼습니다.");
	}
	
	public void oneHourAfter(int hour) {
		this.hour = hour + 1;
		System.out.println("시간을 1시간 후로 옮겼습니다.");
	}
	
	
	public int getSecond() { 
		return this.second;
	}
	public int getMinute() { 
		return this.minute;
	}
	public int getHour() { 
		return this.hour;
		
	}
	*/
	
}

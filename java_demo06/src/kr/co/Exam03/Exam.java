package kr.co.Exam03;

public class Exam {

	public static void main(String[] args) {
		
		// 시계 클래스
		Clock clock = new Clock(8, 5, 2);
		clock.nextSecond();
		System.out.println(clock.getAmPm() + " " + clock.getTime());
		
		clock.prevSecond();
		System.out.println(clock.getAmPm() + " " + clock.getTime());

		
		// 스케줄 클래스
		Schedule schedule = new Schedule(2022, 10, 18);
		System.out.println(schedule.getSchedule());
		
		schedule.changeAllDay();
		System.out.println(schedule.getSchedule());
		
		schedule.changeDate(2022, 10, 19);
		System.out.println(schedule.getSchedule());
		
		schedule.changeTime(new Clock(45, 70, 100), new Clock(45, 70, 100));
		System.out.println(schedule.getSchedule());
		// Clock이라는 클래스를 만들어두었으므로 걔를 가져다 쓸 수 있다! (다른 패키지면 임포트문 쓰면 됨)
		// Schedule 클래스에 작성해둔 changeTime 메서드에 Clock startTime라는 입력값의 자리가 마련되어 있으므로,
		// 거기에 입력값을 합치면 Clock startTime = new Clock(45, 70, 100) 이라는 구문이 완성된다. 익숙하쥬?
		
		
		// 메뉴판 클래스
		Menu menu = new Menu();
		
	}

}

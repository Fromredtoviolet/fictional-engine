package kr.co.Exam03;

import java.util.Scanner;

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
		
		menu.add("라면", 3500);
		menu.add("치즈라면", 4000);
		menu.add("김밥", 3000);
		menu.add("치즈김밥", 3500);
		menu.add("참치김밥", 3500);
		menu.add("돈까스", 4000);
		menu.add("치즈돈까스", 4500);
		
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int total = 0;
		while(true) {
			System.out.print("메뉴 선택 : ");
			name = sc.nextLine();
			
			if(name.equals("exit")) {
				break;
			}
			
			int price = menu.getPrice(name);
			if(price != -1) {
				System.out.printf("%s 메뉴를 선택하였습니다. 가격은 %,d 원입니다.\n", name, price);
				total += price;
			} else {
				System.out.printf("%s 에 해당하는 메뉴는 없습니다.\n", name);
			}
		}
		System.out.printf("지금까지 선택한 메뉴의 총 가격은 %,d 원입니다.\n", total);
		
		/*
		Menu m = new Menu();
		String s = m.getAll();
		System.out.print(s);
		
		System.out.println("추가 확인");
		m.add("만두", 4000);
		s = m.getAll();
		System.out.print(s);
		
		System.out.println("수정 확인");
		m.update("김밥", 4000);
		s = m.getAll();
		System.out.print(s);
		
		System.out.println("\n삭제 확인");
		m.remove("김밥");
		s = m.getAll();
		System.out.print(s);
		
		System.out.println("\n가격 확인");
		int price = m.getPrice("만두");
		System.out.print(price);
		
		객체를 담는 변수 공간에는 초기화를 안하면 기본값 null이 저장된다.
		*/
		
		
		
		
	}

}

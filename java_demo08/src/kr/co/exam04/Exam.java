package kr.co.exam04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 현재 날짜를 구하고 다음 형식에 맞추어 출력하세요.
		 * 		1. 2022/01/01
		 * 		2. 2022년 01월 01일
		 * 		3. 12시 30분 30초
		 * 		4. 12:30:30
		 * 
		 * 2022년 10월 중 주말에 해당하는 날짜만 Date 배열에 담아 출력하세요.
		 * 
		 */
		
		Date date = new Date();
		System.out.println("현재 날짜 : " + date);
		
		String year = String.format("%tY", date);
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		String sDay = String.format("%tA", date);
		String hour = String.format("%tH", date);
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		
		System.out.println("1. " + year + "/" + month + "/" + day);
		System.out.println("2. " + year + "년 " + month + "월 " + day + "일");
		System.out.println("3. " + hour + "시 " + minute + "분 " + second + "초");
		System.out.println("4. " + hour + ":" + minute + ":" + second);
		System.out.println("-----------------------");
		
		GregorianCalendar gc = new GregorianCalendar(2022, 9, 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE"); // EEEE는 X요일 형식
		int lastDate = gc.getActualMaximum(Calendar.DAY_OF_MONTH); 
		// 최대치를 구하는 메서드에 한 달의 일자를 매개변수로 썼으니 이는 즉 그 달의 말일을 구하는 것.
		
		Date[] dateArr = new Date[0];
		
		for(int i = 1; i <= lastDate; i++) { 
			int iDay = gc.get(Calendar.DAY_OF_WEEK);
			switch(iDay) {
			case Calendar.SUNDAY:
				System.out.println(df.format(gc.getTime()));
				break;
			case Calendar.SATURDAY:
				System.out.println(df.format(gc.getTime()));
				break;
			}
			gc.add(Calendar.DATE, 1); // 캘린더 데이트에 1일을 더해라. 빼고싶으면 -1.
		}
		
	}
}



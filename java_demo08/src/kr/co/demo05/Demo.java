package kr.co.demo05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {

	public static void main(String[] args) throws ParseException {
		/*
		 * 날짜 관련 클래스
		 * 		- Date : 시스템으로부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
		 * 
		 * 		- GregorianCalendar : Calendar 클래스를 상속하여 작성된 하위 클래스로 년, 월, 일
		 * 							  시, 분, 초를 다룰 수 있게 구성된 클래스
		 * 
		 * 		- SimpleDateFormat : 날짜 및 시간 정보를 정해진 형식에 맞추어 문자열로 만들어주거나
		 * 							 문자열로 만들어진 날짜 및 시간 정보를 Date 객체로 만들어주는 클래스
		 */

		/*
		 * Date 클래스
		 */
		Date date = new Date(); // 임포트를 꼭 java.util.Date로 해줘야 함
		System.out.println(date);
		
		// 1970년 1월 1일 0시 0분 0초부터 시작된 현재까지의 밀리초
		long ms = date.getTime();
		System.out.println(ms);
		
		String year = String.format("%tY", date); // %t 꼭 붙여주기
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		String sDay = String.format("%tA", date);
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		/*
		 * GregorianCalendar
		 */
		GregorianCalendar gc = new GregorianCalendar(); // 임포트는 java.util.GregorianCalendar
		gc = new GregorianCalendar(2022, 0, 1);
		gc = new GregorianCalendar(2022, 0, 1, 12, 30, 0);
		// 월月은 특이하게도 0부터 시작한다. 0=1월, 1=2월, 2=3월 ...
		System.out.println(gc.getTime());
		
		int iYear = gc.get(Calendar.YEAR);
		int iMonth = gc.get(Calendar.MONTH) + 1; // 위에서 0으로 설정해놔서 1 더해줌.
		int iDate = gc.get(Calendar.DATE);
		int iDay = gc.get(Calendar.DAY_OF_WEEK);
		sDay = "";
		
		switch(iDay) {
		case Calendar.SUNDAY: // 요일은 이미 캘린더 클래스에 상수로 설정되어 있으므로 이렇게 가져와서 쓰면 된다.
			sDay = "일요일"; break;
		case Calendar.MONDAY:
			sDay = "월요일"; break;
		case Calendar.TUESDAY:
			sDay = "화요일"; break;
		case Calendar.WEDNESDAY:
			sDay = "수요일"; break;
		case Calendar.THURSDAY:
			sDay = "목요일"; break;
		case Calendar.FRIDAY:
			sDay = "금요일"; break;
		case Calendar.SATURDAY:
			sDay = "토요일"; break;
		}
		
		System.out.println(iYear + "년 " + iMonth + "월 " + iDate + "일 " + sDay);
		
		// 그렇다면 시,분,초는?
		gc.get(Calendar.HOUR);
		gc.get(Calendar.MINUTE);
		gc.get(Calendar.SECOND);
		gc.get(Calendar.MILLISECOND);
		
		/*
		 * SimpleDateFormat
		 * 날짜 형식을 지정해줄 수 있다. 
		 * SimpleDateFormat 위에 커서 올리면 나오는 설명을 쭉 내려보면 어떤 포맷을 써야하는지 나옴.
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String fDate = df.format(new Date());
		System.out.println(fDate);
		
		String strDate = "2022년 10월 25일 12시 30분 30초";
		date = df.parse(strDate); 
		// 내가 지정한 날짜 포맷에 해당하는 문자열 데이터가 있으면(형식이 매치가 되면) 
		// 이 문자열이 날짜 객체로 parsing되어 저장할 수 있다.
		System.out.println(date);

	
	}

}

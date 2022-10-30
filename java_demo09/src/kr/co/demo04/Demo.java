package kr.co.demo04;

import java.time.format.DateTimeParseException;

public class Demo {

	public static void methodA() throws DateTimeParseException {
		String strDate = "19901010";
		
		if(strDate.length() != 8) {
			throw new DateTimeParseException("잘못된 날짜 혹은 시간 형식입니다.", "파싱정보", 1);
	}
	}	
		
	public static void main(String[] args) throws DateTimeParseException {
		methodA();
	}
	
}

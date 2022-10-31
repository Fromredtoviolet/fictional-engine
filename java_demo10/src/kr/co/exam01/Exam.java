package kr.co.exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exam {
	
	public static String getYearMonth() {
		File f = new File("D:\\weekend.txt");
		String data = "";

		try(FileInputStream fis = new FileInputStream(f)) { // 숫자 내용이라 바이트 스트림 가능
			byte buffer[] = new byte[(int)f.length()];
			fis.read(buffer);
			data = new String(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	public static void main(String[] args) {
		/*
		 * weekend.txt 파일에 작성된 년월 정보를 읽고 해당 년월의
		 * 주말정보만을 weekend.result 파일에 출력하게 한다.
		 */
		String weekend = getYearMonth();
		int year = Integer.parseInt(weekend.substring(0, 4));
		int month = Integer.parseInt(weekend.substring(4));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 EEEE");
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, 1);
		int lastDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);

		StringBuilder sb = new StringBuilder(128);
		for(int i = 0; i < lastDay; i++) {
			switch(gc.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SATURDAY:
			case Calendar.SUNDAY:
				sb.append(df.format(gc.getTime()) + "\r\n");
			}
			gc.add(Calendar.DATE, 1);
		}
		
		// weekend.result 파일에 쓰기 작업 진행
		// System.out.println(sb.toString());
		saveWeekends(sb.toString());
	}
	
	public static void saveWeekends(String data) {
		File f = new File("D:\\weekend.result");

		try(FileWriter fw = new FileWriter(f)) {
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

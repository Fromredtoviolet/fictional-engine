package kr.co.demo04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileOutputStream
		 */
		File f = new File("D:\\입출력테스트.txt");
		
		try(FileOutputStream fos = new FileOutputStream(f, true)) { // true는 append 옵션. 실행할때마다 기존 내용에 또 추가됨.
			fos.write(65); // '작성'을 해주는 메서드. 'A'가 작성된다.
			fos.write(66);
			fos.write(67);
			fos.write(68);
			fos.write(69);
			fos.write("한글문자열".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

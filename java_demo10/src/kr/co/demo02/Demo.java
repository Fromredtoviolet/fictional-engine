package kr.co.demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileInputStream
		 * 		- 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
		 */
		
		File f = new File("D:\\입출력테스트.txt");
		
		try(FileInputStream fis = new FileInputStream(f)) { // try~with~resource.
			// 입출력 작업 끝나면 꼭 close 해줘야하는데, 이걸 해주면 귀찮게 finally로 close 안 해도 된다.
			
			byte[] buffer = new byte[8]; 
			byte[] datas = new byte[(int)f.length()];
			
			int offset = 0;
			while(true) {
//				int readByte = fis.read(); // read()가 1바이트씩밖에 못 읽으므로 반복문 이용
				int readByte = fis.read(buffer); // 읽은 바이트 수를 반환. 현재 buffer의 크기는 8이니까 8까지 반환.
				if(readByte == -1) { //↑얕은복사
					break;
				}
				System.arraycopy(buffer, 0, datas, offset, readByte);
				// 얕은복사된 buffer를 datas에 깊은복사하니까, 읽는거랑 별개의 복사본을 만든 셈이다.
				offset += readByte;
			}
			
			System.out.print(Arrays.toString(datas));
			System.out.print(new String(datas));
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 읽기 작업 중 문제가 발생하였습니다.");
			e.printStackTrace();
		} 
	}

}

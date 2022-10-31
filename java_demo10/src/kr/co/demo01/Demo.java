package kr.co.demo01;

import java.io.File;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 입출력
		 * 		- 컴퓨터 내부/외부 장치간에 데이터를 교환하기 위해 사용
		 * 		- 프로그램을 기준으로 내부/외부 장치에서 데이터가 현재 동작하는
		 * 		  프로그램으로 들어오면 입력, 반대로 현재 동작하는 프로그램에서
		 * 		  내부/외부 장치로 내보내면 출력 이라고 한다.
		 * 		  (하드디스크의 파일을 프로그램 내에서 사용할 수 있도록 불러올 때는 입력/
		 * 		  반대로 프로그램에서 생성한 데이터를 하드디스크의 파일로 내보낼 때는 출력)
		 * 		- 입출력은 입력스트림, 출력스트림이 개별로 존재하며 입력스트림으로는 입력만,
		 * 		  출력스트림으로는 출력만 수행할 수 있다.
		 * 
		 * 스트림(Stream) 
		 * 		- 두 장치간에 데이터를 교환하기 위해 생성한 데이터 통로
		 * 		- 스트림은 입력/출력 스트림으로 나누어져 있고 또한 그 안에서 바이트기반스트림과
		 * 		  문자기반스트림으로 나누어져 있다.
		 * 		- 바이트기반스트림의 경우 이미지, 영상, 실행파일 등의 바이트기반으로 생성된 데이터를
		 * 		  입출력할 때 사용한다. (메모장으로 실행시켰을 때 읽을 수 없다.)
		 * 		- 문자기반스트림은 텍스트 문서 등의 문자기반으로 생성된 데이터를 입출력할 때 
		 * 		  사용한다. (메모장으로 실행시켰을 때 읽을 수 있다.)
		 */
		
		File f = new File("D:\\샘플파일.txt"); // 반드시 확장자명까지 적을 것.
		
		System.out.printf("%d Byte\n", f.length()); // 파일 크기
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 에 수정함\n", f.lastModified()); // 마지막 수정 시점
		
		System.out.printf("파일유무 : %s\n", f.isFile());
		System.out.printf("폴더유무 : %s\n", f.isDirectory());
		System.out.printf("숨김유무 : %s\n", f.isHidden());
		
		System.out.printf("파일/폴더명 : %s\n", f.getName());
		System.out.printf("파일/폴더 상위 경로 : %s\n", f.getParent());
		System.out.printf("파일/폴더 전체 경로 : %s\n", f.getPath());
		
		System.out.printf("존재유무 : %s\n", f.exists()); // 이 파일이 존재하느냐
		
		File f2 = new File("D:\\temp");
		
		if(!f2.exists()) { // f2가 존재하지 않는다면
			// f2.mkdir(); 디렉토리(폴더)를 만들어줌
			try {
				f2.createNewFile();   // 파일을 만들어줌, 그러나 파일인지 폴더인지 모를수있기때문에
			} catch (IOException e) { // isFile()로 파일유무를 확인한다.
				e.printStackTrace();
			} 
		} else {
			f2.delete(); // 파일을 삭제시킬수있다.
		}
		
		File f3 = new File("D:\\parent\\child\\sample.txt");
		
		if(!f3.exists()) {
			File tmpFile = new File(f3.getParent());
			tmpFile.mkdirs(); // s를 붙이면 모든? 디렉토리(폴더)를 만들어줌
			try {
				f3.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}

}

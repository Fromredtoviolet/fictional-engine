package kr.co.demo06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class Demo {
	
	public static void charSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		StringBuilder sb = new StringBuilder();
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(f))) {
			char[] buf = new char[16];
			while(true) {
				int readCount = isr.read(buf);
				if(readCount == -1) {
					break;
				}
				sb.append(buf, 0, readCount);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print(sb.toString());
																				 // ↓ append
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f, true))) {
			osw.write("문자열을 그대로 출력에 사용\r\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bufferSubStream() {
		File f = new File("D:\\입출력테스트.txt");

		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			while(br.ready()) { // 읽을 상태면 진행한다. 귀찮게 -1 체크할 필요 없음.
				sb.append(br.readLine() + "\r\n"); // 줄 단위로 읽어들인다.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
			bw.write("버퍼 보조 스트림을 적용하여 입출력");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void dataSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
			dos.writeInt(100);
			dos.writeDouble(12.5);
			dos.writeBoolean(false);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(f))) {
			int i = dis.readInt(); // 읽고 정수로 저장하고
			double d = dis.readDouble(); // 읽고 실수로 저장하고
			boolean b = dis.readBoolean(); // 읽고 불린으로 저장한다.
			// 주의! 위에 write에서 작성한 순서와 동일하게 read를 써야한다. 지금은 int-double-boolean 순.
			
			System.out.println(i + " | " + d + " | " + b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * 보조 스트림
		 * 		- 입/출력에서 사용하는 기반 스트림을 보조하는 역할을 수행하는 스트림
		 * 		- 보조 스트림을 사용하기 위해서는 반드시 기반 스트림과 같이 사용해야 한다.
		 * 		- 보조 스트림은 기반 스트림의 성능 향상 또는 추가 기능을 제공하여 입출력을
		 * 		  보다 효율적으로 사용하기 위한 용도로 쓰인다.
		 * 
		 * 문자 보조 스트림
		 * 		- InputStreamReader / OutputStreamWriter 이 있으며, 바이트 기반 스트림에
		 * 		  적용하여 사용
		 * 		- 바이트 데이터를 문자 데이터로 변환하는 기능을 제공
		 * 
		 * 버퍼 보조 스트림
		 * 		- BufferedInputStream / BufferedOutputStream 이 있으며, 바이트 기반 스트림에
		 * 		  적용하여 사용
		 * 		- BufferedReader / BufferedWriter 이 있으며, 문자 기반 스트림에 적용하여 사용
		 * 		- 하드디스크와 메모리 사이의 입출력 속도차를 보완하기 위한 중간 완충 영역을 만들어서
		 * 		  병목현상을 최소화 하여 원활한 입출력이 이루어 질 수 있도록 제공한다.
		 * 
		 * 데이터 타입 보조 스트림
		 * 		- DataInputStream / DataOutputStream 이 있으며, 바이트 기반 스트림에 적용하여 사용
		 * 		- 프로그램에서 사용하는 기본 데이터 타입을 그대로 입출력에 사용할 수 있도록 하는 기능 제공
		 * 
		 * 객체 타입 보조 스트림
		 * 		- ObjectInputStream / ObjectOutputStream 이 있으며 바이트 기반 스트림에 적용하여 사용
		 * 		- 프로그램에서 사용하는 객체 타입을 그대로 입출력에 사용할 수 있도록 하는 기능 제공
		 */
		File f = new File("D:\\입출력테스트.txt");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			Subject s1 = new Subject("국어", 67.8);
			Subject s2 = new Subject("영어", 78.3);
			Subject s3 = new Subject("수학", 82.9);
			
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.writeObject(s3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			Subject s1 = (Subject)ois.readObject(); // 다운캐스팅. 필요한건 object 밑의 subject니까.
			Subject s2 = (Subject)ois.readObject(); 
			Subject s3 = (Subject)ois.readObject(); 
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

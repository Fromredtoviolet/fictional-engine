package kr.co.demo01.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	
	public static void main(String[] args) {
		/*
		 * 네트워크 프로그래밍
		 * 		- 네트워크로 연결된 컴퓨터 장치 간에 데이터를 송/수신 할 수 있도록 만드는 프로그래밍
		 * 		- 서버와 클라이언트로 역할을 나누어서 작성하게 된다.
		 * 		- 네트워크 연결에 필요한 정보로 IP 주소와 Port 번호가 있으며, 이 정보를 통해 연결할
		 * 		  서버와 클라이언트를 식별하게 된다.
		 * 		  비유하자면, 경기장에 간다고 치자. 이 경기장의 주소는 IP이다. 여러개의 출입구 중 내가
		 * 		  들어가야 할 n번 입구가 Port라고 할 수 있다.
		 * 		- 네트워크 연결을 통해 데이터를 송/수신할 때 2가지 전송 방식이 있으며 각각 TCP, UDP
		 * 		  라고 한다.
		 * 		- UDP의 경우 신뢰성은 낮지만 데이터 전송 속도가 빠른 특징을 가진다.
		 * 		- TCP의 경우 신뢰성은 높으며 데이터 전송 속도가 느린 특징을 가진다.
		 * 
		 */
		
		/*
		 * UDP 서버
		 * 		1. 통신을 위한 Port 지정
		 * 		2. 지정한 Port로 데이터소켓 객체 생성
		 * 		3. 데이터그램패킷 객체 생성(클라이언트가 보낸 메시지를 받을 패킷 객체를 생성)
		 * 		4. 수신 대기
		 * 		5. 데이터를 수신한 후에는 클라이언트가 요청한 정보에 맞추어 동작 후 
		 * 		   처리 결과를 전달.
		 * 		6. 처리 결과를 전달하기 위해 데이터그램패킷 객체 생성
		 * 		7. 만들어진 패킷 객체로 전송
		 * 		8. 3번 ~ 7번까지의 과정이 반복.
		 */
		
		// 사용하지 않는 포트로 작업을 해야만 동작한다.
		// 굳이 cmd 검사할 필요는 없고, 그냥 소켓 에러가 뜨면 포트 번호를 바꾸면 된다!
		// 포트는 16비트. 고로 범위는 0 ~ 65535. 그러나 0 ~ 1023은 기본 프로그램이 선점한게 대다수이므로 쓰지 말 것. 
		// 예를 들어, 123번 포트는 타임 서버가 사용하고 있기 때문에 겹치면 시간 동기화를 할 수 없게 된다.
		// 또한, 1024 ~ 25000 범위도 쓰지 않는 것이 좋다. 상용 프로그램이 선점했다.
		// 이왕이면 25001 ~ 65535 사이를 쓰자! 5만번대는 동적포트(랜덤포트)지만 테스트용으론 ㄱㅊ
		int port = 51000; 
		
		try {			// 소켓: 연결점, 패킷: 연결점으로 들어오는 데이터. UDP에는 데이터그램소켓, TCP에 그냥 소켓.
			DatagramSocket dSocket = new DatagramSocket(port);
			
			while(true) {
				byte recv[] = new byte[4096]; // 들어온 데이터를 저장해둘 배열 장만.
				DatagramPacket recvPacket = new DatagramPacket(recv, recv.length);
			
				System.out.println("데이터 수신 대기 중...");
				dSocket.receive(recvPacket); // 연결점으로 받은 데이터를 패킷에 넣어라. 리시브패킷.
				// 이제 네트워크부터는 상호작용이 필요한 작업이기때문에 이렇게 멈추는 과정이 한번씩 있어야 한다.
			
				String recvData = new String(recvPacket.getData(), 0, recvPacket.getLength()); // 받은 데이터를 문자열로 변환
				System.out.println("클라이언트가 보낸 메시지 : " + recvData);//↑ 겟렝쓰는 배열의 모든 크기만큼이 아니라 '받은 데이터만큼만' 처리하게해준다.
				
				System.out.println("클라이언트 요청 처리후 결과 전달!");
				byte byteData[] = (recvData + " 에 대한 처리가 완료 되었습니다.").getBytes();	// ↓클라이언트가 보낸 패킷이기때문에 IP주소 정보가 들어있다.
				DatagramPacket sendPacket = new DatagramPacket(byteData, byteData.length, recvPacket.getAddress(), recvPacket.getPort());
				dSocket.send(sendPacket);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

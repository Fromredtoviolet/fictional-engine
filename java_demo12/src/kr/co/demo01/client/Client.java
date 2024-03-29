package kr.co.demo01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		/*
		 * UDP 클라이언트
		 * 		1. 데이터를 전달할 서버 IP 주소와 Port 지정
		 * 		2. 데이터소켓 객체 생성
		 * 		3. 데이터패킷 객체 생성(서버에게 보낼 메시지를 위한 패킷 객체를 생성)
		 * 		4. 데이터패킷 전송
		 * 		5. 서버의 처리가 완료되어 데이터 패킷을 보낼 것을 대비해 클라이언트도
		 * 		   수신용 데이터패킷 객체를 생성(수신 대기)
		 * 		6. 서버가 보낸 메시지 확인
		 * 		7. 3번 ~ 6번까지의 과정이 반복
		 */
		Scanner sc = new Scanner(System.in);
		int serverPort = 51000;
		InetAddress serverIp;
		
		try {
			serverIp = InetAddress.getByName("127.0.0.1"); // 로컬호스트IP
			DatagramSocket dSocket = new DatagramSocket();
		
			while(true) {
				System.out.print("입력 : ");
				String msg = sc.nextLine();
				byte byteData[] = msg.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(byteData, byteData.length, serverIp, serverPort);
				dSocket.send(sendPacket);
				
				byte recv[] = new byte[4096];
				DatagramPacket recvPacket = new DatagramPacket(recv, recv.length);
				dSocket.receive(recvPacket);
				
				String recvData = new String(recvPacket.getData(), 0, recvPacket.getLength());
				System.out.println("서버가 보낸 메시지 : " + recvData);
			}
			
			
		} catch (UnknownHostException e) { //InetAddress(중략)throws UnknownHostException 라고 뜨니까 직접 캐치 입력해주기
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

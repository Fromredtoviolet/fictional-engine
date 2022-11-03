package kr.co.demo02.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		/*
		 * TCP 서버
		 * 		1. 통신을 위한 Port 지정
		 * 		2. 지정한 Port로 서버소켓 객체 생성
		 * 		3. 서버소켓으로 들어오는 연결 요청 대기 후 승낙
		 * 		4. 연결 승낙 후 클라이언트와의 연결 소켓 생성
		 * 		5. 입출력스트림 생성
		 * 		6. 입출력스트림으로 통신 진행
		 */
		// 서버와 클라이언트 간에 데이터를 주고받을때, 
		// TCP가 쓰는 소켓 객체는 확인 과정이 있다. 그래서 신뢰성이 높지만, 속도가 느리다.
		// UDP가 쓰는 데이터그램소켓 객체는 확인 과정이 없다. 그래서 신뢰성이 낮지만, 속도가 빠르다.
		// 또한 TCP는 입출력'스트림'이라는 데이터의 통로를 사용하기 때문에 더 안정적이다.
		// 서버소켓은 요청이 들어오면 승낙하기 위한 용도. 승낙하고나면 실제 클라이언트와 연결하기 위한 그냥 '소켓'이 창구가 된다.
		
		
		int port = 51000; 
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
					
			Socket sock = serverSocket.accept(); // 서버소켓에 어셉트하면 소켓 생성!
			
			BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
			
			while(true) {
				byte[] recv = new byte[4096];
				while(true) {
					int len = bis.read(recv);
					if(len == -1) {
						break;
					}
					System.out.print(new String(recv, 0, len));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

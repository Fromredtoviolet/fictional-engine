package kr.co.demo02.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage {
	
	private Scanner sc = new Scanner(System.in);
	private Socket sock;
	private BufferedOutputStream bos;
	
	public SendMessage(Socket sock) {
		this.sock = sock;
		try {
			this.bos = new BufferedOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			System.out.print(": ");
		}
	}
}

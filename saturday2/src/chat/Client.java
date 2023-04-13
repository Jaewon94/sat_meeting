package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

// 클라이언트 끼리 채팅하는 내용

class Sender implements Runnable {
	
	private Scanner sc;
	private Socket so;
	private PrintWriter pw;
	
	public Sender(Socket so, Scanner sc) {
		try {
			this.so = so;
			this.sc = sc;
			pw = new PrintWriter(so.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String msg;
		while(true) {
			System.out.print("메시지 입력 : ");
			msg = sc.nextLine();
			pw.println(msg);
			pw.flush();
			if(msg.equals("exit")) {
				break;
			}
		}
		try { so.close(); } catch (IOException e) {}
	}
}

class Reciever implements Runnable {
	private Scanner server;
	
	public Reciever(Socket so) {
		try {
			server = new Scanner(so.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String msg;
		try {
			while(true) {
				msg = server.nextLine();
				System.out.println(msg);
				if(msg == null) {
					break;
				}
			}
		} catch(NoSuchElementException e) {
			System.out.println("프로그램 종료");
		}
	} 	// end of run
}

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Socket so;
		String host;
		int port = 7777;
		
		System.out.print("접속할 서버의 IP 입력 : ");
		host = sc.nextLine();
		
		try {
			so = new Socket(host, port);
			// 메세지를 보내거나 받는 요소가 동시에 수행되어야 한다
			
			Sender sender = new Sender(so, sc);
			Reciever reciever = new Reciever(so);
			Thread th1 = new Thread(sender);
			Thread th2 = new Thread(reciever);
			
			th1.start();
			th2.run();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
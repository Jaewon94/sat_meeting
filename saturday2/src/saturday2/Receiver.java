package saturday2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Receiver implements Runnable{
	private Scanner server;
	
	public Receiver(Socket so) {
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
		} catch (Exception e) {
			System.out.println("프로그램 종료");
		}
		
	}

}

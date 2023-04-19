package saturday2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Scanner sc;
	private Socket so;

	
	
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	public void conn(String host, int port) {
		try {
			so = new Socket(host, port);
			
			Sender sender = new Sender(so, sc);
			Receiver receiver = new Receiver(so);
			
			Thread th1 = new Thread(sender);
			Thread th2 = new Thread(receiver);
			
			th1.start();
			th2.run();
		
		} catch (IOException e) {
			e.getMessage();
		}
		
	
		
	}
}

package chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Sender implements Runnable {
	
	private Scanner sc;
	private Socket so;
	private PrintWriter pw;
	
	public Sender(Socket so, Scanner sc) {
		this.so =so;
		this.sc = sc;
	}
	
	 @Override
	public void run() {

		
	}
	
	
}

public class Client {
	
}

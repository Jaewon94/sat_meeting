package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class Sesssion implements Runnable{
	
	private PrintWriter pw;
	private Scanner sc;
	private InetAddress inetAddress;
	
	public Sesssion(Socket so) {
		try {
			pw = new PrintWriter(so.getOutputStream());
			sc = new Scanner(so.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Server {

}

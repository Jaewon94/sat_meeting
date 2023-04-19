package saturday2;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable {
	private Scanner sc;
	private Socket so;
	private PrintWriter pw;
	
	public Sender(Socket so, Scanner sc) {
		try {
			this.so = so;
			this.sc = sc;
			pw = new PrintWriter(so.getOutputStream());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String msg;
		while (true) {
			System.out.print("메시지 입력 : ");
			msg  = sc.nextLine();
			pw.println(msg);
			pw.flush();
			if(msg.equals("exit")) {
				break;
			}
		}
		try {so.close();} catch (Exception e) {}
	}
}

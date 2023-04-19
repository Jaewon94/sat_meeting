package saturday2;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Session implements Runnable {
	private PrintWriter pw;
	private Scanner sc;
	private InetAddress inetAddress;
	static ArrayList<Session> list = new ArrayList<>();
	
	public Session(Socket so) {
		try {
			pw = new PrintWriter(so.getOutputStream());
			sc = new Scanner(so.getInputStream());
			inetAddress = so.getInetAddress();
			list.add(this);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Session() {
		this.pw = new PrintWriter(System.out);
		
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.getMessage();
		}
	}
	
	public PrintWriter getPrintWriter() {
		return pw;
	}
	@Override
	public void run() {
		String msg;
		while (true) {
			msg = sc.nextLine();
			for(Session session : Session.list) {
				session.getPrintWriter().println(msg);
				session.getPrintWriter().flush();
			}
			if(msg.equals("exit")) {
				break;
			}
		}
		try {pw.close();} catch (Exception e) {}
		list.remove(this);
	}
	@Override
	public String toString() {
		return inetAddress.toString() + " 세션";
	}
}

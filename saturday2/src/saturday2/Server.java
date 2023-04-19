package saturday2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;



public class Server {

	private static String getLocalServerIp() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress ia = enumIpAddr.nextElement();
					if (!ia.isLoopbackAddress() && !ia.isLinkLocalAddress() && ia.isSiteLocalAddress()) {
						return ia.getHostAddress();
					}
				}
			}
		} catch (SocketException ex) {
		}
		return null;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String localIP = getLocalServerIp();
		ServerSocket ss;
		Socket so;
		int port = 7777;
		Session session;


		try {

			ss = new ServerSocket(port); // 서버 개설
			System.out.printf("서버 아이피는 [%s] 입니다\n", localIP);

			// 서버도 채팅내용을 보고 싶다
			Session.list.add(new Session());

			while (true) {
				System.out.println("접속 대기중...");
				so = ss.accept();
				session = new Session(so);
				Thread th = new Thread(session);
				th.start();

				System.out.println("현재 접속 인원 : " + Session.list.size());

				Session.list.forEach(System.out::println);
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();

	}

}

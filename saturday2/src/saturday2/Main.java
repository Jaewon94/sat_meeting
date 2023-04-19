package saturday2;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		String host;
		final int PORT = 7777;
		Client client;
		userDAO dao = new userDAO();
		userDTO dto;
		String id,pw;
		
		Scanner sc = new Scanner(System.in);
		int menu;
		
		do {
			System.out.println("1. 채팅 입장");
			System.out.println("0. 종료");
			System.out.println("메뉴 선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("아이디 입력 : ");
				id = sc.nextLine();
				System.out.print("비밀번호 입력 : ");
				pw = sc.nextLine();
				dto = dao.selectOne(id, pw);
				if (dto != null) {
					System.out.print("입장할 IP주소 입력 : ");
					host = sc.nextLine();
					client = new Client();
					client.setSc(sc);
					client.conn(host, PORT);
				} else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
					continue;
				}
				break;


			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
				break;
			}
			
			
			
		} while (menu != 0);
		
		sc.close();
	}
}

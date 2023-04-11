package firstWeek;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Handler h = new Handler();
		ArrayList<Student> list = new ArrayList<Student>();
		
		String name;
		int  kor, eng, mat, result, menu;
		
		do {
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 리스트");
			System.out.println("3. 학생 검색");
			System.out.println("4. 학생 삭제");
			System.out.println("5. 전체 학생 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("이름 입력 >> ");
				name = sc.nextLine();
				
				System.out.print("국어 점수 >> ");
				kor = Integer.parseInt(sc.nextLine());
				if (kor <0 || kor > 100) {
					System.err.println("\n\t점수의 범위를 벗어났습니다.\n");
					continue;
				}
				System.out.print("영어 점수 >> ");
				eng = Integer.parseInt(sc.nextLine());
				if (eng <0 || eng > 100) {
					System.err.println("\n\t점수의 범위를 벗어났습니다.\n");
					continue;
				}
				System.out.print("수학 점수 >> ");
				mat = Integer.parseInt(sc.nextLine());
				if (mat <0 || mat > 100) {
					System.err.println("\n\t점수의 범위를 벗어났습니다.\n");
					continue;
				}
				
				Student st = new Student(name, kor, eng, mat);
				
				result = h.insert(st);
				
				if(result != 1) {
					System.err.println("\n\t학생 정보를 넣지 못했습니다.\n");
				} else {
					System.out.println("\n\t학생 정보를 추가 했습니다.\n");
				}
				break;
			case 2:
				list = h.selectAll();
				for(int i=0;i<list.size();i++) {
					list.get(i).setRank(i+1);
				}
				
				for(int i=0; i<list.size();i++) {
					System.out.printf("%d등",list.get(i).getRank());
					System.out.println(list.get(i));
				}
				break;
			case 3:
				System.out.print("이름 입력 >> ");
				name = sc.nextLine();
				
				System.out.println(h.selectOne(name));
				
				break;
			case 4:
				System.out.print("이름 입력 >> ");
				name = sc.nextLine();
				
				result = h.delete(name);
				
				if(result != 1) {
					System.err.printf("\n\t%s 학생 정보를 삭제하지 못했습니다.\n\n",name);
				} else {
					System.out.printf("\n\t%s학생 정보를 삭제 했습니다.\n",name);
				}
				break;
			case 5:
				h.deleteAll();
				System.out.println("\n\t전체 학생 정보를 삭제 했습니다.\n");

				break;
			case 0:
				h.save();
				System.out.println("\n\t프로그램을 종료합니다.\n");
				break;
			default:
				System.out.println("\n\t메뉴를 잘못 입력하셨습니다.\n");
				break;
			}
			
		} while (menu !=0);
		sc.close();

	}
}
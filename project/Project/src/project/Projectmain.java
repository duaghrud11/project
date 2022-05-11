package project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Projectmain {
	public static void main(String[] args) {
		int k = 0;
		Scanner be = new Scanner(System.in);

		while (true) {
			int p = 0;
			System.out.println();
			System.out.println("◆가보고 싶은 국내 여행지 설문조사 ◆");
			System.out.println("1.설문 참여하기");
			System.out.println("2.설문  현황보기");
			try {
				p = be.nextInt();
			} catch (InputMismatchException e) {
				
			be.next();
				
				}

			switch (p) {
			case 1:
				MenuDao md = new MenuDao();
				List<MenuVo> arr = md.show();
				for (MenuVo ho : arr) {
					System.out.println(ho);
				}
				System.out.println("0.기타()");
// 문자를 치거나 없는 번호 치면 오류해결방법
				try {
					k = be.nextInt();
				} catch (InputMismatchException e) {
				
					System.out.println("잘못 입력했습니다.\n 다시 입력해주세요");
				break;}
				if (k == 0) {
					System.out.println("여행 가고 싶은 곳:");

					String etc = be.next();

					MenuVo menu = new MenuVo(0, etc);
					md.insert(menu);

					break;
				}
				
				VoteVo vote = new VoteVo(0, k);

				VoteDao vd = new VoteDao();
				vd.vote(vote);
				
				break;
			case 2:
				VoteDao vdo = new VoteDao();
				List<VoteVo> brr = vdo.list();
				for (VoteVo pp : brr) {
					System.out.println(pp);
				}
				break;
			default : 
				System.out.println("잘못 입력했습니다.\n 다시 입력해주세요");
			}
		}
	}
}

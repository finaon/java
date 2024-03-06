
package jdbc_hw1.view;

import java.util.ArrayList;
import java.util.Scanner;

import jdbc_hw1.controller.PlayerController;
import jdbc_hw1.model.vo.Player;

public class PlayerMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private PlayerController pc = new PlayerController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("축구선수 등록 관리 프로그램\n");
			
			System.out.println("1. 신인 선수 추가");
			System.out.println("2. 선수 전체 조회");
			System.out.println("3. 선수 지역 변경");
			System.out.println("4. 선수 이름으로 검색");
			System.out.println("5. 프로선수 여부(이름으로 나이 조회)");
			System.out.println("0. 프로그램 종료\n");
			
			System.out.print("메뉴 번호 입력 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			
			case 1 :
				this.inputPlayer();
				break;
			case 2 :
				pc.selectList();
				break;
			case 3 :
				this.updatePlayer();
				break;
			case 4 :
				pc.selectByPlayerName(inputPlayerName());
				break;
			case 5 :
				pc.selectByPlayerAge(inputPlayerAge());
				break;
			case 0 :	
				System.out.println("프로그램을 종료합니다");
				return;
			default :
				System.out.println("잘못입력하셨습니다 다시입력해주세요");
			}
		}
		
	}	
		public void inputPlayer() {
			System.out.println("축구선수추가\n");
			System.out.print("선수 이름 : ");
			String playerName = sc.nextLine();
			
			System.out.print("선수 포지션(FW, MF, DF, GK) : ");
			String playerPosition = sc.nextLine();
			
			System.out.print("선수 주발('L','R') :");
			String footPosition = sc.nextLine();
			
			System.out.print("선수 나이 :");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("선수 키 :");
			String height = sc.nextLine();
			
			System.out.print("선수 몸무게 : ");
			String weight = sc.nextLine();
			
			System.out.print("활동지역 : ");
			String location = sc.nextLine();
			
			pc.insertPlayer(playerName, playerPosition, footPosition, age, height, weight, location);
			}
		
		public void updatePlayer() {
			System.out.println("===========선수 정보 변경========");
			
			String playerName = this.inputPlayerName(); // 출력메소드
			
			System.out.print("변경할 활동지역 : ");
			String location = sc.nextLine();
			
			pc.updatePlayer(playerName, location);
			
		}
			
		
		public String inputPlayerName() {
			System.out.print("선수 이름 :");
			String playerName = sc.nextLine();
			return playerName;
		}
		
		public int inputPlayerAge() {
			System.out.println("선수 나이 조회 : ");
			int age = sc.nextInt();
			return age;
		}
		
		
		
		//-------------------------------- 응답화면------------------------------------
		
		public void displaySuccess(String message) {
			System.out.println("\n서비스 요청 성공 : " + message);
		}
		
		public void displayFail(String message) {
			System.out.println("\n서비스 요청 실패 : " + message);
		}

		public void proPlayer(String message) {
			System.out.println("프로등록이 가능합니다 : " + message);
		}

		public void uPlayer(String message) {
			System.out.println("프로등록이 불가능합니다 : " + message);
		
		}
		public void displayNoData(String message) {
			System.out.println("\n" + message);
		}
		
		public void displayPlayerList(ArrayList<Player> list) {
			
			for(Player p : list) {
				System.out.println(p);
			}
		}
		
		public void displayPlayerAge(ArrayList<Player> agelist) {
			
			for(Player p : agelist) {
				System.out.println(p);
			}
		}
		
		public void displayPlayer(Player p) {
			System.out.println("\n조회된 데이터는 다음과 같습니다.");
			System.out.println(p);
		}

}
	


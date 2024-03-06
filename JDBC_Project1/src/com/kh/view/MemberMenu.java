package com.kh.view;

import java.util.Scanner;

import com.kh.controller.MemberController;

//View : 사용자가 보게될 시각적인 요소(화면) 출력및 입력
public class MemberMenu {

	//스캐너 객체 생성(전역으로 다 입력 받을 수 있도록 하기 위해서)
	private Scanner sc = new Scanner(System.in);
	
	//MemberController 객체생성(전역에서 바로 요청 할 수 있도록)
	private MemberController mc = new MemberController();
	
	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 * 
	 * 
	 * */
	
	public void mainMenu() {
		
		while(true) {
		System.out.println("=======회원관리 프로그램==========");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 아이디 검색");
		System.out.println("4. 회원 이름으로 키워드 검색");
		System.out.println("5. 회원 정보 변경");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 프로그램 종료");
		
		System.out.println(" 메뉴 입력 :");
		int menu = sc.nextInt();
		sc.nextLine();
		
		switch(menu) {
		case 1:
			this.inputMember();
			break;
		case 2:
			this.inputMember();
		case 3:
		case 4:
		case 5:
		case 6:
		case 0:
			System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다");
			return; //break를 쓰면 while 구문으로 다시 돌아가기 때문에 return으로 끝태야함
		default:
			System.out.println("메뉴를 잘못입력하셨습니다 다시 입력해주세요");
			}
		}
	}
	public void inputMember() {
		System.out.println("=============회원추가=============");
		//id~취미까지 입력받기
		
		System.out.println("아이디 :");
		String userId = sc.nextLine();
		
		System.out.println("비밀번호 :");
		String userPwd = sc.nextLine();
		
		System.out.println("이름 :");
		String userName = sc.nextLine();
		
		System.out.println("성별(M,F) :");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.println("나이  :");
		String age = sc.nextLine();
	
		
		System.out.println("이메일 :");
		String email = sc.nextLine();
		
		System.out.println("전화번호(-빼고) :");
		String phone = sc.nextLine();

		System.out.println("주소 :");
		String address = sc.nextLine();

		System.out.println("취미(,로 이어서 작성) :");
		String  hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}
	
	public void inputMember() {
		
	//------------------------응답화면-----------------------------------
		
	/**
	 * 서비스요청 처리 후 성공했을 경우 사용자가 보게될 응답화면
	 * @param : 객체별 성공메세지
	 * 
	 * */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	}
	
}

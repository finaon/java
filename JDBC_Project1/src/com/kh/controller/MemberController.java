package com.kh.controller;

import com.kh.model.vo.Member;

//Controller : View를 통해서 사용자가 요청한 기능에 대해서 처리하는 담당
//			   해당 메소드로 전달된 데이터[가공처리후] dao로 전달하여 호출
//  		   dao로부터 반환받는 결과 성공인지 실패인지 판단 후 응답화변 결정(view메소드 호출)
public class MemberController {
	
	/*
	 * 사용자의 추가요청을 처리해주는 메소드
	 * @param userId ~hobby : 사용자가 
	 * 
	 * 
	 * */

	public void insertMember(String userId, String userPwd, String userName,
					String gender, String age, String email, String phone, String address, String hobby) {

	//view로부터 전달받은 값을 바로 dao쪽으로 전달x
	//어딘가 (Member객체(vo)에 담아서 전달)
	
	//방법1)기본생성자로 생성 후 각 필드마다  setter를 이용해서 데이터 저장
	//방법2)매개변수 있는 생성자로 전부 전달해서 생성
					
					
	Member m = new Member(userId, userPwd, userName, gender, 
			Integer.parseInt(age), email, phone, address, hobby);

	int result =new MemberDao().insertMember(m);
	
	if(result > 0) {
		new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다")
	} else {
		new MemberMenu().displayFail("실패하였습니다")
	}
	}

}

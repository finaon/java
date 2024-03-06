package jdbc_hw1.controller;

import java.util.ArrayList;

import jdbc_hw1.model.vo.Player;
import jdbc_hw1.service.PlayerService;
import jdbc_hw1.view.PlayerMenu;

public class PlayerController {
	
	public void insertPlayer(String playerName, String playerPosition, String footPosition, String age, String height, String weight,
			String location) {
		
		Player p = new Player(playerName, playerPosition, footPosition, age, height, weight, location);
		
		int result = new PlayerService().insertPlayer(p);
		
		if (result > 0) {
			new PlayerMenu().displaySuccess("성공적으로 선수가 추가되었습니다.");
		} else { 
			new PlayerMenu().displayFail("선수추가를 실패하였습니다.");
		}
	}
	
	public void selectList() {
		ArrayList<Player> list = new PlayerService().selectList();
		
		if (list.isEmpty()) {
			new PlayerMenu().displayNoData("전체 조회 결과가 없습니다");
		} else {
			new PlayerMenu().displayPlayerList(list);
		}	
	}
	
	public void updatePlayer(String playerName, String location) {
		Player p = new Player();
		p.setPlayerName(playerName);
		p.setLocation(location);
		
		int result = new PlayerService().updatePlayer(p);
		
		if (result > 0) {
			new PlayerMenu().displaySuccess("성공적으로 회원 정보 변경되었습니다.");
		} else {
			new PlayerMenu().displayFail("회원정보 변경에 실패하였습니다.");
		}	
	}
	
	public void selectByPlayerName(String playerName) {
		Player p = new PlayerService().selectByPlayerName(playerName);
		System.out.println(p);
		if (p == null) {
			new PlayerMenu().displayNoData(playerName + "에 해당하는 조회결과가 없습니다.");
		} else {
			new PlayerMenu().displayPlayer(p);
		}
	}
	
//	public void selectByPlayerAge(String playerAge) {
//		Player p = new PlayerService().selectByPlayerAge(playerAge);
//		System.out.println(p);
//		if(p >= 17) {
//			new PlayerMenu().proPlayer(playerAge + "세는 프로 등록이 가능합니다");
//		} else {
//			new PlayerMenu().uPlayer(playerAge + "세는 프로 등록이 불가능합니다");
//		}
//		
//		
//		
//	}

}	
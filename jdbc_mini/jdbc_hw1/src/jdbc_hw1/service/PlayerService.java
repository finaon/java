package jdbc_hw1.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc_hw1.common.JDBCTemplate;
import jdbc_hw1.model.dao.PlayerDao;
import jdbc_hw1.model.vo.Player;

public class PlayerService {
	
	public int insertPlayer(Player p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new PlayerDao().insertPlayer(conn, p);

		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	public ArrayList<Player> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Player> list = new PlayerDao().selectList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int updatePlayer(Player p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new PlayerDao().updatePlayer(conn ,p);
		
		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;	
	}
	
	public Player selectByPlayerName(String playerName) {
		Connection conn = JDBCTemplate.getConnection();
		Player p = new PlayerDao().selectByPlayerName(conn, playerName);
		JDBCTemplate.close(conn);
		
		return p;
	}
	
	public ArrayList<Player> selectByPlayerAge(int age) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Player> list = new PlayerDao().selectByPlayerAge(conn, age);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}	

package jdbc_hw1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc_hw1.common.JDBCTemplate;
import jdbc_hw1.model.vo.Player;

public class PlayerDao {
	
	public int insertPlayer(Connection conn, Player p) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PLAYER VALUES(SEQ_PLAYERNO.NEXTVAL, ?,?,?,?,?,?,?, SYSDATE)";
	
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getPlayerName());
			pstmt.setString(2, p.getPlayerPosition());
			pstmt.setString(3, p.getFootPosition());
			pstmt.setInt(4, p.getAge());
			pstmt.setInt(5, Integer.parseInt(p.getHeight()));
			pstmt.setInt(6, Integer.parseInt(p.getWeight()));
			pstmt.setString(7, p.getLocation());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	
	}
	
	public ArrayList<Player> selectList(Connection conn) {
		
	ArrayList<Player> list = new ArrayList<>();
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM PLAYER ORDER BY PLAYERNAME";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				Player p = new Player();
				p.setPlayerNO(rset.getInt("playerno"));
				p.setPlayerName(rset.getString("playername"));
				p.setPlayerPosition(rset.getString("playerposition"));
				p.setFootPosition(rset.getString("footposition"));
				p.setAge(rset.getInt("age"));
				p.setHeight(rset.getString("height"));
				p.setWeight(rset.getString("weight"));
				p.setLocation(rset.getString("location"));
				p.setDebutDate(rset.getDate("debutdate"));
				
				list.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	
	}
	
	public int updatePlayer(Connection conn, Player p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql =  "UPDATE PLAYER "
				+ "SET LOCATION = ? "
			 + "WHERE PLAYERNAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, p.getHeight());
//			pstmt.setString(2, p.getWeight());
			pstmt.setString(1, p.getLocation());
			pstmt.setString(2, p.getPlayerName());
			
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
			
		return result;
	}

	public Player selectByPlayerName(Connection conn, String playerName) {
		
		Player p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM PLAYER ORDER BY PLAYERNAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, playerName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Player();
				p.setPlayerNO(rset.getInt("playerno"));
				p.setPlayerName(rset.getString("playername"));
				p.setPlayerPosition(rset.getString("playerposition"));
				p.setFootPosition(rset.getString("footposition"));
				p.setAge(rset.getInt("age"));
				p.setHeight(rset.getString("height"));
				p.setWeight(rset.getString("weight"));
				p.setLocation(rset.getString("location"));
				p.setDebutDate(rset.getDate("debutdate"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}
	
	public ArrayList<Player> selectByPlayerAge(Connection conn, int age) {
		
		ArrayList<Player> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM PLAYER WHERE AGE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, age);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Player p  = new Player();
				p.setPlayerNO(rset.getInt("playerno"));
				p.setPlayerName(rset.getString("playername"));
				p.setPlayerPosition(rset.getString("playerposition"));
				p.setFootPosition(rset.getString("footposition"));
				p.setAge(rset.getInt("age"));
				p.setHeight(rset.getString("height"));
				p.setWeight(rset.getString("weight"));
				p.setLocation(rset.getString("location"));
				p.setDebutDate(rset.getDate("debutdate"));
				
				list.add(p);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
}

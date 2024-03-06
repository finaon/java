package jdbc_hw1.model.vo;

import java.sql.Date;

public class Player {

	private int playerNO;
	private String playerName;
	private String playerPosition;
	private String footPosition;
	private int age;
	private String height;
	private String weight;
	private String location;
	private Date debutDate;
	
	public Player() {
		super();
	}

	
	
	

	public Player(int playerNO, String playerName, String playerPosition, String footPosition, int age, String height,
			String weight, String location, Date debutDate) {
		super();
		this.playerNO = playerNO;
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.footPosition = footPosition;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.location = location;
		this.debutDate = debutDate;
	}
	
	public Player(String playerName, String playerPosition, String footPosition, int age, String height, String weight,
			String location) {
		super();
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.footPosition = footPosition;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.location = location;
	}

	

	public int getPlayerNO() {
		return playerNO;
	}





	public void setPlayerNO(int playerNO) {
		this.playerNO = playerNO;
	}





	public String getPlayerName() {
		return playerName;
	}





	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}





	public String getPlayerPosition() {
		return playerPosition;
	}





	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}





	public String getFootPosition() {
		return footPosition;
	}





	public void setFootPosition(String footPosition) {
		this.footPosition = footPosition;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public String getHeight() {
		return height;
	}





	public void setHeight(String height) {
		this.height = height;
	}





	public String getWeight() {
		return weight;
	}





	public void setWeight(String weight) {
		this.weight = weight;
	}





	public String getLocation() {
		return location;
	}





	public void setLocation(String location) {
		this.location = location;
	}





	public Date getDebutDate() {
		return debutDate;
	}





	public void setDebutDate(Date debutDate) {
		this.debutDate = debutDate;
	}



	@Override
	public String toString() {
		return  "[ " + playerName + ", " + playerPosition
				+ ", " + footPosition + ", " + age + ", " + height + ", " + weight
				+ ", " + location + ", " + debutDate + "]";
	}


	



	

	
	
	
}


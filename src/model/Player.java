package model;
public class Player{
	private String id;
	private String name;
	private int score;
	private int lives;
	private int level;
	
	public Player(String id, String name, int score, int lives, int level) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.lives = lives;
		this.level = level;
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score){
		this.score = score; 
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives){
		this.lives = lives; 
	}
	public int getLevel() {
		return level; 
	}
	public void setLevel(int level){
		this.level = level;
	}
}
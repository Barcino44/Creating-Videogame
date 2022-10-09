package model;

public class Enemy {

	private String id;
	private String type;
	private int scoreWin;
	private int scoreLose;
	private int quantyOfEnemy;
	private int positionX;
	private int positionY;
	
	public Enemy(String id, String type, int scoreWin, int scoreLose, int quantyOfEnemy, int positionX, int positionY) {
		this.id = id;
		this.type = type;
		this.scoreWin = scoreWin;
		this.scoreLose = scoreLose;
		this.quantyOfEnemy=quantyOfEnemy;
		this.positionX=positionX;
		this.positionY=positionY;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getScoreWin() {
		return scoreWin;
	}
	public void setScoreWin(int scoreWin){
		this.scoreWin = scoreWin; 
	}
	public int getScoreLose() { 
		return scoreLose;
	}
	public void setScoreLose(int scoreLose){
		this.scoreLose = scoreLose; 
	}
	public int getQuantyOfEnemy() {
		return quantyOfEnemy;
	}
	public void setQuantyOfEnemy(int quantyOfEnemy){
		this.quantyOfEnemy = quantyOfEnemy; 
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX){
		this.positionX = positionX; 
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY){
		this.positionY = positionY; 
	}
}
package model;
public class Treasure {

	private String name;
	private String url;
	private int score;
	private int quantyOfTreasure;
	private int positionX;
	private int positionY;
	
	public Treasure(String name, String url, int score, int quantyOfTreasure, int positionX, int positionY) {
		this.name = name;
		this.url = url;
		this.score = score;
		this.positionX = positionX;
		this.positionY=positionY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score){
		this.score = score; 
	}
	public int getQuantyOfTreasure() {
		return quantyOfTreasure;
	}
	public void setQuatyOfTreasure(int quantyOfTreasure){
		this.quantyOfTreasure = quantyOfTreasure; 
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
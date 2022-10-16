package model;
public class Treasure {

	private int selectionType;
	private String url;
	private int score;
	private int quantyOfTreasure;
	private int positionX;
	private int positionY;
	private TypeTreasure typeTreasure;
	
	public Treasure(int selectionType, String url, int score, int quantyOfTreasure, int positionX, int positionY) {
		this.selectionType=selectionType;
		this.url = url;
		this.score = score;
		this.quantyOfTreasure=quantyOfTreasure;
		this.positionX = positionX;
		this.positionY=positionY;
		setTypeTreasure();

	}
	public int getSelectionType() {
		return selectionType;
	}
	public void setTypeTreasure() {
		if(selectionType==1){
		typeTreasure=TypeTreasure.DIAMOND;
		}	
		else if (selectionType==2){
		typeTreasure=TypeTreasure.ESMERALD;		
		}
		else if (selectionType==3){
		typeTreasure=TypeTreasure.RUBY;
		}
		else if(selectionType==4){
		typeTreasure=TypeTreasure.GOLD;
		}
	}
	public TypeTreasure getTypeTreasure(){
		return typeTreasure;
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
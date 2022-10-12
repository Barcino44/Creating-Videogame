package model;

public class Enemy {

	private String id;
	private int selectionType;
	private int scoreWin;
	private int scoreLose;
	private int positionX;
	private int positionY;
	private TypeEnemy typeEnemy;
	
	public Enemy(String id, int selectionType, int scoreWin, int scoreLose, int positionX, int positionY) {
		this.id = id;
		this.selectionType = selectionType;
		this.scoreWin = scoreWin;
		this.scoreLose = scoreLose;
		this.positionX=positionX;
		this.positionY=positionY;
		setTypeEnemy();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int selectionType() {
		return selectionType;
	}
	public void setTypeEnemy(){
		if(selectionType==1){
		typeEnemy=TypeEnemy.OGRE;
		}	
		else if (selectionType==2){
		typeEnemy=TypeEnemy.ABSTRACT;		
		}
		else if (selectionType==3){
		typeEnemy=TypeEnemy.BOSS;
		}
		else if(selectionType==4){
		typeEnemy=TypeEnemy.MAGICIAN;
		}
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

package model;
public class Level {

	public static final int ENEMY_SIZE = 20; 
	public static final int TREASURE_SIZE = 20; 

	private Enemy[] enemies; 
	private Treasure[] treasures;
	private int number;
	private int requiredScoreToPassLevel;
	
	public Level(int number, int requiredScoreToPassLevel) {
		enemies = new Enemy[ENEMY_SIZE];
		enemies[1]=new Enemy("Oriux",1,200,300,45,200);
		enemies[2]=new Enemy("Hayassu",2,300,456,54,45);
		enemies[3]=new Enemy("Skarlet",3,450,654,56,84);
		enemies[4]=new Enemy("Chaser",4,500,640,84,68);
		treasures = new Treasure[TREASURE_SIZE];
		treasures[1]=new Treasure("Diamond","www.Diamond.com", 500,1,502,280);
		treasures[2]=new Treasure("Gold","www.Gold.Com",300,1,680,200);
		treasures[3]=new Treasure("Plate", "www.Plate.com", 60,1,250,45);
		this.number= number;
		this.requiredScoreToPassLevel=requiredScoreToPassLevel;
	}
	public int getNumber(){
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getRequiredScoreToPassLevel() {
		return requiredScoreToPassLevel;
	}
	public void setRequiredScoreToPassLevel(int requiredScoreToPassLevel) {
		this.requiredScoreToPassLevel = requiredScoreToPassLevel;
	}
	public String addTreasureWithObject(Treasure treasure){
		String msj="No se ha podido anadir el tesoro";
		boolean isEmpty=false;
		for(int i = 1; i <TREASURE_SIZE && !isEmpty; i++){
			if(treasures[i] == null){
				treasures[i] = treasure; 
				isEmpty = true; 
				msj = "Nuevo(s) tesoro(s) anadido(s) al nivel "; 
			}
		}
		return msj;
	}
	public String addEnemyWithObject(Enemy enemy){
		String msj="No se ha podido anadir el enemigo";
		boolean isEmpty=false;
		for(int i = 1; i <ENEMY_SIZE && !isEmpty; i++){
			if(enemies[i] == null){
				enemies[i] = enemy; 
				isEmpty = true; 
				msj = "Nuevo enemigo anadido al nivel "; 
			}
		}
		return msj;
	}
	public boolean validateIfEnemyAlreadyExist(String idEnemy){
		boolean enemyExist=false;
		for (int i=1;i<ENEMY_SIZE&&!enemyExist;i++) {
			if(enemies[i]!=null){
				if(enemies[i].getId().equals(idEnemy)){
					enemyExist=true;
				}
			}
		}
	return enemyExist;
	}
	public boolean validateIfTreasureExist(String treasureName){
		boolean treasureExist=false;
		for (int i=1;i<TREASURE_SIZE&&!treasureExist;i++) {
			if(treasures[i]!=null){
				if(treasures[i].getName().equals(treasureName)){
					treasureExist=true;
				}
			}
		}
	return treasureExist;
	}
	public String showLevelInfo(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]!=null&&treasures[i]!=null){
					msj= msj+"\n"+ "Un enemigo " + enemies[i].getTypeEnemy()+" , "+ treasures[i].getQuantyOfTreasure()+ " tesoro(s) " + treasures[i].getName();
				}
			}
		}
	return msj;
	}
	public String showOnlyEnemy(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]!=null&&treasures[i]==null){
					msj= msj+"\n"+ "Un enemigo " + enemies[i].getTypeEnemy();
				}
			}
		}
		return msj;
	}
	public String showOnlyTreasures(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]==null&&treasures[i]!=null){
					msj= msj+"\n"+ "Un tesoro " + treasures[i].getName();
				}
			}
		}
		return msj;
	}
	public int countTreasureByName(String treasureName){
		int count=0;
		for(int i=1;i<TREASURE_SIZE;i++){
			if(treasures[i]!=null){
				if(treasures[i].getName().equals(treasureName)){
					count=count+treasures[i].getQuantyOfTreasure();
				}
			}
		}
		return count;
	}
	public int countEnemyByType(int selectionType){
		int count=0;
		for(int i=1;i<ENEMY_SIZE;i++){
			if(enemies[i]!=null){
				if(enemies[i].getSelectionType()==selectionType){
					count++;
				}
			}
		}
	return count;
	}
	//public int mostRepeatenTreasure(){
		//	int maxTreasures=0;
		//for (int i=1; i<TREASURE_SIZE; i++){
		//	if(treasures[i]!=null){
		//		if(treasures[i].getQuantyOfTreasure()>maxTreasures){
		//			if(treasures[i].getName())
		//		maxTreasures=treasures[i].getQuantyOfTreasure();
		//		}
		//	}
		//}
	//return maxTreasures;
	//}
	public int showScoreMostValuableEnemy(){
		int scoreMostValuableEnemy=0;
		for(int i=1;i<ENEMY_SIZE;i++){
			if(enemies[i]!=null){
				if(enemies[i].getScoreLose()>scoreMostValuableEnemy){
					scoreMostValuableEnemy=enemies[i].getScoreLose();
				}
			}
		}
		return scoreMostValuableEnemy;
	}
	public TypeEnemy showTypeMostValuableEnemy(){
		TypeEnemy enemyType=null;
		int scoreMostValuableEnemy=0;
		for(int i=1;i<ENEMY_SIZE;i++){
			if(enemies[i]!=null){
				if(enemies[i].getScoreLose()>scoreMostValuableEnemy){
					scoreMostValuableEnemy=enemies[i].getScoreLose();
					enemyType=enemies[i].getTypeEnemy();
				}
			}
		}
		return enemyType;
	}
}	
package model;
public class Level {

	public static final int ENEMY_SIZE = 10; 
	public static final int TREASURE_SIZE = 10; 

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
		treasures[1]=new Treasure(1,"www.Diamond.com", 500,1,502,280);
		treasures[2]=new Treasure(2,"www.Esmerald.Com",300,1,680,200);
		treasures[3]=new Treasure(3,"www.Rubi.com", 60,1,250,45);
		treasures[4]=new Treasure(4,"www.Gold.com",20,1,413,84);
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
/**
*addTreasureToLevel: It adds a enemy in a level.
*@param treasure: Treasure - It represents the treasure(object) that is going to be added.
*@return msj: String - It is a message to confirm that the treasure has been added.
**/
	public String addTreasureWithObject(Treasure treasure){
		String msj="Failed to add the treasure";
		boolean isEmpty=false;
		for(int i = 1; i <TREASURE_SIZE && !isEmpty; i++){
			if(treasures[i] == null){
				treasures[i] = treasure; 
				isEmpty = true; 
				msj = "New treasure(s) added to the level "; 
			}
		}
		return msj;
	}
/**
*addTreasureToLevel: It adds a enemy in a level.
*@param enemy: Enemy - It represents the enemy(object) that is going to be added.
*@return msj: String - It is a message to confirm that the enemy has been added.
**/
	public String addEnemyWithObject(Enemy enemy){
		String msj="Failed to add the enemy";
		boolean isEmpty=false;
		for(int i = 1; i <ENEMY_SIZE && !isEmpty; i++){
			if(enemies[i] == null){
				enemies[i] = enemy; 
				isEmpty = true; 
				msj = "New enemy added to the level "; 
			}
		}
		return msj;
	}
/**
*validateIfEnemyAlreadyExist: It validates (with the id) if an enemy exist in the level. 
*@param idEnemy: It is the id of the enemy.
*@return enemyExist: boolean - It returns true if the enemy already exist in the level, else, returns false.
**/
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
/**
*showLevelInfo: It shows the information (treasures and enemies of a level).
*@return msj: String - It returns the information of a level.
**/
	public String showLevelInfo(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]!=null&&treasures[i]!=null){
					msj= msj+"\n"+ "An enemy " + enemies[i].getTypeEnemy()+" , "+ treasures[i].getQuantyOfTreasure()+ " treasure(s) " + treasures[i].getTypeTreasure();
				}
			}
		}
	return msj;
	}
/**
*showOnlyEnemy: It shows the just an enemy in case that the position[i] of treasures is Empty (it complements the method showLevelInfo).
*@return msj: String - It returns the enemy remaining.
**/
	public String showOnlyEnemy(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]!=null&&treasures[i]==null){
					msj= msj+"\n"+ "An enemy " + enemies[i].getTypeEnemy();
				}
			}
		}
		return msj;
	}
/**
*showOnlyTreasure: It shows the just a treasure in case that the position[i] of enemies is Empty (it complements the method showLevelInfo).
*@return msj: String - It returns the treasure remaining.
**/
	public String showOnlyTreasures(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]==null&&treasures[i]!=null){
					msj= msj+"\n"+ treasures[i].getQuantyOfTreasure()+" treasure(s) "+ treasures[i].getTypeTreasure();
				}
			}
		}
		return msj;
	}
/**
*countTreasureByType: It counts the quanty of a treasure in the level.
*@param selectionTypeTreasure: int - It represents the treasure that the user has selected.
*@return count: int - It represents the quanty of the selected treasure. 
**/
	public int countTreasureByType(int selectionTypeTreasure){
		int count=0;
		for(int i=1;i<TREASURE_SIZE;i++){
			if(treasures[i]!=null){
				if(treasures[i].getSelectionType()==selectionTypeTreasure){
					count=count+treasures[i].getQuantyOfTreasure();
				}
			}
		}
		return count;
	}
/**
*countTreasureByType: It counts the quanty of an enemy in the level.
*@param selectionTypeTreasure: int - It represents the enemy that the user has selected.
*@return count: int - It represents the quanty of the selected enemy. 
**/
	public int countEnemyByType(int selectionTypeEnemy){
		int count=0;
		for(int i=1;i<ENEMY_SIZE;i++){
			if(enemies[i]!=null){
				if(enemies[i].getSelectionType()==selectionTypeEnemy){
					count++;
				}
			}
		}
	return count;
	}
/**
*countDiamondsInLevel: It counts the quanty of DIAMONDS present in a level.
*@return countDiamonds: int - It is the quanty of DIAMONDS found in a level.
**/
	public int countDiamondsInLevel(){
	int countDiamonds=0;
		for (int i=1; i<TREASURE_SIZE; i++){
			if(treasures[i]!=null){
				if(treasures[i].getSelectionType()==1){
					countDiamonds=countDiamonds+treasures[i].getQuantyOfTreasure();
				}
			}
		}
		return countDiamonds;
	}
/**
*countEsmeraldsInLevel: It counts the quanty of the ESMERALDS present in a level.
*@return countEsmeralds: int - It is the quanty of ESMERALDS found in a level.
**/
	public int countEsmeraldsInLevel(){
	int countEsmeralds=0;
		for (int i=1; i<TREASURE_SIZE; i++){
			if(treasures[i]!=null){
				if(treasures[i].getSelectionType()==2){
					countEsmeralds=countEsmeralds+treasures[i].getQuantyOfTreasure();
				}
			}
		}
		return countEsmeralds;
	}
/**
*countRubiesInLevel: It counts the quanty of the RUBIES present in a level.
*@return countRubies: int - It is the quanty of RUBIES found in a level.
**/
	public int countRubiesInLevel(){
	int countRubies=0;
		for (int i=1; i<TREASURE_SIZE; i++){
			if(treasures[i]!=null){
				if(treasures[i].getSelectionType()==3){
					countRubies=countRubies+treasures[i].getQuantyOfTreasure();
				}
			}
		}
		return countRubies;
	}
/**
*countGoldsInLevel: It counts the quanty of the GOLDS present in a level.
*@return countGolds: int - It is the quanty of GOLDS found in a level.
**/
	public int countGoldsInLevel(){
	int countGolds=0;
		for (int i=1; i<TREASURE_SIZE; i++){
			if(treasures[i]!=null){
				if(treasures[i].getSelectionType()==4){
					countGolds=countGolds+treasures[i].getQuantyOfTreasure();
				}
			}
		}
		return countGolds;
	}
/**
*showScoreMostValuableEnemy: It searches the most valuable enemy in the level.
*@return scoreMostValuableEnemy: int - It is the score of the mosit valuable enemy in the level, in case that exist two or else with the same score, return -1.
**/
	public int showScoreMostValuableEnemy(){
		int scoreMostValuableEnemy=0;
		for(int i=1;i<ENEMY_SIZE;i++){
			if(enemies[i]!=null){
				if(enemies[i].getScoreLose()>scoreMostValuableEnemy){
					scoreMostValuableEnemy=enemies[i].getScoreLose();
				}
				else if(enemies[i].getScoreLose()==scoreMostValuableEnemy){
					scoreMostValuableEnemy=-1;
				}
			}
		}
		return scoreMostValuableEnemy;
	}
/**
*showScoreMostValuableEnemy: It searches the most valuable enemy in the level.
*@return scoreMostValuableEnemy: TypeEnemy - It is the score of the most valuable enemy in the level, in case that exist two or else with the same score, return -1.
**/
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
/**
*convertTypeEnemytoString: It converts a type enemy a String, in order to count its consonants.
*@param selectionType: int - It represents the enemy that the user has selected.
*@return str: String - It is the type of enemy converted in String.
**/
	public String convertTypeEnemytoString(int selectionType){
		int count=0;
		TypeEnemy enemyType=null;
		String str="";
		for (int i=1;i<ENEMY_SIZE ;i++ ) {
			if(enemies[i]!=null){
				if(enemies[i].getSelectionType()==selectionType){
					enemyType=enemies[i].getTypeEnemy();
					str=String.valueOf(enemyType);
				}
			}
		}
	return str;
	}
/**
*countConsonantsEnemy: It counts the consonants that are present in the type of enemy selected.
*@param selectionType: int - It represents the enemy that the user has been selected.
*@return consonantsCount: int - It is the quanty of consonants present in a type of enemy.
**/
	public int countConsonantsEnemy(int selectionType){
		String typeEnemy=convertTypeEnemytoString(selectionType);
		int consonantsCount=0;
		typeEnemy=typeEnemy.toLowerCase();
		for(int i=0; i<typeEnemy.length(); i++){
			char ch=typeEnemy.charAt(i);
			if(ch=='q'||ch=='w'||ch=='r'||ch=='t'||ch=='y'||ch=='p'||ch=='s'||ch=='d'||ch=='f'||ch=='g'||ch=='h'||ch=='j'||ch=='k'||ch=='l'||ch=='z'||ch=='x'||ch=='c'||ch=='v'||ch=='b'||ch=='n'||ch=='m'){
				consonantsCount++;
			}
		}
	return consonantsCount;
	}
}

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
	public String showLevelInfo(){
		String msj="";
		for(int i=1;i<TREASURE_SIZE;i++){
			for (i=1;i<ENEMY_SIZE;i++) {
				if(enemies[i]!=null&&treasures[i]!=null){
					msj= msj+"\n"+ "Un enemigo " + enemies[i].getTypeEnemy()+" , "+ treasures[i].getQuantyOfTreasure()+ " tesoro(s) " + treasures[i].getTypeTreasure();
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
					msj= msj+"\n"+ treasures[i].getQuantyOfTreasure()+" tesoro(s) "+ treasures[i].getTypeTreasure();
				}
			}
		}
		return msj;
	}
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
	public int countConsonantsEnemy(int selectionType){
		String typeEnemy=convertTypeEnemytoString(selectionType);
		int consonantsCount=0;
		typeEnemy=typeEnemy.toLowerCase();
		for(int i=0; i<typeEnemy.length(); i++){
			char ch=typeEnemy.charAt(i);
			if(ch=='q'||ch=='w'||ch=='r'||ch=='t'||ch=='y'||ch=='p'||ch=='s'||ch=='d'||ch=='f'||ch=='g'||ch=='h'||ch=='j'||ch=='k'||ch=='l'||ch=='ñ'||ch=='z'||ch=='x'||ch=='c'||ch=='v'||ch=='b'||ch=='n'||ch=='m'){
				consonantsCount++;
			}
		}
	return consonantsCount;
	}
}

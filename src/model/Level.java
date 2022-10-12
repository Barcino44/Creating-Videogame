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
		enemies[1]=new Enemy("21345",1,200,300,45,200);
		treasures = new Treasure[TREASURE_SIZE];
		treasures[1]=new Treasure("Diamond","www.Diamond.com", 500,200,502,280);
		treasures[2]=new Treasure("Gold","www.Gold.Com,",300,500,680,200);
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
	public boolean validateIfEnemyAlreadyExist(int selectionTypeEnemy){
		boolean enemyExist=false;
		for (int i=1;i<ENEMY_SIZE&&!enemyExist;i++) {
			if(enemies[i]!=null){
				if(selectionTypeEnemy==enemies[i].getselectionType()){
					enemyExist=true;
				}
			}
		}
	return enemyExist;
	}
	public String showLevelInfo(){
		String msj="";
		for (int i=1;i<ENEMY_SIZE;i++) {
			for(i=1;i<TREASURE_SIZE;i++){
				if(enemies[i]!=null&&treasures[i]!=null){
					msj= msj+"\n"+ "Un enemigo " + enemies[i].getTypeEnemy()+","+" Un tesoro " + treasures[i].getName();
				}
			}
		}
	return msj;
	}
	public String showOnlyEnemy(){
		String msj="";
		for (int i=1;i<ENEMY_SIZE;i++) {
			for(i=1;i<TREASURE_SIZE;i++){
				if(enemies[i]!=null&&treasures[i]==null){
					msj= msj+"\n"+ "Un enemigo " + enemies[i].getTypeEnemy();
				}
			}
		}
		return msj;
	}
	public String showOnlyTreasures(){
		String msj="";
		for (int i=1;i<ENEMY_SIZE;i++) {
			for(i=1;i<TREASURE_SIZE;i++){
				if(enemies[i]==null&&treasures[i]!=null){
					msj= msj+"\n"+ "Un tesoro " + treasures[i].getName();
				}
			}
		}
		return msj;
	}
}	
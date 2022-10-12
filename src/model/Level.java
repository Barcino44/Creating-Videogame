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
		for(int i = 0; i <TREASURE_SIZE && !isEmpty; i++){
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
				if(selectionTypeEnemy==enemies[i].selectionType());
					enemyExist=true;
				}
		}
	return enemyExist;
	}
	public showLevelInfo(){
	int i=0;
		for (i=1;i<ENEMY_SIZE;i++) {
			for(i=1;i<TREASURE_SIZE;i++)
				if(enemies[i]!=null&&treasures[i]!=null){
					msj="Un enemigo "

			}
		}
	}
}
package model;
public class Level {

	public static final int ENEMY_SIZE = 20; 
	public static final int TREASURE_SIZE = 20; 

	//private Enemy[] enemies; 
	private Treasure[] treasures;
	private int number;
	private int requiredScoreToPassLevel;
	
	public Level(int number, int requiredScoreToPassLevel) {
		//enemies = new Enemy[PLAYERS_SIZE]; 
		treasures = new Treasure[TREASURE_SIZE];
		this.number= number;
		this.requiredScoreToPassLevel=requiredScoreToPassLevel;
	}
	public int getNumber(){
		return number;
	}
	public String addTreasureWithObject(Treasure treasure){
		String msj="No se ha podido anadir el tesoro";
		boolean isEmpty=false;
		for(int i = 0; i <TREASURE_SIZE && !isEmpty; i++){
			if(treasures[i] == null){
				treasures[i] = treasure; 
				isEmpty = true; 
				msj = "Nuevo tesoro anadido al nivel "; 
			}
		}
		return msj;
	}
}
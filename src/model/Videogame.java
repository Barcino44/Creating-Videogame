package model;
public class Videogame {

	public static final int PLAYERS_SIZE = 20; 
	public static final int LEVELS_SIZE = 20; 

	private Player[] players; 
	private Level[] levels;
	
	public Videogame(String nit) {
		players = new Player[PLAYERS_SIZE]; 
		levels = new Level[LEVELS_SIZE];
	}
	public String addPlayer(String idPlayer, String namePlayer){
		String msj="No se ha podido anadir el jugador";
		int score=10;
		int lives=5;
		Player newPlayer = new Player(idPlayer, namePlayer, score, lives);
		int emptyPos = searchEmptyposPlayer();
			if (emptyPos != -1){
				players[emptyPos]=newPlayer;
				msj="Nuevo jugador anadido";
			}
		return msj;
	}
	public int searchEmptyposPlayer(){
		int pos= -1;
		boolean isEmpty=false;
		for(int i = 0; i < 	PLAYERS_SIZE && !isEmpty; i++){
			if(players[i] == null){
				pos=i;
				isEmpty = true; 
			}
		}
		return pos; 
	}
	public String addLevel(int numberLevel, int requiredScore){
		String msj="No se ha podido anadir el nivel";
		Level newLevel= new Level(numberLevel, requiredScore);
		int levelAlreadyExist=validateIfLevelExist(numberLevel);
			if(levelAlreadyExist==-1&&numberLevel<20&&numberLevel>0){
				levels[numberLevel]=newLevel;
				msj="Nuevo nivel anadido";
			}
		return msj;
	}
	public int validateIfLevelExist(int numberLevel){
		int pos=-1;
		boolean levelExist=false;
		for(int i=0; i<LEVELS_SIZE&&!levelExist; i++){
			if(levels[i]!=null){
				if(levels[i].getNumber()==numberLevel){
					pos=i;
					levelExist=true;
				}
			}
		}
		return pos;
	}
	public String addTreasureToLevel(int numberLevel, String name, String url, int score, int positionX, int positionY){
		String msj="No se ha podido anadir el tesoro";
		Treasure newTreasure = new Treasure(name, url, score, positionX, positionY);
		int numberOfLevel=validateIfLevelExist(numberLevel);
		if(numberOfLevel!=-1){
			msj=levels[numberOfLevel].addTreasureWithObject(newTreasure)+levels[numberOfLevel].getNumber();
	
		}
		return msj;
	}
}
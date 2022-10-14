package model;
import java.lang.Math;
public class Videogame {

	public static final int PLAYERS_SIZE = 21; 
	public static final int LEVELS_SIZE = 21; 

	private Player[] players; 
	private Level[] levels;

	public Videogame(String nit) {
		players = new Player[PLAYERS_SIZE];
		players[1]=new Player("461556","ElSuperMegaPro",10,5,1);
		players[2]=new Player("676568","EsoEsUnaFalacia",10,5,1);
		players[3]=new Player("648636","ExtremePlayer",10,5,1);
		levels = new Level[LEVELS_SIZE];
		levels[1]=new Level(1,10);
		levels[2]=new Level(2,20);
		levels[3]=new Level(3,30);
		levels[4]=new Level(4,50);
		levels[5]=new Level(5,70);
		levels[6]=new Level(6,90);
		levels[7]=new Level(7,120);
		levels[8]=new Level(8,150);
		levels[9]=new Level(9,180);
		levels[10]=new Level(10,220);
	}
	public String addPlayer(String idPlayer, String namePlayer){
		String msj="No se ha podido anadir el jugador";
		int score=10;
		int lives=5;
		int level=1;
		Player newPlayer = new Player(idPlayer, namePlayer, score, lives, level);
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
		for(int i = 1; i < 	PLAYERS_SIZE && !isEmpty; i++){
			if(players[i] == null){
				pos=i;
				isEmpty = true; 
			}
		}
		return pos; 
	}
	public boolean levelImposibleToAdd(int numberLevel){
		boolean imposibleToadd=false;
		int levelAlreadyExist=validateIfLevelExist(numberLevel);
			if(numberLevel>21||numberLevel<0){
				 imposibleToadd=true;
		}
		return imposibleToadd;
	}
	public String addLevel(int numberLevel, int requiredScore){
		String msj="";
		Level newLevel= new Level(numberLevel, requiredScore);
		int levelAlreadyExist=validateIfLevelExist(numberLevel);
		levels[numberLevel]=newLevel;
		msj="Nuevo nivel anadido";
		return msj;
	}
	public int validateIfLevelExist(int numberLevel){
		int pos=-1;
		boolean levelExist=false;
		for(int i=1; i<LEVELS_SIZE&&!levelExist; i++){
			if(levels[i]!=null){
				if(levels[i].getNumber()==numberLevel){
					pos=i;
					levelExist=true;
				}
			}
		}
		return pos;
	}
	public int validateIfPlayerExist(String namePlayer){
		int pos=-1;
		boolean playerExist=false;
		for(int i=1; i<PLAYERS_SIZE&&!playerExist; i++){
			if(players[i]!=null){
				if(players[i].getName().equals(namePlayer)){
					pos=i;
					playerExist=true;
				}
			}
		}
		return pos;
	}
	public String addTreasureToLevel(int numberLevel, String name, String url, int score, int quantyOfTresaure){
		String msj="No se ha podido anadir el tesoro";
		int positionX=(int)Math.random()*1281;
		int positionY=(int)Math.random()*721;
		Treasure newTreasure = new Treasure(name, url, score, quantyOfTresaure, positionX, positionY);
		int numberOfLevel=validateIfLevelExist(numberLevel);
		if(numberOfLevel!=-1){
			msj=levels[numberOfLevel].addTreasureWithObject(newTreasure)+levels[numberOfLevel].getNumber();
	
		}
		return msj;
	}
	public boolean validateIfEnemyExist(int numberLevel, String enemyId){
		int numberOfLevel=validateIfLevelExist(numberLevel);
		boolean enemyExist=false;
		if(levels[numberLevel].validateIfEnemyAlreadyExist(enemyId)==true){
			enemyExist=true;
		}
		return enemyExist;
	}
	public boolean validateIfTreasureExist(String treasureName){
		boolean treasureExist=false;
		for(int i=1;i<LEVELS_SIZE; i++) {
			if(levels[i]!=null){
				if(levels[i].validateIfTreasureExist(treasureName)==true){
				treasureExist=true;
				}
			}
		}
		return treasureExist;
	}
	public String addEnemyToLevel(int numberLevel, String id, int type, int scoreWin, int scoreLose){
		String msj="No se ha podido anadir el enemigo";
		int positionX=(int)Math.random()*1281;
		int positionY=(int)Math.random()*721;
		Enemy newEnemy = new Enemy(id, type, scoreWin, scoreLose, positionX, positionY);
		int numberOfLevel=validateIfLevelExist(numberLevel);
		msj=levels[numberOfLevel].addEnemyWithObject(newEnemy)+levels[numberOfLevel].getNumber();
		return msj;
	}
	public String setPlayerScore(String namePlayer, int newScorePlayer){
		String msj="";
		int posPlayer=validateIfPlayerExist(namePlayer);
		int actualScore=players[posPlayer].getScore();
		players[posPlayer].setScore(newScorePlayer);
		msj="El jugador "+players[posPlayer].getName()+" tiene un nuevo puntaje de "+players[posPlayer].getScore();
		return msj;
	}
	public int searchPlayerLevel(String namePlayer){
		int posLevel=0;	
		boolean isFound=false;
		int posPlayer=validateIfPlayerExist(namePlayer);
		for (int i=1;i<LEVELS_SIZE&&!isFound;i++) {
			if(levels[i]!=null){
				if(players[posPlayer].getLevel()==levels[i].getNumber()){
					posLevel=i;
					isFound=true;
				}
			}
		}	
		return posLevel;
	}
	public String levelUpPlayer(String namePlayer){
		String msj="";
		int posPlayer=validateIfPlayerExist(namePlayer);
		int levelWherePlayerIs=searchPlayerLevel(namePlayer);//Clase level
		int actualScore=players[posPlayer].getScore();
		int actualPlayerLevel=players[posPlayer].getLevel();//Clase player
		    if(validateIfLevelExist(levelWherePlayerIs+1)==-1){
		    	msj="El jugador no puede incrementar su nivel puesto que el siguiente nivel no se ha registrado aun";
		    }
				else if(actualScore>=levels[levelWherePlayerIs].getRequiredScoreToPassLevel()){
					players[posPlayer].setLevel(actualPlayerLevel+1);
					msj="El jugador" + namePlayer + " ha incrementado su nivel a " + players[posPlayer].getLevel();
				}
					else{
					msj="Al jugador"+namePlayer+" le faltan " + (levels[levelWherePlayerIs].getRequiredScoreToPassLevel()-actualScore)+ " puntos para incrementar su nivel";
					}
		return msj;
	}
	public String showLevelInfo(int numberLevel){
		String msj="";
		boolean isFound=false;
		for(int i=1; i<LEVELS_SIZE&&!isFound;i++){
			if(levels[i]!=null){
				if(levels[i].getNumber()==numberLevel){
					isFound=true;
					msj=levels[i].showLevelInfo()+levels[i].showOnlyEnemy()+levels[i].showOnlyTreasures()+"\n"+
						"Fueron encontrados en el nivel " +levels[i].getNumber();
				}	
			}	
		}
		return msj;
	}
	public String countTreasureInGame(String treasureName){
		int count=0;
		String msj="";
		for(int i=1; i<LEVELS_SIZE;i++){
			if(levels[i]!=null){
				if(levels[i].countTreasureByName(treasureName)!=0){
					count=count+levels[i].countTreasureByName(treasureName);
					msj="Existe(n) " + count + " tesoro(s) " + treasureName + " en todo el juego";
				}
			}
		}
	return msj;
	}
	public String countEnemiesInGame(int selectionType){
		int count=0;
		String msj="";
		for(int i=1; i<LEVELS_SIZE;i++){
			if(levels[i]!=null){
				if(levels[i].countEnemyByType(selectionType)!=0){
					count=count+levels[i].countEnemyByType(selectionType);
					msj="Existe(n) " + count + " enemigos de este tipo en todo el juego";
				}
			}
		}
	return msj;
	}
	//public String showMostRepeatenTreasure(){
		//int maxTreasure=0;
		//String msj="";
		//for(int i=1; i<LEVELS_SIZE;i++){
		//	if(levels[i]!=null){
		//		if(levels[i].mostRepeatenTreasure()<maxTreasure){
		//			maxTreasure= levels[i].mostRepeatenTreasure();
		//			msj="El tesoro más repetido es repetido" + maxTreasure;
		//		}
		//	}
		//}	
	//return msj;
	//}
	public String showMostValuableEnemyInGame(){
		String msj="";
		int scoreMostValuable=0;
		for(int i=1;i<LEVELS_SIZE;i++){
			if(levels[i]!=null){
				if(levels[i].showScoreMostValuableEnemy()>scoreMostValuable){
					scoreMostValuable=levels[i].showScoreMostValuableEnemy();
					msj="El enemigo más valioso es de tipo "+levels[i].showTypeMostValuableEnemy()+" y se encuentra en el nivel "+levels[i].getNumber()+" y brinda un puntaje "+scoreMostValuable;
				}
			}
		}
	return msj;		
	}
}

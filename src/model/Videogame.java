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
/**
*addPlayers: It adds a player entered by the user.
*@param idPlayer: String - It represents the id of the player.
*@param namePlayer: String - It represents the name of the player.
*@return msj: String - it is a message to confirm to user that the player has been added.
**/
	public String addPlayer(String idPlayer, String namePlayer){
		String msj="";
		int score=10;
		int lives=5;
		int level=1;
		Player newPlayer = new Player(idPlayer, namePlayer, score, lives, level);
		int emptyPos = searchEmptyposPlayer();
			if (emptyPos != -1){
				players[emptyPos]=newPlayer;
				msj="New player added";
			}
		return msj;
/**
*searchEmptyPosPlayer: It searches a empty position in the player's array.
*@return pos: int - It returns the empty position (in case that it exists) else, it returns -1.
**/
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
/**
*levelImposibleToadd: It validates if the level entered by the user can be added.
*@param numberLevel: int - It represents the number of level that the player wants to add.
*@return imposibleToadd : boolean - It returns true if the level is not in the range (the level cannot be added), else, it returns false and the level can be added. 
**/
	public boolean levelImposibleToAdd(int numberLevel){
		boolean imposibleToadd=false;
		int levelAlreadyExist=validateIfLevelExist(numberLevel);
			if(numberLevel>21||numberLevel<1){
				 imposibleToadd=true;
		}
		return imposibleToadd;
	}
/**
*addLevel: It adds a level acording to the data entered by the user. 
*@param numberLevel: int - It represents the number of the level that the player wants to add.
*@param requiredScore: int - It represents the required score to pass the level that the user wants to add.
*@return msj : String - It is a message to confirm to the user that the level has been added.
**/
	public String addLevel(int numberLevel, int requiredScore){
		String msj="";
		Level newLevel= new Level(numberLevel, requiredScore);
		int levelAlreadyExist=validateIfLevelExist(numberLevel);
		levels[numberLevel]=newLevel;
		msj="New level added";
		return msj;
	}
/**
*validateIfLevelExist: It validates in the level's array if a level already exists.
*@param numberLevel: int - It represents the number of the level.
*@return pos: int - It is the position of the level (in case that it exists), else, it returns -1. 
**/
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
/**
*validateIfPlayersExist: It validates in the player's array if a player already exists.
*@param namePlayer: String - It represents the name of the player.
*@return pos: int - It is the position of the player (in case that it exists), else, it returns -1. 
**/
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
/**
*addTreasureToLevel: It adds a treasure in a level.
*@param numberLevel: int - It represents the number of the level.
*@param selectionType: int - It represents the selection of the type of treasure.
*@param url: String - It represents the url of the treasure.
*@param score: int - It represents the score that the treasure gives to the player.
*@param quantyOfTrasure: int - It represents the quanty of the treasure that is going to be add.
*@return msj: String - It is a message to confirm that the treasure has been added.
**/
	public String addTreasureToLevel(int numberLevel, int selectionType, String url, int score, int quantyOfTresaure){
		String msj="";
		int positionX=(int)Math.random()*1281;
		int positionY=(int)Math.random()*721;
		Treasure newTreasure = new Treasure(selectionType, url, score, quantyOfTresaure, positionX, positionY);
		int numberOfLevel=validateIfLevelExist(numberLevel);
		msj=levels[numberOfLevel].addTreasureWithObject(newTreasure)+levels[numberOfLevel].getNumber();
		return msj;
/**
*validateIfEnemyExist: It validates if an enemy already exists in a level.
*@param numberLevel: int - It represents the number of the level.
*@param enemyId: String - It represents the id of the enemy.
*@return enemyExist: boolean - It returns true in case that the enemy already exists in the level, else, it returns false.
**/
	}
	public boolean validateIfEnemyExist(int numberLevel, String enemyId){
		int numberOfLevel=validateIfLevelExist(numberLevel);
		boolean enemyExist=false;
		if(levels[numberLevel].validateIfEnemyAlreadyExist(enemyId)==true){
			enemyExist=true;
		}
		return enemyExist;
	}
/**
*addTreasureToLevel: It adds a enemy in a level.
*@param numberLevel: int - It represents the number of the level.
*@param id: String - It represents the id of the enemy.
*@param selectionType: int - It represents the selection of the type of enemy.
*@param scoreWin: int - It represents the score that the enemy remove to the player in case that he (the enemy) wins the battle.
*@param scoreLose: int - It represents the score that the enemy gives to the player in case that he (the enemy) loses the battle.
*@return msj: String - It is a message to confirm that the enemy has been added.
**/
	public String addEnemyToLevel(int numberLevel, String id, int selectionType, int scoreWin, int scoreLose){
		String msj="";
		int positionX=(int)Math.random()*1281;
		int positionY=(int)Math.random()*721;
		Enemy newEnemy = new Enemy(id, selectionType, scoreWin, scoreLose, positionX, positionY);
		int numberOfLevel=validateIfLevelExist(numberLevel);
		msj=levels[numberOfLevel].addEnemyWithObject(newEnemy)+levels[numberOfLevel].getNumber();
		return msj;
	}
/**
*setPlayerScore: It modifies the score of a player. 
*@param namePlayer: String - It represents the name of a player.
*@param newScorePlayer: int - It represents the new score of the player.
*@return msj: String - It is message to confirm the new score of the player.
**/
	public String setPlayerScore(String namePlayer, int newScorePlayer){
		String msj="";
		int posPlayer=validateIfPlayerExist(namePlayer);
		int actualScore=players[posPlayer].getScore();
		players[posPlayer].setScore(newScorePlayer);
		msj="The player "+players[posPlayer].getName()+" has a new score of "+players[posPlayer].getScore();
		return msj;
	}
/**
*searchPlayerLevel: It compares the level where is the player (atribute class player) with the number of level (atribute class level), when both are equals saves the position.  
*@param namePlayer: String - It is the name of the player.
*@return posLevel: int - It is the position in the level's array where the number level (class Level) is equals to the level where is the player (class player).  
**/
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
/**
*levelUpPlayer: It increases the level of a player.
*@param namePlayer: String - It is the name of the player.
*@return msj: String - It is a message to confirm that the player has increased his level.   
**/
	public String levelUpPlayer(String namePlayer){
		String msj="";
		int posPlayer=validateIfPlayerExist(namePlayer);
		int levelWherePlayerIs=searchPlayerLevel(namePlayer);//Clase level
		int actualScore=players[posPlayer].getScore();
		int actualPlayerLevel=players[posPlayer].getLevel();//Clase player
		    if(validateIfLevelExist(levelWherePlayerIs+1)==-1){
		    	msj="The player cannot increase her/his level because the next level hasn't registered yet";
		    }
			else if(actualScore>=levels[levelWherePlayerIs].getRequiredScoreToPassLevel()){
				players[posPlayer].setLevel(actualPlayerLevel+1);
				msj="The player " + namePlayer + " has increased her/his level to " + players[posPlayer].getLevel();
			}
			else{
				msj="The player "+namePlayer+" is missing " + (levels[levelWherePlayerIs].getRequiredScoreToPassLevel()-actualScore)+ " points to increase her/his level";
			}
		return msj;
	}
/**
*showLevelInfo: It shows all the information of a level.
*@param numberLevel: int - It represents the number of the level.
*@return msj: String - It a message to show to the user the information of the level (enemies and treasures).
**/
	public String showLevelInfo(int numberLevel){
		String msj="";
		boolean isFound=false;
		for(int i=1; i<LEVELS_SIZE&&!isFound;i++){
			if(levels[i]!=null){
				if(levels[i].getNumber()==numberLevel){
					isFound=true;
					msj=levels[i].showLevelInfo()+levels[i].showOnlyEnemy()+levels[i].showOnlyTreasures()+"\n"+
						"Have been found in the level " +levels[i].getNumber();
				}	
			}	
		}
		return msj;
	}
/**
*countTreasuresInGame: It counts the quanty of a treasure.
*@param selectionTypeTreasure: int - It represents the selection of the treasure that is going to be count.
*@return msj: String - It shows the quanty of the treasure present in all the game.
**/
	public String countTreasuresInGame(int selectionTypeTreasure){
		int count=0;
		String msj="";
		for(int i=1; i<LEVELS_SIZE;i++){
			if(levels[i]!=null){
				if(levels[i].countTreasureByType(selectionTypeTreasure)!=0){
					count=count+levels[i].countTreasureByType(selectionTypeTreasure);
					msj="Exist(s) " + count + " treasure(s) of this type in all the game";
				}
			}
		}
		return msj;
	}
/**
*countEnemiesInGame: It counts the quanty of an enemy.
*@param selectionTypeEnemy: int - It represents the selection of the enemy that is going to be count.
*@return msj: String - It shows the quanty of the enemy present in all the game.
**/
	public String countEnemiesInGame(int selectionTypeEnemy){
		int count=0;
		String msj="";
		for(int i=1; i<LEVELS_SIZE;i++){
			if(levels[i]!=null){
				if(levels[i].countEnemyByType(selectionTypeEnemy)!=0){
					count=count+levels[i].countEnemyByType(selectionTypeEnemy);
					msj="Exist(s) " + count + " enemy(ies) of this type in all the game";
				}
			}
		}
		return msj;
	}
/**
*showMostRepeatenTreasure: It shows the most repeaten treasure in all the game.
*@return msj: String - It shows the most repeaten treasure in the game.
**/
	public String showMostRepeatenTreasure(){
			int countDiamonds = 0;
			int countEsmeralds=0;
			int countRubies=0;
			int countGolds=0;
			String msj="";
			for(int i=1; i<LEVELS_SIZE;i++){
				if(levels[i]!=null){
					countDiamonds=countDiamonds+levels[i].countDiamondsInLevel();
					countEsmeralds=countEsmeralds+levels[i].countEsmeraldsInLevel();
					countRubies=countRubies+levels[i].countRubiesInLevel();
					countGolds=countGolds+levels[i].countGoldsInLevel();
					if(countDiamonds>countEsmeralds&&countDiamonds>countRubies&&countDiamonds>countGolds){
						msj="The most repeaten treasure is DIAMOND and it is repeaten " + countDiamonds + " times in all the game ";
					}
					else if(countEsmeralds>countRubies&&countEsmeralds>countGolds){
						msj="The most repeaten treasure is ESMERALD and it is repeaten " + countEsmeralds + " times in all the game";
					}
					else if(countRubies>countGolds){
						msj="The most repeaten treasure is RUBY and it is repeaten " + countRubies + " times in all the game";
					}
					else if(countGolds>countRubies){
					msj="The most repeaten treasure is GOLD and it is repeaten " + countGolds + " times in all the game";
					}
					else{
					msj="There are several types of treasures that are the most repeated in all the game";
					}
				}
			}
		return msj;
	}
/**
*showMostValuableEnemyInGame: It shows the most valuable enemy in the game.
*@return msj: String - It is a message that shows the most valuable enemy in the game.
**/
	public String showMostValuableEnemyInGame(){
		String msj="";
		int scoreMostValuable=0;
		for(int i=1;i<LEVELS_SIZE;i++){
			if(levels[i]!=null){
				if(levels[i].showScoreMostValuableEnemy()>scoreMostValuable){
					scoreMostValuable=levels[i].showScoreMostValuableEnemy();
					msj="The most valuable enemy is of type "+levels[i].showTypeMostValuableEnemy()+", it was found in the level "+levels[i].getNumber()+" and gives a score of "+scoreMostValuable+" points";
				}
				else if(levels[i].showScoreMostValuableEnemy()==scoreMostValuable||levels[i].showScoreMostValuableEnemy()==-1){
					msj="There are several enemies that give the highest score";
				}	
			}
		}
	return msj;		
	}
/**
*showConsonantsEnemy: It shows the consonants of the enemy selected by the user.
*@param selectionType: int - It represents the selection of the enemy which is going to be count the consonants.
*@return msj: String - It shows the quanty of consonants of the enemy.
**/
	public String showConsonantsEnemy(int selectionType){
		String msj="El enemy has "+levels[1].countConsonantsEnemy(selectionType)+" consonants ";//It is levels[1] because all the enemies are in this level.
		return msj;
	}
/**
*ordenatePlayersInGame: It ordenate the array of players according the score of each one of them.
*@return ordenatePlayers: array - It shows the player's array of a ordenated way.
**/
	public Player[] ordenatePlayersInGame(){
		Player actualPlayer=null;
		Player[] ordenatedPlayers=players;
		for (int i=1; i<PLAYERS_SIZE; i++){
			for (int j=1; j<PLAYERS_SIZE-1;j++){
				if(players[j+1]!=null){
					if(players[j].getScore()<players[j+1].getScore()){
						actualPlayer=players[j];
						players[j]=players[j+1];
						players[j+1]=actualPlayer;
					}
				}
			}
		}
		return ordenatedPlayers;
	}
/**
*showBestPlayersIngame: It shows the 5 best players in the game.
*@return msj: It is a message that show the top 5 of players.
**/
	public String showBestPlayersInGame(){
		String msj="";
		for(int i=1; i<6;i++){
			if(ordenatePlayersInGame()[i]!=null){
			msj=msj+"\n"+"Top "+ i +" "+ ordenatePlayersInGame()[i].getName()+ " with a score of "+ ordenatePlayersInGame()[i].getScore();
			}
		}	
		return msj;
	}
}

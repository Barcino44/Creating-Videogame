package ui; 

import java.util.Scanner; 
import model.*; 

public class Main{
	
	private Scanner reader; 

	private Videogame videogame; 

	public Main(){
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.initVideogame();

		int option = -1; 
		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

	}


	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(printMenu());

		option = validateIntegerOption(); 

		return option; 
	}

	public String printMenu(){
		return 
			"<<-<< <<-<< Welcome >>->> >>->>\n" +
			"1.Create a player \n" +
			"2.Add a level\n"+
			"3.Add a treasure to a level \n"+
			"4.Add an enemy to a level\n"+
			"5.Modify a player's score\n"+
			"6.Increase a player's level\n"+
			"7.Show enemies and treasures present in a level\n"+
			"8.Show the number of treasures given a type\n"+
			"9.Show the number of enemies given a type\n"+
			"10.Show the most repeated treasure\n"+
			"11.Show the enemy that gives the most points and the level where it is\n"+
			"12.Show the amount of consonants of some enemy\n"+
			"13.Show top 5 players\n"+
			"0.Exit program";  
	}
	// this method executes the option
	public void executeOption(int option){
			String idPlayer="";
			String namePlayer="";
			String msj="";
			int numberLevel=0;
			int requiredScoreToPassLevel=0;
			int selectionTypeTreasure=0;
			String validationTreasure=("The possible types of treasures are:\n"+
									"1. DIAMOND\n"+
									"2. ESMERALD\n"+
									"3. RUBY\n"+
									"4. GOLD");
			String treasureUrl="";
			int treasureScore=0;
			int quantyOfTreasure=0;
			String enemyId="";
			int selectionTypeEnemy=0;
			String validationEnemy=("The possible types of enemies are:\n"+
							  "1. OGRE\n"+
							  "2. ABSTRACT\n"+
							  "3. BOSS\n"+
							  "4. MAGICIAN");
			int scoreEnemyWin=0;
			int scoreEnemyLose=0;
			int quantyOfEnemy=0;
			int newScorePlayer=0;	
			switch(option){
				case 1: 
					//Id player
					System.out.println("Aclaration!!!!\n"+
										"Players when they are created have 5 lives, a score of 10 and they are level 1");
					System.out.println("Enter the player's ID");
					idPlayer=reader.next();

					//NamePlayer
					System.out.println("Enter the player's name");
					namePlayer=reader.next();
					if(videogame.validateIfPlayerExist(namePlayer)!=-1){
							System.out.println("The player already exists");
						}
					else{
						//Confirmation
						msj=videogame.addPlayer(idPlayer, namePlayer);
						System.out.println(msj);
					}
					break; 

				case 2: 
					//Number of the level that is going to be add
					System.out.println("Levels 1-10 are already initialized");
					System.out.println("Both initialized and added levels have 4 different types of enemies and 4 different treasures");
					System.out.println("Enter the number of the level you want to add");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalid, enter a level number");
					}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)!=-1){
						System.out.println("The level already exists");
					}
					else if(videogame.levelImposibleToAdd(numberLevel)==true){
						System.out.println("The level cannot be added, you are entering a number greater than 20 (maximum level that can be added), a negative number or a level 0");
					}
					else{
						//Required score to pass the level
						System.out.println("Enter the score required to pass it");
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("Invalid, enter a level number");
							}
						requiredScoreToPassLevel=reader.nextInt();
						//Confirmation
						msj=videogame.addLevel(numberLevel, requiredScoreToPassLevel);
						System.out.println(msj);
					}
					break; 

				case 3:
					//Level where the treasure is going to be added.
					System.out.println("Enter the level number where you want to add the treasure");
						 while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter a level number");
						}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)==-1){
							System.out.println("The level doesn't exist");
					}
					else{
						//Selection type treasure.
						System.out.println("Enter the number of the treasure to add");
						System.out.println(validationTreasure);

						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter the number that corresponds to some type of treasure");
							System.out.println("Enter the number of the treasure to add");
							System.out.println(validationTreasure);
						}
						selectionTypeTreasure=reader.nextInt();

						while(selectionTypeTreasure!=1&&selectionTypeTreasure!=2&&selectionTypeTreasure!=3&&selectionTypeTreasure!=4){
							System.out.println("It is not a type of treasure");
							System.out.println(validationTreasure);
							selectionTypeTreasure=reader.nextInt();
						}
						//Url treasure
						System.out.println("Enter the treasure url");
						treasureUrl=reader.next();

						//Score treasure
						System.out.println("Enter the score that the treasure gives if it is achieved");

							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("Invalid, the score must be an integer");
							}
						treasureScore= reader.nextInt();

						//Quanty of treasure
						System.out.println("Enter the quanty of the treasure you want to add");
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("Invalid, enter a valid quanty");
							}
						quantyOfTreasure=reader.nextInt();

						//Confirmation
						msj=videogame.addTreasureToLevel(numberLevel, selectionTypeTreasure, treasureUrl, treasureScore, quantyOfTreasure);
						System.out.println(msj);
					}

					break;
					
				case 4: 
					//Level where the enemy is going to be added.
					System.out.println("Enter the level number where you want to add the enemy");
						 while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter a level number");
						}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)==-1){
						System.out.println("The level doesn't exist");
					}
					else if(videogame.validateIfLevelExist(numberLevel)!=-1){
						//Id enemy
						System.out.println("Enter the id of the enemy");
						enemyId=reader.next();
						if(videogame.validateIfEnemyExist(numberLevel, enemyId)==true){
							System.out.println("The enemy already exists, it cannot be added");
						}
						else{
							//Type enemy
							System.out.println("Enter the number of the enemy to add");
							System.out.println(validationEnemy);

							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("Invalid, enter the number that corresponds to some type of enemy");
								System.out.println("Enter the number of the enemy to add");
								System.out.println(validationEnemy);
							}
							selectionTypeEnemy=reader.nextInt();

							while(selectionTypeEnemy!=1&&selectionTypeEnemy!=2&&selectionTypeEnemy!=3&&selectionTypeEnemy!=4){
								System.out.println("It is not a type of enemy");
								System.out.println(validationEnemy);
								selectionTypeEnemy=reader.nextInt();
							}

							//Score If enemy win
							System.out.println("Enter the score that the enemy takes from the player if they are victorious");

							while(!reader.hasNextInt()){
									reader.next();
									System.out.println("Invalid, the score must be an integer");
								}
							scoreEnemyWin=reader.nextInt();

							//Score if enemy lose
							System.out.println("Enter the score the enemy gives the player if he (the enemy) is defeated");

							while(!reader.hasNextInt()){
									reader.next();
									System.out.println("Invalid, the score must be an integer");
								}
							scoreEnemyLose=reader.nextInt();

							//Confirmation
							msj=videogame.addEnemyToLevel(numberLevel, enemyId, selectionTypeEnemy, scoreEnemyWin, scoreEnemyLose);
							System.out.println(msj);
						}
					}
					break;
				case 5:
					//Name player
					System.out.println("Enter the name of the player whose score you want to modify");
					namePlayer=reader.next();
					if(videogame.validateIfPlayerExist(namePlayer)==-1){
							System.out.println("The player doesn't exist");
						}
					else{
						//Player new score
						System.out.println("Enter the player's new score");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("The new score must be an integer");
						}	
						newScorePlayer=reader.nextInt();

						//Confirmation
						msj=videogame.setPlayerScore(namePlayer,newScorePlayer);
						System.out.println(msj);
					}
					break;
				case 6:
					//Name player
					System.out.println("Enter the name of the player whose level you want to modify");
					namePlayer=reader.next();
					if(videogame.validateIfPlayerExist(namePlayer)==-1){
						System.out.println("The player doesn't exist");
					}
					else{
						//Confirmation
						msj=videogame.levelUpPlayer(namePlayer);
						System.out.println(msj);
					}	
					break;
				case 7:
					//Number of level
					System.out.println("Enter the name of the level for which you want to consult the information");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Please insert a valid level number");
					}	
					numberLevel=reader.nextInt();
					if(videogame.validateIfLevelExist(numberLevel)==-1){
							System.out.println("The level doesn't exist");
					}
					else{
						//Show information
						msj=videogame.showLevelInfo(numberLevel);
						System.out.println(msj);
					}
					break;
				case 8:
					//Type treasure
					System.out.println("Enter the number of the treasure you want to search for");
					System.out.println(validationTreasure);
					while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter the number that corresponds to some type of treasure");
							System.out.println(validationTreasure);
					}
					selectionTypeTreasure=reader.nextInt();

					while(selectionTypeTreasure!=1&&selectionTypeTreasure!=2&&selectionTypeTreasure!=3&&selectionTypeTreasure!=4){
							System.out.println("It is not a type of treasure");
							System.out.println(validationTreasure);
							selectionTypeTreasure=reader.nextInt();
					}
					//Show information
					msj=videogame.countTreasuresInGame(selectionTypeTreasure);
					System.out.println(msj);
					break;
				case 9:
					//Type Enemy
					System.out.println("Enter the number of the enemy you want to search for");
					System.out.println(validationEnemy);
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalid, enter the number that corresponds to some type of enemy");
						System.out.println(validationEnemy);
					}
					selectionTypeEnemy=reader.nextInt();

					while(selectionTypeEnemy!=1&&selectionTypeEnemy!=2&&selectionTypeEnemy!=3&&selectionTypeEnemy!=4){
						System.out.println("It is not an enemy type");
						System.out.println(validationEnemy);
						selectionTypeEnemy=reader.nextInt();
					}
					//Show information
					msj=videogame.countEnemiesInGame(selectionTypeEnemy);
					System.out.println(msj);
					break;
				case 10:
					//Show information
					msj=videogame.showMostRepeatenTreasure();
					System.out.println(msj);
					break;
				case 11:
					//Show information
					msj=videogame.showMostValuableEnemyInGame();
					System.out.println(msj);
					break;
				case 12:
					//Type enemy
					System.out.println("It will show you the number of consonants of the enemy you choose");
					System.out.println("Enter the number of the enemy you want to know the consonants");
					System.out.println(validationEnemy);
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalid, enter the number that corresponds to some type of enemy");
						System.out.println(validationEnemy);
					}
					selectionTypeEnemy=reader.nextInt();

					while(selectionTypeEnemy!=1&&selectionTypeEnemy!=2&&selectionTypeEnemy!=3&&selectionTypeEnemy!=4){
						System.out.println("It is not an enemy type");
						System.out.println(validationEnemy);
						selectionTypeEnemy=reader.nextInt();
					}
					//Show information
					msj=videogame.showConsonantsEnemy(selectionTypeEnemy);
					System.out.println(msj);
					break;	
				case 13:
					//Show information
					msj=videogame.showBestPlayersInGame();
					System.out.println(msj);
				break;
				case 0: 
					System.out.println("Exit program.");
					break; 

				default: 
					System.out.println("Invalid Option");
					break; 
			}
	}

	public void initVideogame(){
		System.out.println("Welcometo Barcino's Game enter your name");
		String name = reader.nextLine(); 
		this.videogame = new Videogame(name);

	}

	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

}
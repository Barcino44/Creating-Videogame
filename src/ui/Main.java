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
			"2.Anadir un nivel\n"+
			"3.Anadir un tesoro a un nivel \n"+
			"4.Anadir un enemigo a un nivel\n"+
			"5.Modificar el puntaje de un jugador\n"+
			"6.Incrementar el nivel de un jugador\n"+
			"7.Mostrar los enemigos y tesoros presentes en un nivel\n"+
			"8.Mostrar la cantidad de tesoros a partir de un nombre";  
	}
	// this method executes the option
	public void executeOption(int option){
			String idPlayer="";
			String namePlayer="";
			String msj="";
			int numberLevel=0;
			int requiredScoreToPassLevel=0;
			String treasureName="";
			String treasureUrl="";
			int treasureScore=0;
			int quantyOfTreasure=0;
			String enemyId="";
			int typeEnemy=0;
			String validation=("Ingrese el tipo de enemigo a anadir\n"+
									  "Los posibles tipos de enemigos son:\n"+
									  "1. Ogro\n"+
									  "2. Abstracto\n"+
									  "3. Jefe\n"+
									  "4. Magico");
			int scoreEnemyWin=0;
			int scoreEnemyLose=0;
			int quantyOfEnemy=0;
			int newScorePlayer=0;	
			switch(option){
				case 1: 
					System.out.println("Aclaracion!!!!\n"+
										"Los jugadores cuando son creados cuentan con 5 vidas, un puntaje de 10 y se encuentran en el nivel 1");
					System.out.println("Digite el Id del player");
					idPlayer=reader.next();
					System.out.println("Digite el name del player");
					namePlayer=reader.next();
					if(videogame.validateIfPlayerExist(namePlayer)!=-1){
							System.out.println("El jugador ya existe");
						}
					else{
						msj=videogame.addPlayer(idPlayer, namePlayer);
					System.out.println(msj);
					}
					break; 

				case 2: 
					System.out.println("Los niveles 1-10 ya se encuentran inicializados");
					System.out.println("Tanto los niveles inicializados como los que se anadan tienen 4 tipos distintos de enemigos y 3 tesoros");
					System.out.println("Digite el numero del nivel que desea anadir");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalido, digite un numero de nivel");
					}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)!=-1){
							System.out.println("El nivel ya existe");
					}
					else{
					System.out.println("Digite el puntaje requerido para pasarlo");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite un numero de nivel");
						}
					requiredScoreToPassLevel=reader.nextInt();
					msj=videogame.addLevel(numberLevel, requiredScoreToPassLevel);
					System.out.println(msj);
					}
					break; 

				case 3:
					//Nivel donde se va a anadir el tesoro
					System.out.println("Ingrese el numero de nivel donde sea anadir el tesoro");
						 while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite un numero de nivel");
						}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)==-1){
							System.out.println("El nivel no existe");
					}
					else{
					//Nombre del tesoro
					System.out.println("Ingrese el nombre del tesoro");
					treasureName=reader.next();

					//URL del tesoro
					System.out.println("Ingrese el url del tesoro");
					treasureUrl=reader.next();

					//Puntaje del tesoro
					System.out.println("Ingrese el puntaje que brinda el tesoro si es conseguido");

						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite un score valido");
						}
					treasureScore= reader.nextInt();

					//Cantidad de tesoro
					System.out.println("Ingrese la cantidad del tesoro que desea anadir");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite una cantidad valida");
						}
					quantyOfTreasure=reader.nextInt();
					//Confirmation
					msj=videogame.addTreasureToLevel(numberLevel, treasureName, treasureUrl, treasureScore, quantyOfTreasure);
					System.out.println(msj);
					}

					break;
					
				case 4: 
						//Nivel donde se va a anadir el enemigo
					System.out.println("Ingrese el numero de nivel donde sea anadir el enemigo");
						 while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite un numero de nivel");
						}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)==-1){
							System.out.println("El nivel no existe");
						}
					else if(videogame.validateIfLevelExist(numberLevel)!=-1){
					//Id enemy
					System.out.println("Ingrese el id del enemigo");
					enemyId=reader.next();
						if(videogame.validateIfEnemyExist(numberLevel, enemyId)==true){
							System.out.println("El enemigo ya existe, no se puede anadir");
							}
					//Type enemy
					else{
					System.out.println(validation);

						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite el numero que le corresponde a algun tipo de enemigo");
							System.out.println(validation);
						}
						typeEnemy=reader.nextInt();

						while(typeEnemy!=1&&typeEnemy!=2&&typeEnemy!=3&&typeEnemy!=4){
							System.out.println("No es un tipo de enemigo");
							System.out.println(validation);
							typeEnemy=reader.nextInt();
						}

					//Score If enemy win
					System.out.println("Ingrese el puntaje que le resta el enemigo al jugador si es victorioso");

					while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, el puntaje debe ser un numero entero");
						}
					scoreEnemyWin=reader.nextInt();
					//Score if enemy lose
					System.out.println("Ingrese el puntaje que le da el enemigo al jugador si es derrotado");

					while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, el puntaje debe ser un numero entero");
						}
					scoreEnemyLose=reader.nextInt();
					msj=videogame.addEnemyToLevel(numberLevel, enemyId, typeEnemy, scoreEnemyWin, scoreEnemyLose);
					System.out.println(msj);
					}
				}
					break;
				case 5:
					System.out.println("Digite el nombre del jugador el cual desea modificarle el puntaje");
					namePlayer=reader.next();
					if(videogame.validateIfPlayerExist(namePlayer)==-1){
							System.out.println("El jugador no existe");
						}
					else{
					System.out.println("Ingrese el nuevo puntaje del jugador");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("El nuevo puntaje debe ser un numero entero");
					}	
					newScorePlayer=reader.nextInt();
					msj=videogame.setPlayerScore(namePlayer,newScorePlayer);
					System.out.println(msj);
					}
					break;
				case 6:
					System.out.println("Digite el nombre del jugador el cual desea modificarle el nivel");
					namePlayer=reader.next();
					if(videogame.validateIfPlayerExist(namePlayer)==-1){
							System.out.println("El jugador no existe");
						}
					else{
					msj=videogame.levelUpPlayer(namePlayer);
					System.out.println(msj);
					}	
					break;
				case 7:
					System.out.println("Digite el nombre del nivel del cual desea consultar la informacion");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Inserte un numero de nivel valido");
					}	
					numberLevel=reader.nextInt();
					msj=videogame.showLevelInfo(numberLevel);
					System.out.println(msj);
					break;
				case 8:
					System.out.println("Digite el nombre del tesoro que desea buscar");
					treasureName=reader.next();
					if (videogame.validateIfTreasureExist(treasureName)!=true){
						System.out.println("El tesoro no existe");
					}
					else{
						msj=videogame.countTreasureInGame(treasureName);
						System.out.println(msj);
					}
					break;
				case 9:
					System.out.println("Digite el numero del enemigo que desea buscar");
					System.out.println(validation);

						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite el numero que le corresponde a algun tipo de enemigo");
							System.out.println(validation);
						}
						typeEnemy=reader.nextInt();

						while(typeEnemy!=1&&typeEnemy!=2&&typeEnemy!=3&&typeEnemy!=4){
							System.out.println("No es un tipo de enemigo");
							System.out.println(validation);
							typeEnemy=reader.nextInt();
						}
				case 0: 
					System.out.println("Exit program.");
					break; 

				default: 
					System.out.println("Invalid Option");
					break; 
			}
	}

	public void initVideogame(){
		System.out.println("Bienvenido Barcino's Game digite su nombre");
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
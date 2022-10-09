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
			"4.Anadir un enemigo a un nivel";  
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
			int treasurePositionX=0;
			int treasurePositionY=0;
			String enemyId="";
			String typeEnemy="";
			String validation=("Ingrese el tipo de enemigo a anadir\n"+
									  "Los posibles tipos de enemigos son:\n"+
									  "Ogro\n"+
									  "Abstracto\n"+
									  "Jefe\n"+
									  "Magico");
			int scoreEnemyWin=0;
			int scoreEnemyLose=0;
			int quantyOfEnemy=0;
			int enemyPositionX=0;
			int enemyPositionY=0;

			switch(option){
				case 1: 
					System.out.println("Digite el Id del player");
					idPlayer=reader.next();
					System.out.println("Digite el name del player");
					namePlayer=reader.next();
					msj=videogame.addPlayer(idPlayer, namePlayer);
					System.out.println(msj);
					break; 

				case 2: 
					System.out.println("Digite el numero del nivel que desea anadir");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalido, digite un numero de nivel");
					}
					numberLevel=reader.nextInt();

					if(videogame.validateIfLevelExist(numberLevel)!=-1){
							System.out.println("El nivel ya existe");
							break;
						}
					System.out.println("Digite el puntaje requerido para pasarlo");
					while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalido, digite un numero de nivel");
					}
					requiredScoreToPassLevel=reader.nextInt();
					msj=videogame.addLevel(numberLevel, requiredScoreToPassLevel);
					System.out.println(msj);
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
							break;
						}

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
					System.out.println("Ingrese el puntaje que brinda la cantidad del tesoro que desea anadir");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, digite una cantidad valida");
						}
					quantyOfTreasure=reader.nextInt();

					//Posicion X
					System.out.println("Ingrese la posicion X");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, las posiciones son numeros enteros");
						}
					treasurePositionX=reader.nextInt();

					//Posicion Y
					System.out.println("Ingrese la posicion Y");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, las posiciones son numeros enteros");
						}
					treasurePositionY=reader.nextInt();
					//Confirmation
					msj=videogame.addTreasureToLevel(numberLevel, treasureName, treasureUrl, treasureScore, quantyOfTreasure, treasurePositionX, treasurePositionY);
					System.out.println(msj);

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
							break;
						}
					//Id enemy
					System.out.println("Ingrese el id del enemigo");
					enemyId=reader.next();
					//Type enemy

					System.out.println(validation);

						typeEnemy=reader.next();

						while(!typeEnemy.equals("Ogro")&&!typeEnemy.equals("Abstracto")&&!typeEnemy.equals("Jefe")&&!typeEnemy.equals("Magico")){
							System.out.println("No es un tipo de enemigo");
							System.out.println(validation);
							typeEnemy=reader.next();
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
					//Quanty of enemies
					System.out.println("Ingrese la cantidad de enemigos que desea anadir");
					while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, la cantidad es un numero entero");
						}
					quantyOfEnemy=reader.nextInt();

					//Posicion X
					System.out.println("Ingrese la posicion X");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, las posiciones son numeros enteros");
						}
					enemyPositionX=reader.nextInt();

					//Posicion Y
					System.out.println("Ingrese la posicion Y");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalido, las posiciones son numeros enteros");
						}
					enemyPositionY=reader.nextInt();

					msj=videogame.addEnemyToLevel(numberLevel, enemyId, typeEnemy, scoreEnemyWin, scoreEnemyLose, quantyOfEnemy, enemyPositionX, enemyPositionY);
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
		System.out.println("Bienvenido a la tienda, digite su nombre");
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
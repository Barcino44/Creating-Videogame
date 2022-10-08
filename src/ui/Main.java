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
			"4.Show data Shop";  
	}
	// this method executes the option
	public void executeOption(int option){
			String idPlayer="";
			String namePlayer="";
			String msj="";
			int numberLevel=0;
			int requiredScoreToPassLevel=0;
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
				System.out.println("Ingrese el numero de nivel donde sea anadir el tesoro")
					 while(!reader.hasNextInt()){
						reader.next();
						System.out.println("Invalido, digite un numero de nivel");
					}
					numberLevel=reader.nextInt(){
						while(videogame.validateIfLevelExist(numberLevel)==-1)
						reader.next();
						System.out.println("El nivel no existe comediante...");
					}
					numberLevel=reader.nextInt();
					break;

				case 4: 

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
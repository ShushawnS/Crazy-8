package crazy8;
import java.util.*;

public class Game {

    //private String gameName;
    private int numPlayers;
    private boolean meetPlayerReq = false; 

    public Game() {
    }

    public int getNumPlayers(Scanner input) {
        System.out.println("\n\nWelcome to Crazy8's!");
        System.out.println("\nPlease provide some information to initalize this game: \n"); 

        while (meetPlayerReq == false) {
            System.out.print("Number of Players (MUST BE between 2-5) >> "); 
            numPlayers = input.nextInt(); 
            input.nextLine();
            System.out.print("\n");  

            if (numPlayers >= 2 && numPlayers <= 5)
                meetPlayerReq = true;
        }
                    
        return numPlayers;
    } 

    public int choosePlayer(Scanner input, Player[] players, int numPlayers){
        
        System.out.print("\n");
        for (int i = 0; i < numPlayers; ++i){
            System.out.print(" " + (i + 1) + "-" + players[i].getPlayerName()); 
        } 
        System.out.print("\n\nType the number for the player you would like to play for: ");
        int userChoice = input.nextInt();
        userChoice--;
        return userChoice;
    } 

}

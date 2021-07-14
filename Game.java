package crazy8;
import java.util.*;

public class Game {

    //private String gameName;
    private int numPlayers;
    private boolean meetPlayerReq = false;

    public Game() {
    }

    public int initalizeGame(Scanner input) {
        System.out.println("\n\nWelcome to Crazy8's!");
        System.out.println("\nPlease provide some information to initalize this game: "); 

        while (meetPlayerReq == false) {
            System.out.print("Number of Players (MUST BE between 2-5) >> "); 
            numPlayers = input.nextInt(); 
            input.nextLine();

            if (numPlayers >= 2 && numPlayers <= 5)
                meetPlayerReq = true;
        }
                    
        return numPlayers;
    }
}

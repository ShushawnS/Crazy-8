package crazy8;
import java.util.*;

public class CrazyEightGame {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Game Crazy8 = new Game();
        Deck theDeck = new Deck();
        int numPlayers;

        numPlayers = Crazy8.initalizeGame(input);
        System.out.println(numPlayers);

        Player[] players = new Player[numPlayers]; 

        for (int y = 0; y < numPlayers; ++y) {
            players[y] = new Player(y);
            players[y].setPlayerDetails(input, y);
        }

        
        input.close();
    } 


    
}

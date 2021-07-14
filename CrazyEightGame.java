package crazy8;
import java.util.*;

public class CrazyEightGame {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Game Crazy8 = new Game();
        Deck theDeck = new Deck();
        int numPlayers;

        numPlayers = Crazy8.initalizeGame(input);

        Player[] players = new Player[numPlayers]; 

        //sets player details
        for (int y = 0; y < numPlayers; ++y) {
            players[y] = new Player(y);
            players[y].setPlayerDetails(input, y); 

            //creates original deck for each player
            for (int x = 0; x < 5; ++x) {
                String pulledCard;
                pulledCard = theDeck.getCard(); 

                players[y].setPlayerDeck(pulledCard); 
            } 

            players[y].displayPlayerDeck();
        }          

        input.close();
    } 


    
}

package crazy8;
import java.util.*;

public class CrazyEightGame {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Game Crazy8 = new Game();
        Deck theDeck = new Deck();
        int numPlayers; 
        boolean roundOn = true; 
        ArrayList<Integer> playerOrder = new ArrayList<>();

        numPlayers = Crazy8.getNumPlayers(input);

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
                playerOrder.add(x);
            } 

            //players[y].displayPlayerDeck(); 
        }   

        int test = Crazy8.choosePlayer(input, players, numPlayers); 
        System.out.println("Welcome " + players[test].getPlayerName() + ", it is now time to play!");
        
        String currentCard = theDeck.getCard(); 
        int turnNum = 0; 
        int currentPlayerNum = 0;


        while (roundOn){ 

            System.out.println("The current card is: " + currentCard);

            for (turnNum = 0; turnNum < numPlayers; ++turnNum) {
                System.out.println(players[currentPlayerNum].getPlayerName() + "played: ");
                players[currentPlayerNum].displayPlayerDeck();
                String mother = players[currentPlayerNum].getPlayedCard();
                currentPlayerNum++; 
                
            }

            roundOn = false;
        }
        
        

        input.close();
    } 


    
}

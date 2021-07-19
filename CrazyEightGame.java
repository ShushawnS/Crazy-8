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

        int chosenPlayer = Crazy8.choosePlayer(input, players, numPlayers); 
        System.out.println("Welcome " + players[chosenPlayer].getPlayerName() + ", it is now time to play!");
        
        String currentCard = theDeck.getCard(); 
        int turnNum = 0; 
        int currentPlayerNum = 0; 
        String[] splitCurrent;


        while (roundOn){ 
             
            for (turnNum = 0; turnNum < numPlayers; ++turnNum) { 
                

                splitCurrent = currentCard.split("\\s");  
                //System.out.println("The splitCurrent array length is: " + splitCurrent[3]); 

                if (currentPlayerNum != chosenPlayer) {
                    String playedCard = players[currentPlayerNum].getPlayedCard(splitCurrent[0], splitCurrent[1]); 

                    if (playedCard != "noCard") {
                        System.out.println(players[currentPlayerNum].getPlayerName() + " played: " + playedCard);
                        currentCard = playedCard;
                    } else {
                        System.out.println(players[currentPlayerNum].getPlayerName() + " played: " + playedCard);
                    }
                } else {
                    System.out.println("\n\nThe current card is: " + currentCard); 
                    System.out.println("Your deck has the following: "); 
                    players[currentPlayerNum].displayPlayerDeck(); 

                    int numCards = players[currentPlayerNum].getCardListLength();
                    int index = 0; 

                    do {
                        System.out.print("\nPut the index of the card you would like to play: " + numCards); 
                        index = input.nextInt(); 
                    } while (index > numCards || index < 0) ;
                    

                    roundOn = false;
                }
                               
                currentPlayerNum++;  
            }

            currentPlayerNum = 0;
            System.out.println("Round is completed: " + turnNum);
            //roundOn = false;
        }
        
        

        input.close();
    } 


    
}

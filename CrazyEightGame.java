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

        System.out.print("\033[H\033[2J"); 
        numPlayers = Crazy8.getNumPlayers(input);

        Player[] players = new Player[numPlayers]; 
        String pulledCard;

        //sets player details
        for (int y = 0; y < numPlayers; ++y) {
            players[y] = new Player(y);
            players[y].setPlayerDetails(input, y); 

            //creates original deck for each player
            for (int x = 0; x < 5; ++x) {
                pulledCard = theDeck.getCard(); 

                players[y].setPlayerDeck(pulledCard); 
                playerOrder.add(x);
            } 

            //players[y].displayPlayerDeck(); 
        }   

        System.out.print("\033[H\033[2J"); 
        int chosenPlayer = Crazy8.choosePlayer(input, players, numPlayers);  
        System.out.print("\033[H\033[2J"); 
        System.out.println("Welcome " + players[chosenPlayer].getPlayerName() + ", it is now time to play!");
        
        String currentCard = theDeck.getCard(); 
        int turnNum = 0; 
        int currentPlayerNum = 0; 
        String[] splitCurrent; 
        String playedCard;
        Boolean overDraw = false;


        while (roundOn){ 
             
            for (turnNum = 0; turnNum < numPlayers; ++turnNum) { 
                

                splitCurrent = currentCard.split("\\s");  
                //System.out.println("The splitCurrent array length is: " + splitCurrent[3]); 

                if (currentPlayerNum != chosenPlayer) {
                    playedCard = players[currentPlayerNum].getPlayedCard(splitCurrent[0], splitCurrent[1]); 

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
                    int numDraw = 0;

                    do {
                        System.out.print("\nPut the index of the card you would like to play (1-" + numCards + ") & use 0 to draw a card: "); 
                        index = input.nextInt() - 1; 

                        if (index == -1 && overDraw == false) {
                            pulledCard = theDeck.getCard(); 
                            players[currentPlayerNum].addSelectedCard(pulledCard);
                            System.out.print("You pulled: " + pulledCard + " & Your new deck is now: " ); 
                            players[currentPlayerNum].displayPlayerDeck();
                            numDraw++;

                            if (numDraw == 3) {
                                System.out.print("This is your last draw for this draw, if you do not have the right card -- use -1 to skip your turn" );
                            } else if (numDraw == 4) {
                                overDraw = true; 
                                index = 1;
                            }
                        }

                        if (index < numCards && index > -1 && overDraw == false) { 
                            playedCard = players[currentPlayerNum].getSelectCard(index);
                            
                            if (Crazy8.validSelectedCard(playedCard, splitCurrent)) {
                                players[currentPlayerNum].deleteSelectedCard(index); 
                                System.out.print("You played: " + playedCard);
                            } else {
                                System.out.print("Invalid Card");
                                index = -1;
                            }
                            
                        } 

                    } while (index > numCards || index < 0) ;
                    


                    roundOn = false;
                }
                               
                currentPlayerNum++;  
            }

            currentPlayerNum = 0; 
            //System.out.print("\033[H\033[2J"); 
            System.out.println("\n\nRound is completed: " + turnNum); 

            //roundOn = false;
        }
        
        

        input.close();
    } 


    
}

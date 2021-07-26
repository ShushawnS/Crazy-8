package crazy8;

import java.util.*;

public class Game {
    static Scanner input = new Scanner(System.in); 
    private Deck theDeck; 
    private Player[] players; 
    private ArrayList<Integer> playerOrder;

    private int numPlayers;
    private boolean meetPlayerReq = false; 
    private String pulledCard; 
    private int chosenPlayer; 
    private String currentCard; 
    private int turnNum; 
    private int currentPlayerNum;
    private String[] splitCurrent; 
    private String playedCard;
    private Boolean roundOn;
    private Boolean overDraw;
    private int roundNum;

    public Game() { 
        theDeck = new Deck(); 
        playerOrder = new ArrayList<>(); 

        System.out.print("Trial");
    } 

    public void initalizeGameDetails() {

        System.out.println("\n\nWelcome to Crazy8's!");
        System.out.println("\nPlease provide some information to initalize this game: \n"); 

        numPlayers = getNumPlayers();

        players = new Player[numPlayers]; 
        initalizePlayers(players);

        chosenPlayer = choosePlayer();

    }   

    public int getNumPlayers () {
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

    public void initalizePlayers (Player[] players) { 
        //sets player details
        for (int y = 0; y < numPlayers; ++y) {
            players[y] = new Player(y);
            //players[y].setPlayerDetails(input, y); 

            //creates original deck for each player
            for (int x = 0; x < 5 ; ++x) {
                pulledCard = theDeck.getCard(); 

                players[y].setPlayerDeck(pulledCard); 
                playerOrder.add(x);
            } 

            //players[y].displayPlayerDeck(); 
        }
    }

    public int choosePlayer () {
        System.out.print("\n");
        for (int i = 0; i < numPlayers; ++i){
            System.out.print(" " + (i + 1) + "-" + players[i].getPlayerName()); 
        } 
        System.out.print("\n\nType the number for the player you would like to play for: ");
        int userChoice = input.nextInt();
        userChoice--;
        return userChoice;
    } 

    public void playGame () {

        currentCard = theDeck.getCard(); 
        turnNum = 0; 
        currentPlayerNum = 0; 
        roundOn = true;
        overDraw = false;
        roundNum = 0;

        System.out.print("\033[H\033[2J"); 
        System.out.println("Welcome " + players[chosenPlayer].getPlayerName() + ", it is now time to play!"); 

        while (roundOn) {
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

                    int numCards; 
                    int index = 0;  
                    int numDraw = 0;

                    do { 
                        numCards = players[currentPlayerNum].getCardListLength();
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
                            
                            if (validSelectedCard(playedCard, splitCurrent)) {
                                players[currentPlayerNum].deleteSelectedCard(index); 
                                System.out.print("You played: " + playedCard); 
                                currentCard = playedCard;
                            } else {
                                System.out.print("Invalid Card");
                                index = -1;
                            }
                            
                        } else if (index == -2) {
                            index = 1;
                        }

                    } while (index > numCards || index < 0) ; 
                    
                    //roundOn = false;
                }
                
                if (players[currentPlayerNum].getCardListLength() == 0){
                    System.out.print("\033[H\033[2J");  
                    roundOn = false; 
                    break;
                }
                currentPlayerNum++;  
            }

            currentPlayerNum = 0; 
            roundNum++;
            System.out.print("\033[H\033[2J"); 
            System.out.println("\n\nRound is completed: " + (roundNum + 1)); 

            //roundOn = false;
        }

    } 

    public boolean validSelectedCard( String playedCard, String[] splitCurrent ) {
        String[] splitPlayed = playedCard.split("\\s");  

        if (splitPlayed[0].equals(splitCurrent[0]) || splitPlayed[1].equals(splitCurrent[1])) { 
            
            return true;
        } else {
            return false;
        }
        
    } 

    public void countScore () {
        for (int i = 0; i < numPlayers; ++i) { 
            int playerScore = players[i].getFinalScore();

            System.out.print("\nFinal score for " + players[i].getPlayerName() + ": " + playerScore);
        }
    }


}

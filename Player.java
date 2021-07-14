package crazy8; 
import java.util.*;

public class Player { 
    private int playerNum;
    private String playerName;
    public ArrayList<String> cardList = new ArrayList();

    public Player (int y) {
        //System.out.print("I am player" + y);
    } 

    public void setPlayerDetails (Scanner input, int y) {
        playerNum = y;

        System.out.print("\nPlease enter your name player" + (y+1) + ": ");
        playerName = input.nextLine();
    } 

    public void setPlayerDeck (String deckCard) {
        cardList.add("" + deckCard);
        //System.out.println(cardList);
    } 

    public void displayPlayerDeck () {
        System.out.println(cardList);
    }
}
package crazy8; 

import java.util.*;
import java.util.ArrayList;

public class Player { 
    static Scanner input = new Scanner(System.in);  

    private int playerNum;
    private String playerName;
    private ArrayList<String> cardList = new ArrayList<>();

    public Player ( int y) {
        playerNum = y;
        y = playerNum;

        System.out.print("Please enter your name player" + (y+1) + ": ");
        playerName = input.nextLine();
    }    

    public void setPlayerDeck (String deckCard) {
        cardList.add("" + deckCard);
        //System.out.println(cardList);
    }  

    public void displayPlayerDeck () {
        System.out.println(cardList);
    } 

    public String getPlayerName() {
        return playerName;
    }  

    public int getCardListLength() {
        return cardList.size();
    }  

    public String getPlayedCard(String cardSuit, String cardNum) {
        int index = 0;

        for (String s: cardList) { 
            String[] splitCard = s.split("\\s"); 

            if ( splitCard[0].equals(cardSuit) || splitCard[1].equals(cardNum) ) { 
                cardList.remove(index);
                return s;  
            }

            //System.out.println(splitCard[0].equals(cardSuit));
            
            index++;
        }
 
        return "noCard";
    } 

    public String getSelectCard(int index) {
        return cardList.get(index);
    } 

    public void addSelectedCard(String newCard){
        cardList.add(newCard);
    }

    public void deleteSelectedCard(int index) {
        cardList.remove(index);
    } 

    public int getFinalScore() {

        int finalScore = 0;

        if (cardList.size() > 0) { 
            for (String s: cardList) { 
                String[] splitCard = s.split("\\s"); 
                
                finalScore += Integer.parseInt(splitCard[1]);
            } 

            return finalScore;
        } else {
            return 0;
        }
    }

}

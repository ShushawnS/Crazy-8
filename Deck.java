package crazy8;

//import java.util.ArrayList;
import java.util.*;
import java.lang.Math;

public class Deck {

   final int TOTAL_CARDS = 52; 
   public ArrayList<ArrayList<String>> deckList = new ArrayList<>();
   //public static double random( );  

   public Deck () {
    int x = 0;

    ArrayList<String> heartsList = new ArrayList<>();
    ArrayList<String> spadesList = new ArrayList<>(); 
    ArrayList<String> diamondsList = new ArrayList<>(); 
    ArrayList<String> clubsList = new ArrayList<>(); 

    //creates deck
    for (x = 1; x < 13; ++x) {
      //if (x > 1 && x < 9) {
         heartsList.add("H "+ x); 
         spadesList.add("S "+ x); 
         diamondsList.add("D "+ x); 
         clubsList.add("C "+ x);
      //}
      
    }

    deckList.add(heartsList);
    deckList.add(spadesList);
    deckList.add(diamondsList);
    deckList.add(clubsList); 

    //System.out.println(deckList); 
   } 

   public String getCard() { 
      Collections.shuffle(deckList);
      
      int listSize = deckList.get(0).size();
      int min = 0;  
      int max = listSize-1; 
      
      int index = (int)(Math.random()*(max-min+1)+min); 
      String chosenCard = deckList.get(0).get(index);
      deckList.get(0).remove(index);

      return chosenCard;
   }

   public void displayDeck() {
      System.out.println(deckList); 
   }

}

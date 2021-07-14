package crazy8;

public class Deck {

   final int TOTAL_CARDS = 52; 
   String[][] cards = new String[4][12]; 

   
   public Deck () {
    System.out.print(TOTAL_CARDS); 
    cards[0] = "Hearts";
    System.out.print(cards[0]);

      
   }  

}

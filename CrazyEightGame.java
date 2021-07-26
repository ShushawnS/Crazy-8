package crazy8;
import java.util.*;

public class CrazyEightGame {
    public static void main (String[] args) {
        Game Crazy8 = new Game(); 

        Crazy8.initalizeGameDetails();  
        Crazy8.playGame();
        Crazy8.countScore();
    } 
}
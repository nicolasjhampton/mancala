import com.mancala.models.Cup;
import com.mancala.models.CupBoard;
import com.mancala.models.Mancala;
import java.io.*;
import java.util.*;


public class Game {
    
    public static void main(String[] args) {
    String number = null;
    boolean player = true;
    Console prompt = null;
    Mancala game = new Mancala();
    
       // public int makeMove(boolean player, int index) {
       System.out.printf("%s", game.getBoard().getBoard());
       number = prompt.readLine("What cup:  ");
       game.chooseCup(Integer.parseInt(number));
        do{
            game.getNextCup();
            game.settleCup(player);
        } while(game.getBeadsInHand() > 0);
       System.out.printf("%s", game.getBoard().getBoard());
        
    }
}
           
       
import java.io.*;
import java.util.*;
import java.lang.*;


public class Game {
    
    public static void main(String[] args) throws InterruptedException {
    String number;
    boolean player = true;
    Console prompt = System.console();
    Mancala game = new Mancala();
    
       // public int makeMove(boolean player, int index) {
       System.out.printf("%s", game.getBoard().getBoard());
       number = prompt.readLine("What cup:  ");
       game.chooseCup(Integer.parseInt(number));
        do{
            game.getNextCup();
            game.settleCup(player);
            System.out.printf("%s", game.getBoard().getBoard());
            Thread.sleep(4000);
        } while(game.getBeadsInHand() > 0);
    System.exit(0);
        
    }
}
           
       
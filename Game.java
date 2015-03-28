import java.io.*;
import java.util.*;
import java.lang.*;
import com.mancala.models.*;

// When constructor is created, member variables will go here
// We'll demote the Game class from run class status once the console
// version is complete


public class Game {
    
    public static void main(String[] args) throws InterruptedException, IOException {
    //    public Game() {
    //    ^^ code commented out in preparation for making this
    //    a constructor for the "Game" class.
    String mStartCup;
    boolean mPlayer = true;
    Console prompt = System.console();
    Mancala game = new Mancala();
    
       // public int makeMove(boolean player, int index) {
       // ^^ Code commented out in preperation for making this 
       //    a "makeMove" function.
       
       //  Prints (returns) the board at the start of the move  
       System.out.printf("%s", game.getBoard().getBoard());
       // asks for a move (this will be limited to 1-6)
       mStartCup = prompt.readLine("What cup:  ");
       // grabs the chosen cups beads
       game.chooseCup(Integer.parseInt(mStartCup));
       // moves down the board, printing (returning) each move 
        do{
            game.getNextCup();
            game.settleCup();
            System.out.print("\033[H\033[2J"); 
            System.out.printf("%s", game.getBoard().getBoard());
            Thread.sleep(1000);
        // until all the beads are gone
        } while(game.getBeadsInHand() > 0);
        game.endTurn();
        System.out.printf("%s", game.getBoard().getBoard());
    // temporary program exit
    System.exit(0);
        
    }
}
           
       
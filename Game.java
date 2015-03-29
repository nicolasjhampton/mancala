import java.io.*;
import java.util.*;
import java.lang.*;
import com.mancala.models.*;

// When constructor is created, member variables will go here
// We'll demote the Game class from run class status once the console
// version is complete


public class Game {
    
    public static void main(String[] args) throws IOException {
    
    //public Game()  {
    //    ^^ code commented out in preparation for making this
    //    a constructor for the "Game" class.
    String mStartCup;
    boolean mPlayer = true;
    Console prompt = System.console();
    Mancala game = new Mancala();
    int index = 0;
    
    
       
       
       //  Prints (returns) the board at the start of the move  
       System.out.printf("%s", game.getBoard().getBoard());
       // asks for a move (this will be limited to 1-6)
    do {
        do {
            mStartCup = prompt.readLine("Choose a cup 1 - 6:  ");
            index = Integer.parseInt(mStartCup);
        } while (index > 6 || index < 0);
       
        try{
            game.makeMove(index);
        } catch (InterruptedException ie) {
            System.out.println("Something has interrupted the wait: %n");
            ie.printStackTrace();
        }
        
     } while (index != 0);   
           
       
       
    // temporary program exit
    System.exit(0);
        
    
}
           
}       
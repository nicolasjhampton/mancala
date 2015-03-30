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
    String mPlayer;
    Console prompt = System.console();
    Mancala game = new Mancala();
    int index = 0;
    
    
       
       
       //  Prints (returns) the board at the start of the move  
       System.out.printf("%s", game.getBoard().getBoard());
       // asks for a move (this will be limited to 1-6)
    do {
        // determine whose turn it is and return the name
        // ToDo: customize the player name output
        if(game.getPlayer()) {
            mPlayer = "Player 1";
        } else {
            mPlayer = "Player 2";
        }
        System.out.println("%s, it's your turn...%n", mPlayer);
            
            // start the turn, reject bad choices
            do {
            
                mStartCup = prompt.readLine("Choose a cup 1 - 6:  ");
                index = Integer.parseInt(mStartCup);
            } while (index > 6 || index < 0);
       
            try{
                // run the results of the turn
                game.makeMove(index);
            } catch (InterruptedException ie) {
                // catch any interruption error with the Thread 
                System.out.println("Something has interrupted the wait: %n");
                ie.printStackTrace();
            }
        
     } while (index != 0);   
           
       
       
    // temporary program exit
    System.exit(0);
        
    
}
           
}       
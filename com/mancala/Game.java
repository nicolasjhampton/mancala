package com.mancala;

import java.io.*;
import java.util.*;
import java.lang.*;
import com.mancala.models.*;

// When constructor is created, member variables will go here
// We'll demote the Game class from run class status once the console
// version is complete



public class Game {




    public static void main(String[] args)
            throws IOException, InterruptedException {

        //public Game()  {
        //    ^^ code commented out in preparation for making this
        //    a constructor for the "Game" class.
        String mStartCup;
        String mPlayer;
        // Change this to console if needed later outside of the IDE
        BufferedReader prompt = new BufferedReader(new InputStreamReader(System.in));
        // Scanner prompt = new Scanner(System.in);
        // Console prompt = System.console();
        Mancala game = new Mancala();
        int mIndex = 0;




        //  Prints (returns) the board at the start of the move
        game.printResult();
        // asks for a move (this will be limited to 1-6)
        do {
            // determine whose turn it is and return the name
            // ToDo: customize the player name output
            if(game.getPlayer()) {
                mPlayer = "Player 1";
            } else {
                mPlayer = "Player 2";
            }
            System.out.printf("%s, it's your turn...%n", mPlayer);

            // start the turn, reject bad choices
            do {
                // change this back to console later if needed per line 27
                System.out.println("Choose a cup 1 - 6:  ");
                mStartCup = prompt.readLine();
                mIndex = Integer.parseInt(mStartCup);
            } while (mIndex > 6 || mIndex < 0);

            try{
                // run the results of the turn
                game.makeMove(mIndex);
            } catch (InterruptedException ie) {
                // catch any interruption error with the Thread
                System.out.println("Something has interrupted the wait: %n");
                ie.printStackTrace();
            }

        } while (mIndex != 0 && game.winOrLose() == 0);

        System.out.println(game.getBoard().getCup(0).toString());
        System.out.println(game.getBoard().getCup(7).toString());

        if(game.winOrLose() == 1) {
            System.out.println("Player 1 wins!");
        }

        if(game.winOrLose() == -1) {
            System.out.println("Player 2 wins!");
        }



        // temporary program exit
        System.exit(0);


    }

}
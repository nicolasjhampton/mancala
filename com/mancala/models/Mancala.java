package com.mancala.models;

public class Mancala {
    // True is 1st player, false is second player
    private boolean mPlayer;
    private CupBoard mBoard;
    
    public Mancala(boolean player) {
        
        mPlayer = player;
        mBoard = new CupBoard();
    }
  
    public CupBoard getBoard() {
      return mBoard;
    }
  
  
    
    // a player chooses a cup and makes a move
    public void makeMove(boolean player, int index) {
        // get the cup
        Cup cup = mBoard.getCup(index);
        // take the beads from the cup
        int beads = cup.takeBeads();
        do {
            // move to the next cup
            index++;
            // zero the index to loop around the board
            if(index >= 14) {
              index = 0;
            }
            // grab the next cup
            cup = mBoard.getCup(index);
            // if this is the opponent's home cup
            if(cup.isHome() == true && player != cup.isFirstPlayer()) {
            // do nothing and skip the home
            } else {
    
               if(beads == 1 && cup.getBeads() >= 1 && cup.isHome() == false) {
               // take any beads in the cup if it's the last cup and continue
               beads += cup.takeBeads();
               } else {
               // else drop a bead in the cup
               beads--;
               cup.addBeads(1);
               }
            }
        // loop until your out of beads
        } while (beads > 0);
    }
  
  
}


    
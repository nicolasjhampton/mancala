package com.mancala.models;

public class Mancala {
    
    private boolean mPlayer1;
    private boolean mPlayer2;
    private CupBoard mBoard;
    
    public Mancala() {
        
        mPlayer1 = true;
        mPlayer2 = false;
        mBoard = new CupBoard();
    }
  
    public CupBoard getBoard() {
      return mBoard;
    }
    
    // a player chooses a cup and makes a move
    public void makeMove(boolean player, int index) {
        // get the cup
        Cup cup = mBoard.findCup(index);
        // take the beads from the cup
        int beads = cup.takeBeads();
        do {
            // move to the next cup
            index++;
            cup = mBoard.findCup(index);
            // if this is the opponent's home cup
            if(cup.isHome() == true && player != cup.isFirstPlayer()) {
              // do nothing and skip the home
            } else {
               // else drop a bead in the cup
               cup.addBeads(1);
               beads--;
               }
            // loop until your out of beads
        } while (beads > 0);
    }
}


    
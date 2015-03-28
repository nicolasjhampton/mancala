package com.mancala.models;

public class Mancala {
    // True is 1st player, false is second player
    private CupBoard mBoard;
    private int mIndex;
    private int mBeads;
    private Cup mCup;
    
    public Mancala() {
        mIndex = 1;
        mBeads = 0;
        mCup = new Cup(0);
        mBoard = new CupBoard();
    }
  
    public CupBoard getBoard() {
      return mBoard;
    }
    
    public int getBeadsInHand() {
        return mBeads;
    }
    
    public void chooseCup(int index) {
        // Store the current index
        mIndex = index;
        // get the cup
        mCup = mBoard.getCup(mIndex);
        // take the beads from the current cup
        mBeads = mCup.takeBeads();
            
    }
    
    public void getNextCup() {
            // move to the next cup
            mIndex++;
            // loop to the beginning of the board
            if(mIndex >= 14) {
              mIndex = 0;
            }
            // grab the next cup
            mCup = mBoard.getCup(mIndex);
    }
    
    public void settleCup(boolean player) {
         if(mCup.isHome() == true && player != mCup.isFirstPlayer()) {
            // do nothing and skip the home
            } else {
    
               if(mBeads == 1 && mCup.getBeads() >= 1 && mCup.isHome() == false) {
               // take any beads in the cup if it's the last cup and continue
               mBeads += mCup.takeBeads();
               } else {
               // else drop a bead in the cup
               mBeads--;
               mCup.addBeads(1);
               }
            }
    }
        
    
  
  
}


    
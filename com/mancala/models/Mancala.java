package com.mancala.models;

public class Mancala {
    
    // member variables
    private CupBoard mBoard;
    private int mIndex;
    private int mBeads;
    private Cup mCup;
    private boolean mPlayer;
    
    // constructor
    public Mancala() {
        mIndex = 1;
        mBeads = 0;
        mCup = new Cup(0);
        mBoard = new CupBoard();
        mPlayer = true;
    }
    
    // getters
    public CupBoard getBoard() {
      return mBoard;
    }
    
    public int getBeadsInHand() {
        return mBeads;
    }
    
    public boolean getPlayer() {
        return mPlayer;
    }
    
    // switch the player currently accessing the game
    public void switchPlayer() {
        mPlayer = !mPlayer;
    }
    
    // gameplay methods
    
    // Step 1: method to choose the first cup to take your turn
    public void chooseCup(int index) {
        // ToDo: need to limit the cup chosen to the cups
        //       available for that player.
        if(mPlayer) {
        // Store the current index
        mIndex = index;
        } else {
        mIndex = index + 7;
        }
        // get the cup
        mCup = mBoard.getCup(mIndex);
        // take the beads from the current cup
        if(!mCup.isHome()) {
        mBeads = mCup.takeBeads();
        }    
    }
    
    // Step 2: method to move to and capture the next cup
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
    
    // Step 3: method to add or take beads from each cup
    public void settleCup() {
        // ToDo: Needs to switch between settle rules for player 1 and 
        //       player 2 based on player member variable.
        //       
        //       also need to limit the cascade affect of the move
        //       so that you can only continue your turn if you're on your 
        //       side.
        
         if(mCup.isHome() == true &&
            mPlayer != mCup.isFirstPlayer()) {
            // do nothing and skip the home
            } else {
    
               if(mBeads == 1 && 
                  mCup.getBeads() >= 1 && 
                  mCup.isHome() == false &&
                  mPlayer == mCup.isFirstPlayer()) {
               // take any beads in the cup if it's the last cup and continue
               mBeads += mCup.takeBeads();
               } else {
               // else drop a bead in the cup
               mBeads--;
               mCup.addBeads(1);
               }
            }
    }
    
    // Step 4: Check for beads in opposite cup
    //         at the end of a turn, then take 
    //         those beads and transfer
    //         them into the last cup if present,
    //         then switch the player.
    public void endTurn() {
        if(mCup.isFirstPlayer() == mPlayer &&
           mCup.isHome() == false) {
            
            if (mCup.isFirstPlayer()) {

                chooseCup(mIndex + 7);
                mIndex -= 7;
                
            } else {
                
                chooseCup(mIndex - 7);
                mIndex += 7;
                
            }
            int beads = getBeadsInHand();
            mCup = mBoard.getCup(mIndex);
            mCup.addBeads(beads);
            switchPlayer();
        }
            
      }
    
    // Combines steps 1 through 4 into a single turn
    public void makeMove(int index) throws InterruptedException {
       // ^^ Code commented out in preperation for making this 
       //    a "makeMove" function.
       // grabs the chosen cups beads
       chooseCup(index);
        if(index == 0) {
            // do nothing
        } else {
       // moves down the board, printing (returning) each move 
        do{
            getNextCup();
            settleCup();
            System.out.print("\033[H\033[2J"); 
            System.out.printf("%s", getBoard().getBoard());
            Thread.sleep(1000);
        // until all the beads are gone
        } while(getBeadsInHand() > 0);
        endTurn();
        }
        System.out.printf("%s", getBoard().getBoard());
    }
    
    
    // ToDo: Need a method to check if the game is over at the end of a turn
    //       AKA all the cups on one side are empty.
        
    
  
  
}


    
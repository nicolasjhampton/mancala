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
         // if this is the other player's home cup
         if(mCup.isHome() == true &&
            mPlayer != mCup.isFirstPlayer()) {
            // do nothing and skip the home
            } else {
                  // if this is your last bead 
               if(mBeads == 1 && 
                  // AND there's beads already in the cup
                  mCup.getBeads() >= 1 && 
                  // AND this isn't a home cup
                  mCup.isHome() == false &&
                  // AND this is your home side...
                  mPlayer == mCup.isFirstPlayer()) {
                    // take any beads in the cup if it's the last cup
                    // and continue
                    mBeads += mCup.takeBeads();
               } else {
               // else take a bead from your hand 
               mBeads--;
               // and put it in the cup
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
        // if the cup is on the player's home side
        // and not the home cup. We can assume, as a rule of the game,
        // that the last cup only has one bead in it, no need to check
        // twice.
        
        // test to make sure this isn't a home cup 
        // and that the cup is on the player's side
        if(mCup.isFirstPlayer() == mPlayer &&
           mCup.isHome() == false) {
            // different index algorithm for cups 1 through 6
            // and 8 - 12.
            if (mCup.isFirstPlayer()) {
                // get the cup on the opposite side of the cup for 1st player
                chooseCup(mIndex + (2*(7 - mIndex)));
                
                
            } else {
                // get the cup on the opposite side of the cup for 2nd player
                chooseCup(mIndex - (2*(mIndex - 7)));
                
                
            }
            // take the beads from the opposite side of the board
            int beads = getBeadsInHand();
            // go back to the cup we ended on
            mCup = mBoard.getCup(mIndex);
            // put them in the cup we ended on
            mCup.addBeads(beads);
            
        }
         switchPlayer();   
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
            // clears the previous move from the screen
            System.out.print("\033[H\033[2J"); 
            // print the new move
            System.out.printf("%s", getBoard().getBoard());
            // wait a second
            Thread.sleep(1000);
        // until all the beads are gone
        } while(getBeadsInHand() > 0);
        endTurn();
        }
        // clears the last move
        System.out.print("\033[H\033[2J"); 
        // displays final outcome
        System.out.printf("%s", getBoard().getBoard());
    }
    
    
    // ToDo: Need a method to check if the game is over at the end of a turn
    //       AKA all the cups on one side are empty.
        
    
  
  
}


    
package com.mancala.models;

public class Cup {
  
  // member variables
  private int mBeads;
  private int mIndex;
  private boolean mIsHome;
  private boolean mPlayer;
  
  // constructor
  public Cup(int index) {
    mIndex = index;
    
    // filling in cups, declaring home
    if(mIndex == 0 || mIndex == 7) {
      mBeads = 0;
      mIsHome = true;
      } else {
      mBeads = 4;
      mIsHome = false;
      }
    
    // setting cups for each player
    if(mIndex < 7) {
      mPlayer = true;
      } else {
      mPlayer = false;
      }
    
  }
  
    // getters
    public int getBeads() {
      return mBeads;
    }
    
    public int getIndex() {
      return mIndex;
    }
    
    public boolean isHome() {
      return mIsHome;
    }
    
    public boolean isFirstPlayer() {
      return mPlayer;
    }
  
  	 // For regular cups, we want to add one bead to the cup.
  	 // The game dictates only one bead can be added at a time.
  	 
	 public void addBeads(int beads) {
     // add the beads to the cup
     mBeads += beads;
    }
  
  	 // When you take beads, one of three things are happening:
  	 // 1. Either you're making your first move
  	 // 2. You've dropped your last marble in a cup with more
  	 // 3. The cup on the opposite side of your last marble drop
  	 //    has more beads, and your last drop was on your side.
  	 
  	 public int takeBeads() {
      int beads = mBeads;
      mBeads = 0;
      return beads;
    }
  	 
    
    	@Override
    	public String toString() {
      
        //declare variables of limited scope for conversion

        int player;
        int relativeIndex;

        // creating a numberical expression of player
        // and a relative position for the index

        if (mPlayer) {
          player = 1;
          relativeIndex = mIndex;
        } else {
          player = 2;
          relativeIndex = mIndex - 7;
        }

        // test for home cup, then return expression

        if(mIsHome) {
          // home expression
          return String.format("Player %d has %d beads home! %n", player, mBeads);
        } else {
          // cup expression
          return String.format("Cup %d on player %d's side has %d beads %n",
                                relativeIndex, player, mBeads);
        }

      }
}
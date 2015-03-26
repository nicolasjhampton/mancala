package com.mancala.models;

import java.util.Queue;
import java.util.ArrayDeque;


public class CupBoard {
 
  // member variables
  Queue<Cup> mCupBoard;
 
  
  // constructor
  public CupBoard() {
    
    // creating the board
    mCupBoard = new ArrayDeque<Cup>();  

   // filling in all the cups
    for(int index = 0 ; index < 14 ; index++) {
        mCupBoard.add(new Cup(index));
      }
    
  }
  
  // return the board
  public Queue<Cup> getBoard() {
    return mCupBoard;
  }
 
   public Cup findCup(int index) {
     // initialize the return cup (if the cup can't be found, it returns cup -1 for player one)
     Cup checkCup = new Cup(-1);
     // cycle thru each cup in the board
      for(Cup cup : mCupBoard) {
        // store the cup into checkCup 
        checkCup = cup;
        // if the cup is the right cup, break the for loop
        if(index == cup.getIndex()) { 
          break;
        }
      }
     // return the cup, whick can now be maniplated
     return checkCup;   
    }
}
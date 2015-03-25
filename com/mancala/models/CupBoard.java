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
}
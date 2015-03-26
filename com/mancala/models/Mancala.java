package com.mancala.models;

public class Mancala {
    
    private String mPlayer1;
    private String mPlayer2;
    private CupBoard mBoard;
    
    public Mancala(String player1, String player2) {
        
        mPlayer1 = player1;
        mPlayer2 = player2;
        mBoard = new CupBoard();
    }
    
    public makeMove(int index) {
        Cup cup = mBoard.findCup(index);
        int beads = cup.takeBeads();
        do {
            index++;
            mBoard.findCup(index).addBeads(1);
        } while (beads ; beads > 0 ; beads--);
    }
    
    
    
}
            
        
        
        
        
        
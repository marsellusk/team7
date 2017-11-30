package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    int Mode;

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public String error;

    public int score;

    public Deck deck1 = new Deck();

    public User user1 = new User();

    public Game(){
		//uses the col member in Game class so that each column can store maximum number of cards it may have to store
		for(int i = 0; i < 4; i++){
            cols.add(new ArrayList<Card>(12));
        }
        score = 0;
    }



    public void set_mode(int mode) {
        Mode = mode;
    }


    public boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(cols.get(columnNumber).size() > 0){
            return true;
        }
        else {
            return false;
        }

    }

    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}

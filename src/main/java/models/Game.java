package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public String error;

    public int score = 0;

    public Game(){
		//uses the col member in Game class so that each column can store maximum number of cards it may have to store
		for(int i = 0; i < 4; i++){
            cols.add(new ArrayList<Card>(12));
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
	for (int j=0;j<52;j++){
		int n;
		Card temp;
		Random rand = new Random();
		n = rand.nextInt(52);
		temp = deck.get(n);
		deck.set(n,deck.get(deck.size() - 1));
		deck.set(deck.size() - 1,temp);
	}/*End for loop*/
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
             for(int i = 0; i < 4;i++){
           addCardToCol(i,deck.get(deck.size() - 1));
           deck.remove(deck.size() - 1);
     }
	error=" "; 
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        boolean check = columnHasCards(columnNumber); //Make sure removal column has cards
        Card c1 = getTopCard(columnNumber);           //Then get the card to be removed from that column
        error = "cant remove the column";
        int value1 = c1.getValue();                   //get the value of that card to compare later
        if (check){
            for (int i = 0; i < 4; i++){              //if the column has cards loop to a different column to compare cards
                if(columnNumber != i){

                    while(columnHasCards(i) == false) {     //if the next column doesn't have cards move one to the next one
                        i++;
                    }
                }

                Card c2 = getTopCard(i);                //get the card we are comparing the removal card to and its value
                int value2 = c2.getValue();

                if(c1.getSuit().toString() == c2.getSuit().toString() && value1 < value2){
                    removeCardFromCol(columnNumber);//if the card matches suit and is larger then the removal card remove it and exit the loop
                    score++;
                    error = " ";
                    break;
                }
            }
        }


    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(cols.get(columnNumber).size() > 0){
            return true;
        }
        else {
            return false;
        }        

    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }



    public void move(int columnNumber) {
        // remove the top card from the columnFrom column, add it to an empty column
        int emptyColumn = 5;
        int i = 0;
        while ((emptyColumn == 5) || (i < 4)) {
            if (columnHasCards(i) == false) {
                emptyColumn = i;
            }
            i++;
        }
        if((emptyColumn != 5) && columnHasCards(columnNumber)){
            Card cardToMove = this.cols.get(columnNumber).get(cols.get(columnNumber).size() - 1);
            removeCardFromCol(columnNumber);
            addCardToCol(emptyColumn,cardToMove);
        }
        else {
            error = " You cannot move this column because it is empty or there are no empty columns";
        }
    }


    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}

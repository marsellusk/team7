package models;

public class User {
    public int score = 0;
    public int times_dealt = 0;
    public void remove(int columnNumber, Game g, int mode) {
        // remove the top card from the indicated column
        boolean check = g.columnHasCards(columnNumber); //Make sure removal column has cards
        Card c1 = g.getTopCard(columnNumber);           //Then get the card to be removed from that column
        g.error = "Can't remove the column!";
        int value1 = c1.getValue();                   //get the value of that card to compare later
        if (check){
            for (int i = 0; i < 4; i++){              //if the column has cards loop to a different column to compare cards
                if(columnNumber != i){
                    while(g.columnHasCards(i) == false){     //if the next column doesn't have cards move one to the next one
                        i++;
                    }/*End while loop*/
                }/*End if statement*/
                    Card c2 = g.getTopCard(i);                //get the card we are comparing the removal card to and its value
                    int value2 = c2.getValue();
                if(mode == 1) {                                 //For normal card game mode
                    if (c1.getSuit().toString() == c2.getSuit().toString() && value1 < value2) {
                        g.removeCardFromCol(columnNumber);//if the card matches suit and is larger then the removal card remove it and exit the loop
                        g.score++;
                        g.error = "Remove successfully!";
                        break;
                    }/*End if statement*/
                }/*End if statement*/
                else{                                           //For Spanish deck game mode

                    if (c1.getSuit().toString() == c2.getSuit().toString() && value1 < value2) {
                        g.removeCardFromCol(columnNumber);//if the card matches suit and is larger then the removal card remove it and exit the loop
                        g.score++;
                        g.error = "Remove successfully!";
                        break;
                    }/*End if statement*/
                    if(c1.getSuit().toString() != "Joker" && c2.getSuit().toString() == "Joker"){

                        g.removeCardFromCol(columnNumber);
                        g.removeCardFromCol(i);
                        g.score += 2;
                        g.error = "You remove the Joker!";
                        break;
                    }/*End if statement*/

                }/*End else statement*/
            }
        }
    }

    public void move(int columnNumber, Game g, int mode) {
        g.error = "You cannot move this column";
        int emptyColumn = 5;
        int i = 0;
        while ((emptyColumn == 5) && (i < 4)) {
            if (g.columnHasCards(i) == false) {
                emptyColumn = i;
            }/*End if loop*/
            i++;
        }/*End while loop*/
        if(emptyColumn == 5)
            g.error = "No empty column";
        else{
            Card cardToMove = g.cols.get(columnNumber).get(g.cols.get(columnNumber).size() - 1);
            if (mode == 1 && cardToMove.getValue() == 14) {
                g.removeCardFromCol(columnNumber);
                g.addCardToCol(emptyColumn, cardToMove);
                g.error = "Move successfully";
            }
            else if(mode == 2 && cardToMove.getValue() == 13){
                g.removeCardFromCol(columnNumber);
                g.addCardToCol(emptyColumn, cardToMove);
                g.error = "Move successfully";
            }
            else {
                g.error = "Card is not an Ace";
            }
        }

    }

    public void dealfour(Game g, int mode) {
    if(mode == 1) {
        for (int i = 0; i < 4; i++) {
            g.addCardToCol(i, g.deck1.deck.get(g.deck1.deck.size() - 1));
            g.deck1.deck.remove(g.deck1.deck.size() - 1);
        }
        times_dealt++;
        g.error = " ";
    }/*End if statement*/
    else if (mode == 2){
        if (times_dealt < 12) {
            for (int i = 0; i < 4; i++) {
                g.addCardToCol(i, g.deck2.deck2.get(g.deck2.deck2.size() - 1));
                g.deck2.deck2.remove(g.deck2.deck2.size() - 1);
            }
            times_dealt += 1;
        }else if (times_dealt == 12) {
        for (int i = 0; i < 2; i++) {
            g.addCardToCol(i, g.deck2.deck2.get(g.deck2.deck2.size() - 1));
            g.deck2.deck2.remove(g.deck2.deck2.size() - 1);
        }
    }
    g.error = " ";
}

    }/*End else statement*/
    }

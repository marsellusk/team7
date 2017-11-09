package models;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
//public java.util.List<Card> deck = new ArrayList<>();

public class Deck{
  public java.util.List<Card> deck = new ArrayList<>();
  public final int value;

  public Deck() {
   value = 52;
    for(int i = 2; i < 15; i++){
        deck.add(new Card(i,Suit.Clubs));
        deck.add(new Card(i,Suit.Hearts));
        deck.add(new Card(i,Suit.Diamonds));
        deck.add(new Card(i,Suit.Spades));
    }
}

 public void shuffle(){
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


 public int size(){
   return deck.size();
 }

}

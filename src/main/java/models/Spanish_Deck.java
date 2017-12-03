package models;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
//public java.util.List<Card> deck = new ArrayList<>();

public class Spanish_Deck {
    public java.util.List<Card> deck2 = new ArrayList<>();
    public final int value;

    public Spanish_Deck() {
        value = 50;
        for(int i = 2; i < 14; i++){
            deck2.add(new Card(i,Suit.Bastos));
            deck2.add(new Card(i,Suit.Copas));
            deck2.add(new Card(i,Suit.Oros));
            deck2.add(new Card(i,Suit.Espadas));
        }
        //ADD JOKER HERE
        deck2.add(new Card(14, Suit.Joker));
        deck2.add(new Card(14, Suit.Joker));
    }

    public void shuffle(){
        // shuffles the deck so that it is random
        for (int j=0;j<50;j++){
            int n;
            Card temp;
            Random rand = new Random();
            n = rand.nextInt(50);
            temp = deck2.get(n);
            deck2.set(n,deck2.get(deck2.size() - 1));
            deck2.set(deck2.size() - 1,temp);
        }/*End for loop*/
    }


    public int size(){
        return deck2.size();
    }

}

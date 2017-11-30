package models;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
//public java.util.List<Card> deck = new ArrayList<>();

public class Deck1{
    public java.util.List<Card> deck1 = new ArrayList<>();
    public final int value;

    public Deck1() {
        value = 50;
        for(int i = 2; i < 14; i++){
            deck1.add(new Card(i,Suit_Spanish.Bastos));
            deck1.add(new Card(i,Suit_Spanish.Copas));
            deck1.add(new Card(i,Suit_Spanish.Oros));
            deck1.add(new Card(i,Suit_Spanish.Espadas));
        }
        //ADD JOKER HERE
        deck1.add(new Card(49, Suit_Spanish.Joker1));
        deck1.add(new Card(50, Suit_Spanish.Joker2));
    }

    public void shuffle(){
        // shuffles the deck so that it is random
        for (int j=0;j<50;j++){
            int n;
            Card temp;
            Random rand = new Random();
            n = rand.nextInt(50);
            temp = deck1.get(n);
            deck1.set(n,deck1.get(deck1.size() - 1));
            deck1.set(deck1.size() - 1,temp);
        }/*End for loop*/
    }


    public int size(){
        return deck1.size();
    }

}

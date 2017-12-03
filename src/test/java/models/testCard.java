
package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals(Suit.Clubs,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs);
        //cardsuit
        assertEquals("5Clubs",c.toString(1));
    }

    @Test
    public void testCardMode(){
        Card c = new Card(5,Suit.Clubs);
        Card c2 = new Card(14,Suit.Clubs);

        //cardsuit
        assertEquals(5,c.getValue());
        assertEquals("Clubs",c2.toString(2));
        assertEquals("5Clubs",c.toString(2));

    }




}
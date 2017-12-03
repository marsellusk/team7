
package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testDeck {
    @Test
    public void testGetDeck(){

        Deck deck1 = new Deck();
        deck1.shuffle();
        assertEquals(deck1.size(),52);

    }


}
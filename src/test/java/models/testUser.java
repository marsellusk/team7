package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testUser {
    @Test
    public void testRemove(){
        Game g = new Game();
        g.set_mode(1);
        Card c1 = new Card(5,Suit.Clubs);
        Card c2 = new Card(6,Suit.Clubs);
        Card c3 = new Card(5,Suit.Hearts);
        Card c4 = new Card(5,Suit.Spades);

        g.addCardToCol(0, c1);
        g.addCardToCol(1, c2);
        g.addCardToCol(2, c3);
        g.addCardToCol(3, c4);

        assertTrue(g.columnHasCards(0));
        g.user1.remove(0, g, g.Mode);
        assertFalse(g.columnHasCards(0));
        assertTrue(g.columnHasCards(1));
        assertTrue(g.columnHasCards(2));
        assertTrue(g.columnHasCards(3));

        Game g2 = new Game();
        g2.set_mode(2);
        Card s1 = new Card(5,Suit.Oros);
        Card s2 = new Card(6,Suit.Oros);
        Card s3 = new Card(5,Suit.Bastos);
        Card s4 = new Card(5,Suit.Copas);
        Card s5 = new Card(14,Suit.Joker);

        g2.addCardToCol(0, s1);
        g2.addCardToCol(1, s2);
        g2.addCardToCol(2, s3);
        g2.addCardToCol(3, s4);

        assertTrue(g2.columnHasCards(0));
        g2.user1.remove(0, g2, g2.Mode);
        assertFalse(g2.columnHasCards(0));
        assertTrue(g2.columnHasCards(1));
        assertTrue(g2.columnHasCards(2));
        assertTrue(g2.columnHasCards(3));

        g2.addCardToCol(0, s5);

        assertTrue(g2.columnHasCards(0));
        g2.user1.remove(3, g2, g2.Mode);
        assertFalse(g2.columnHasCards(3));
        assertTrue(g2.columnHasCards(1));
        assertTrue(g2.columnHasCards(2));
        assertFalse(g2.columnHasCards(0));

    }

    @Test
    public void testMove(){
        Game g = new Game();
        g.set_mode(1);
        Card c1 = new Card(5,Suit.Clubs);
        Card c2 = new Card(6,Suit.Clubs);
      //  Card c3 = new Card(5,Suit.Hearts);
        Card c4 = new Card(14,Suit.Spades);

        g.addCardToCol(0, c1);
        g.addCardToCol(1, c2);
        //g.addCardToCol(2, c3);
        g.addCardToCol(3, c4);

        assertFalse(g.columnHasCards(2));
        g.user1.move(1, g, g.Mode);
        assertTrue(g.columnHasCards(0));
        assertTrue(g.columnHasCards(1));
        assertFalse(g.columnHasCards(2));
        assertTrue(g.columnHasCards(3));

        assertFalse(g.columnHasCards(2));
        g.user1.move(3, g, g.Mode);
        assertTrue(g.columnHasCards(0));
        assertTrue(g.columnHasCards(1));
        assertTrue(g.columnHasCards(2));
        assertFalse(g.columnHasCards(3));

        Game g2 = new Game();
        g2.set_mode(2);
        Card s1 = new Card(5,Suit.Oros);
        Card s3 = new Card(13,Suit.Bastos);
        Card s4 = new Card(5,Suit.Copas);


        g2.addCardToCol(0, s1);
        g2.addCardToCol(2, s3);
        g2.addCardToCol(3, s4);

        assertFalse(g2.columnHasCards(1));
        g2.user1.move(0, g2, g2.Mode);
        assertTrue(g2.columnHasCards(0));
        assertFalse(g2.columnHasCards(1));
        assertTrue(g2.columnHasCards(2));
        assertTrue(g2.columnHasCards(3));

        assertFalse(g2.columnHasCards(1));
        g2.user1.move(2, g2, g2.Mode);
        assertTrue(g2.columnHasCards(0));
        assertTrue(g2.columnHasCards(1));
        assertFalse(g2.columnHasCards(2));
        assertTrue(g2.columnHasCards(3));



    }



}


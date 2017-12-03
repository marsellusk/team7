package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {


    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        assertEquals(52,g.deck1.size());
    }


    @Test
    public void testGameColumn() {
        Game g = new Game();
        g.set_mode(1);
        assertEquals(1, g.Mode);
        assertEquals(0, g.score);

        assertFalse(g.columnHasCards(0));
        assertFalse(g.columnHasCards(1));
        assertFalse(g.columnHasCards(2));
        assertFalse(g.columnHasCards(3));
        g.user1.dealfour(g, g.Mode);
        assertTrue(g.columnHasCards(0));
        assertTrue(g.columnHasCards(1));
        assertTrue(g.columnHasCards(2));
        assertTrue(g.columnHasCards(3));
    }


    @Test
    public void testSpanishGameColumn() {
        Game g = new Game();
        g.set_mode(2);
        assertEquals(2, g.Mode);
        assertEquals(0, g.score);

        assertFalse(g.columnHasCards(0));
        assertFalse(g.columnHasCards(1));
        assertFalse(g.columnHasCards(2));
        assertFalse(g.columnHasCards(3));
        g.user1.dealfour(g, g.Mode);
        assertTrue(g.columnHasCards(0));
        assertTrue(g.columnHasCards(1));
        assertTrue(g.columnHasCards(2));
        assertTrue(g.columnHasCards(3));
    }
}
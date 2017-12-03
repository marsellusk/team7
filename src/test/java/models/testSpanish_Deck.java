package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class testSpanish_Deck{

  @Test
  public void testGetSpanishDeck(){

    Spanish_Deck deck2 = new Spanish_Deck();
    deck2.shuffle();
    assertEquals(deck2.size(),50);
  }
  
}


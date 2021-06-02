package dev.monopoly.game;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardDeck {

	private ArrayList<BoardCard> deck;
	private int runs;
	
	public BoardDeck(BoardCard[] deck) {
		this.deck = new ArrayList<BoardCard>(Arrays.asList(deck));
	}
	
	public BoardCard drawFromDeck() {
		BoardCard card = deck.get(0);
		deck.remove(0);
		deck.add(card);
		runs++;
		
		if(runs % deck.size() == 0) 
			shuffle();
		
		
		return card;
	}
	
	public void shuffle() {
		
	}
	
	
}

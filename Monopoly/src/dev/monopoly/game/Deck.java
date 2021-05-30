package dev.monopoly.game;

import java.awt.image.BufferedImage;

public class Deck {

	private Card[] usedCards, unusedCards, rawDeck;
	
	public Deck(Card[] unusedCards) {
		this.unusedCards=unusedCards;
		this.rawDeck=unusedCards;
		this.usedCards=new Card[unusedCards.length];
	}
	
	public Card getCard(int index) {
		return unusedCards[index];
	}
	
	public Card[] getRawDeck() {
		return rawDeck;
	}
	
	public BufferedImage[] getRawDeckImages() {
		BufferedImage[] propImages = new BufferedImage[rawDeck.length];
		for(int i=0;i<propImages.length;i++) {
			propImages[i] = rawDeck[i].getFront();
		}
		return propImages;
	}
	
	public void setCardInUse(int index) {
		usedCards[index]=unusedCards[index];
		unusedCards[index]=null;
	}
	
	public boolean cardInUse(int index) {
		if(usedCards[index]==null)
			return false;
		return true;
	}
	
	
}

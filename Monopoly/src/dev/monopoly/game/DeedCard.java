package dev.monopoly.game;

import java.awt.image.BufferedImage;

public class DeedCard extends PropertyCard{

	
	
	public DeedCard(BufferedImage front, String name, int price, int houseCost, int[] rentCost, int x, int y) {
		super(front, name, price, houseCost, rentCost, x, y);
	}

}

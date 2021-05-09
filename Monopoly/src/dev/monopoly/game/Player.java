package dev.monopoly.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> properties; 
	private int money;
	private int x,y;
	private BufferedImage icon;

	public Player(int x, int y, BufferedImage icon, int money) {
		properties = new ArrayList<Card>();
		this.x=x;
		this.y=y;
		this.icon=icon;
		this.money=money;
	}
	
	//Give Money
	public void addMoney(int amount){
		money+=amount;
	}
	
	//Take Away Money
	public void subtractMoney(int amount) {
		money-=amount;
	}
	
	//Adds Property
	public void addProperty(Card property) {
		properties.add(property);
	}
	
	//Remove Property
	public void removeProperty(Card property) {
		properties.remove(property);
	}
	
	/*Trade n Cards for Money
	  [Player out] gives [Player in] [propertyOut] cards for [cost]*/
	public void trade(Player out, Player in, int cost, ArrayList<Card> propertyOut) {
		out.addMoney(cost);
		in.subtractMoney(cost);
		
		for(Card c : propertyOut) {
			out.removeProperty(c);
			in.addProperty(c);
		}
	}

	/*Trade n Cards for n cards
	  [Player out] gives [Player in] [propertyOut] cards for [propertyIn]*/
	public void trade(Player out, Player in, ArrayList<Card> propertyOut, ArrayList<Card> propertyIn) {
		for(Card c : propertyOut) {
			out.removeProperty(c);
			in.addProperty(c);
		}
		for(Card c : propertyIn) {
			in.removeProperty(c);
			out.addProperty(c);
		}
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	//Getters and Setters
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<Card> getProperties() {
		return properties;
	}

	public int getMoney() {
		return money;
	}
	
	
	
}

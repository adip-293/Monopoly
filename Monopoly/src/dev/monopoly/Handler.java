package dev.monopoly;

import dev.monopoly.input.KeyManager;
import dev.monopoly.input.MouseManager;

public class Handler {

	Monopoly game; 
	
	public Handler(Monopoly game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Monopoly getGame() {
		return game;
	}
	
}

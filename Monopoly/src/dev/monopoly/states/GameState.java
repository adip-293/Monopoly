package dev.monopoly.states;

import java.awt.Graphics;

import dev.monopoly.Handler;
import dev.monopoly.ui.UIManager;

public class GameState extends State{
	
	private UIManager uiManager;

	public GameState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
	}
	
	public void update() {
		
	}

	public void render(Graphics g) {	
		uiManager.render(g);
	}

}

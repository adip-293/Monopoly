package dev.monopoly.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.monopoly.Handler;
import dev.monopoly.gfx.Assets;
import dev.monopoly.ui.UIManager;

public class SettingsState extends State{
	
	private UIManager uiManager;
	private int stage;
	
	//Gets Player Count
	//Gets Bot Count
	//Players Choose Pieces
	//
	
	public SettingsState(Handler handler) {
		stage=1;
		this.handler=handler;
		uiManager = new UIManager(handler);
	}

	@Override
	public void update() {
		if(State.getState() == this) {
			handler.getMouseManager().setUIManager(uiManager);
		}
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		g.fillRect(1000, 0, 618, 1000);
		
		g.setColor(new Color(153,204,255));
		g.fillRect(1000,10,608,980);
		
		g.drawImage(Assets.gameBoard, 10, 10, 980, 980,null);
		
		uiManager.render(g);
	}

}

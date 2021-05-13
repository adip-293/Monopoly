package dev.monopoly.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.monopoly.Handler;
import dev.monopoly.gfx.Assets;
import dev.monopoly.ui.Button;
import dev.monopoly.ui.Clickable;
import dev.monopoly.ui.Slideshow;
import dev.monopoly.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
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
		
		g.drawImage(Assets.startScreen, 0, 00, 1618, 1000,null);
		
		uiManager.render(g);
	}

}

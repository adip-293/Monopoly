package dev.monopoly.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.monopoly.Handler;

public class Switch extends UIObject{

	private BufferedImage[] images;
	private Clickable clicker;
	private boolean active;
	
	public Switch(float x, float y, int width, int height,  BufferedImage[] images, boolean active, Clickable clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.active=active;
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		if(!hovering && !active)
			g.drawImage(images[0],(int) x, (int) y , width, height, null);
		else if(hovering && !active)
			g.drawImage(images[1],(int) x, (int) y , width, height, null);
		else if(!hovering && active)
			g.drawImage(images[2],(int) x, (int) y , width, height, null);
		else if(hovering && active)
			g.drawImage(images[3],(int) x, (int) y , width, height, null);
	}

	@Override
	public void onClick() {
		active = !active;
		clicker.onClick();
	}

}

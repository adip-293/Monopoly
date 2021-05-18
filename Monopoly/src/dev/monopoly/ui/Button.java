package dev.monopoly.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button extends UIObject{

	private BufferedImage[] images;
	private Clickable clicker;
	
	public Button(float x, float y, int width, int height, BufferedImage[] images, Clickable clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(images[1],(int) x, (int) y , width, height, null);
		}else {
			g.drawImage(images[0],(int) x, (int) y , width, height, null);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}

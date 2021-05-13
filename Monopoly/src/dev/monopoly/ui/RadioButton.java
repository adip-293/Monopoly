package dev.monopoly.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class RadioButton extends UIObject{

	private Switch[] switches;
	int buttonIndex;
	
	public RadioButton(float x, float y, int width, int height, Switch[] switches) {
		super(x, y, width, height);
		this.switches = switches;
		buttonIndex=0;
	}

	@Override
	public void onMouseMove(MouseEvent e){
		for(int i=0; i<switches.length;i++) {
			if(switches[i].getBounds().contains(e.getX(), e.getY())){
				switches[i].setHovering(true);
			}else
				switches[i].setHovering(false);
			
		}
	}
	
	@Override
	public void onMouseRelease(MouseEvent e){
		for(int i=0; i<switches.length;i++) {
			if(switches[i].isHovering()) {
				switches[i].onClick();
				buttonIndex=i;
			}
		}
	}
	
	@Override
	public void update() {
		for(int i=0; i<switches.length;i++) {
			switches[i].update();
		}
	}

	@Override
	public void render(Graphics g) {
		for(int i=0; i<switches.length;i++) {
			switches[i].render(g);
		}
	}

	@Override
	public void onClick() {
		for(int i=0; i<switches.length;i++) {
			if(switches[i].getActivity() != false && i!=buttonIndex)
				switches[i].setActivity(false);;
		}
	}

}

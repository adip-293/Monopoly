package dev.monopoly.states;

import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import dev.monopoly.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState;
	}
	
	//Class
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}

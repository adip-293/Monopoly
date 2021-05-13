package dev.monopoly;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.monopoly.gfx.Assets;
import dev.monopoly.gfx.Display;
import dev.monopoly.input.KeyManager;
import dev.monopoly.input.MouseManager;
import dev.monopoly.states.GameState;
import dev.monopoly.states.MenuState;
import dev.monopoly.states.SettingsState;
import dev.monopoly.states.State;




public class Monopoly implements Runnable{

	private Display display;
	private int width, height;
	private String title;
	
	private boolean running = false;
	private Thread thread;
	
	//Graphics
	private BufferStrategy bs;
	private Graphics g;
	
	//Input Managers
	private KeyManager keyManager;
	private MouseManager mouseManager;

	//Handler
	private Handler handler;
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	
	public Monopoly (String title, int width, int height) {
		this.width=width;
		this.height=height;
		this.title=title;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getFrame().addMouseWheelListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseWheelListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingsState = new SettingsState(handler);
		
		State.setState(settingsState);
	}
	
	private void update() {
		keyManager.update();
		if(State.getState() != null) 
			State.getState().update();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0,0,width,height);
		
		if(State.getState() != null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		int fps;
		int fpsLimit = 30;
		double timePerTick = 1000000000 / fpsLimit;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now-lastTime;
			lastTime=now;
			
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				fps = ticks;
				System.out.println("FPS: " + fps);
				ticks=0;
				timer=0;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public Display getDisplay() {
		return display;
	}
	
}

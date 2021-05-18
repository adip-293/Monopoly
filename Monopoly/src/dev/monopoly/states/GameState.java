package dev.monopoly.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.monopoly.Handler;
import dev.monopoly.gfx.Assets;
import dev.monopoly.ui.Clickable;
import dev.monopoly.ui.Switch;
import dev.monopoly.ui.UIManager;

public class GameState extends State{
	
	private UIManager uiManager;
	/* Tabs:
	 * Gameplay - Roll Dice, Buy Properties, and Pay Rent 
	 * Assets - Shows Money and Properties -> Mortgage/Unmortgage
	 * Trade - Trade with other players
	 * Board - Reviews Avaialble Properties on Board
	 * History - Logs all game operations 
	 */
	private static Switch gameplay, assets, trade, board, history;

	public GameState(Handler handler) {
		this.handler=handler;
		uiManager = new UIManager(handler);
		
		gameplay = new Switch(1000, 10, 113, 60,Assets.buttonPalette, Assets.kabel24, "Gameplay",true, new Clickable() {
			@Override
			public void onClick() {
				gameplay.setActivity(true);
				assets.setActivity(false);
				trade.setActivity(false);
				board.setActivity(false);
				history.setActivity(false);
			}});
		assets = new Switch(1123, 10, 114, 60,Assets.buttonPalette, Assets.kabel24, "Assets",false, new Clickable() {
			@Override
			public void onClick() {
				gameplay.setActivity(false);
				assets.setActivity(true);
				trade.setActivity(false);
				board.setActivity(false);
				history.setActivity(false);
			}});
		trade = new Switch(1247, 10, 114, 60,Assets.buttonPalette, Assets.kabel24, "Trade",false, new Clickable() {
			@Override
			public void onClick() {
				gameplay.setActivity(false);
				assets.setActivity(false);
				trade.setActivity(true);
				board.setActivity(false);
				history.setActivity(false);
			}});
		board = new Switch(1371, 10, 114, 60,Assets.buttonPalette, Assets.kabel24, "Board",false, new Clickable() {
			@Override
			public void onClick() {
				gameplay.setActivity(false);
				assets.setActivity(false);
				trade.setActivity(false);
				board.setActivity(true);
				history.setActivity(false);
			}});
		history = new Switch(1495, 10, 113, 60,Assets.buttonPalette, Assets.kabel24, "History",false, new Clickable() {
			@Override
			public void onClick() {
				gameplay.setActivity(false);
				assets.setActivity(false);
				trade.setActivity(false);
				board.setActivity(false);
				history.setActivity(true);
			}});

		uiManager.addObject(gameplay);
		uiManager.addObject(assets);
		uiManager.addObject(trade);
		uiManager.addObject(board);
		uiManager.addObject(history);
	}
	
	public void update() {
		if(State.getState() == this) {
			handler.getMouseManager().setUIManager(uiManager);
		}
		uiManager.update();
	}

	public void render(Graphics g) {	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		g.fillRect(1000, 0, 618, 1000);
		
		g.setColor(new Color(153,204,255));
		g.fillRect(1000,10,608,980);
		
		g.setColor(Color.BLACK);
		g.fillRect(1000, 0, 618, 80);
		
		g.drawImage(Assets.gameBoard, 10, 10, 980, 980, null);
		
		uiManager.render(g);
	}

}

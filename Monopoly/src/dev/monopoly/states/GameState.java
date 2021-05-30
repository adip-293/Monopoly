package dev.monopoly.states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.monopoly.Handler;
import dev.monopoly.game.Bot;
import dev.monopoly.game.Card;
import dev.monopoly.game.Dice;
import dev.monopoly.game.Player;
import dev.monopoly.gfx.Assets;
import dev.monopoly.gfx.Utils;
import dev.monopoly.ui.Button;
import dev.monopoly.ui.Clickable;
import dev.monopoly.ui.Slideshow;
import dev.monopoly.ui.Switch;
import dev.monopoly.ui.UIManager;

public class GameState extends State {

	private UIManager uiManager, gameplayManager, assetsManager, tradeManager, boardManager, historyManager;
	/*
	 * Tabs: Gameplay - Roll Dice, Buy Properties, and Pay Rent Assets - Shows Money
	 * and Properties -> Mortgage/Unmortgage Trade - Trade with other players Board
	 * - Reviews Avaialble Properties on Board History - Logs all game operations
	 */
	private static Switch gameplay, assets, trade, board, history;
	private int tab;
	private Dice diceOne, diceTwo;
	private ArrayList<Player> playerList;
	private int playerIndex;
	boolean initRun;
	boolean botActive;
	private Card card;
	private Slideshow playerPropertySlideshow, allPropertySlideshow;
	private Button mortgageButton;
	private int allPropertySlideshowIndex;

	public GameState(Handler handler) {
		this.handler = handler;
		initRun = true;
		card = new Card(Assets.chanceCards[0], Assets.chanceCards[1], 50, 50, 5);

		uiManager = new UIManager(handler);
		gameplayManager = new UIManager(handler);
		assetsManager = new UIManager(handler);
		tradeManager = new UIManager(handler);
		boardManager = new UIManager(handler);
		historyManager = new UIManager(handler);
		tab = 1;

		diceOne = new Dice(1054, 430, 200, 200);
		diceTwo = new Dice(1354, 430, 200, 200);

		playerList = new ArrayList<Player>();
		playerIndex = 0;

		allPropertySlideshowIndex = 0;
		allPropertySlideshow = new Slideshow(1104, 260, 400, 160, Assets.propertyDeck.getRawDeckImages(), 0.4, 0.5, 0,
				new Clickable() {
					@Override
					public void onClick() {

					}
				});

		playerPropertySlideshow = new Slideshow(1104, 340, 400, 160, null, 0.4, 0.5, 0, new Clickable() {
			@Override
			public void onClick() {

			}
		});

		gameplay = new Switch(1000, 10, 113, 60, Assets.buttonPalette, Assets.kabel24, "Gameplay", true,
				new Clickable() {
					@Override
					public void onClick() {
						tab = 1;
						gameplay.setActivity(true);
						assets.setActivity(false);
						trade.setActivity(false);
						board.setActivity(false);
						history.setActivity(false);
					}
				});
		assets = new Switch(1123, 10, 114, 60, Assets.buttonPalette, Assets.kabel24, "Assets", false, new Clickable() {
			@Override
			public void onClick() {
				tab = 2;
				gameplay.setActivity(false);
				assets.setActivity(true);
				trade.setActivity(false);
				board.setActivity(false);
				history.setActivity(false);
			}
		});
		trade = new Switch(1247, 10, 114, 60, Assets.buttonPalette, Assets.kabel24, "Trade", false, new Clickable() {
			@Override
			public void onClick() {
				tab = 3;
				gameplay.setActivity(false);
				assets.setActivity(false);
				trade.setActivity(true);
				board.setActivity(false);
				history.setActivity(false);
			}
		});
		board = new Switch(1371, 10, 114, 60, Assets.buttonPalette, Assets.kabel24, "Board", false, new Clickable() {
			@Override
			public void onClick() {
				tab = 4;
				gameplay.setActivity(false);
				assets.setActivity(false);
				trade.setActivity(false);
				board.setActivity(true);
				history.setActivity(false);
			}
		});
		history = new Switch(1495, 10, 113, 60, Assets.buttonPalette, Assets.kabel24, "History", false,
				new Clickable() {
					@Override
					public void onClick() {
						tab = 5;
						gameplay.setActivity(false);
						assets.setActivity(false);
						trade.setActivity(false);
						board.setActivity(false);
						history.setActivity(true);
					}
				});

		gameplayManager.addObject(
				new Button(1259, 800, 100, 60, Assets.buttonPalette, Assets.kabel48, "Roll", false, new Clickable() {
					@Override
					public void onClick() {
						if (playerList.get(playerIndex).getRollsLeft() > 0) {
							diceOne.roll();
							diceTwo.roll();
							playerList.get(playerIndex).decrementRollsLeft(1);
							playerList.get(playerIndex).incrementPosition(1);
							// playerList.get(playerIndex).incrementPosition(diceOne.getCurrent()+diceTwo.getCurrent());
						}
						if (diceOne.getCurrent() == diceTwo.getCurrent())
							playerList.get(playerIndex).incrementRollsLeft(1);
					}
				}));

		gameplayManager.addObject(new Button(1209, 270, 200, 60, Assets.buttonPalette, Assets.kabel48, "Pay Rent",
				false, new Clickable() {
					@Override
					public void onClick() {

					}
				}));

		gameplayManager.addObject(new Button(1169, 350, 280, 60, Assets.buttonPalette, Assets.kabel48, "Buy Property",
				false, new Clickable() {
					@Override
					public void onClick() {
						int cardIndex = playerList.get(playerIndex).positionToIndex();
						if (cardIndex != -1 && !Assets.propertyDeck.cardInUse(cardIndex)) {
							playerList.get(playerIndex)
									.subtractMoney(Assets.propertyDeck.getCard(cardIndex).getPrice());
							playerList.get(playerIndex).addProperty(Assets.propertyDeck.getCard(cardIndex));
							Assets.propertyDeck.getCard(cardIndex).setOwnership(playerList.get(playerIndex));
							Assets.propertyDeck.setCardInUse(cardIndex);
							playerPropertySlideshow.setImages(playerList.get(playerIndex).getPropertyImages());
						}
					}
				}));

		gameplayManager.addObject(new Button(1000, 910, 608, 80, Assets.nextButtons, new Clickable() {
			@Override
			public void onClick() {
				if (playerList.get(playerIndex).getRollsLeft() == 0) {
					playerIndex++;
					if (playerIndex > playerList.size() - 1) {
						playerIndex = 0;
					}
					if (playerList.get(playerIndex).getProperties().size() == 0)
						playerPropertySlideshow.setImages(null);
					else
						playerPropertySlideshow.setImages(playerList.get(playerIndex).getPropertyImages());
					playerList.get(playerIndex).incrementRollsLeft(1);
				}
			}
		}));

		mortgageButton = new Button(1169, 680, 280, 60, Assets.buttonPalette, Assets.kabel48, "Mortgage", false,
				new Clickable() {
					@Override
					public void onClick() {
						boolean isMortgaged = playerList.get(playerIndex).getProperties()
								.get(playerPropertySlideshow.getImageIndex()).isMortgaged();
						playerList.get(playerIndex).getProperties().get(playerPropertySlideshow.getImageIndex())
								.setMortgaged(!isMortgaged);

						if (isMortgaged) {
							playerList.get(playerIndex).subtractMoney(playerList.get(playerIndex).getProperties()
									.get(playerPropertySlideshow.getImageIndex()).getMortgageVal());
							mortgageButton.setText("Mortgage");
						} else {
							playerList.get(playerIndex).addMoney(playerList.get(playerIndex).getProperties()
									.get(playerPropertySlideshow.getImageIndex()).getMortgageVal());
							mortgageButton.setText("Unmortgage");
						}
					}
				});

		assetsManager.addObject(new Button(1184, 760, 250, 60, Assets.buttonPalette, Assets.kabel48, "Buy House", false,
				new Clickable() {
					@Override
					public void onClick() {
						playerList.get(playerIndex).getProperties()
						.get(playerPropertySlideshow.getImageIndex()).addHouses(1);
					}
				}));

		assetsManager.addObject(new Button(1184, 840, 250, 60, Assets.buttonPalette, Assets.kabel48, "Sell House",
				false, new Clickable() {
					@Override
					public void onClick() {
						playerList.get(playerIndex).getProperties()
						.get(playerPropertySlideshow.getImageIndex()).removeHouses(1);
					}
				}));

		gameplayManager.addObject(gameplay);
		gameplayManager.addObject(assets);
		gameplayManager.addObject(trade);
		gameplayManager.addObject(board);
		gameplayManager.addObject(history);

		assetsManager.addObject(gameplay);
		assetsManager.addObject(assets);
		assetsManager.addObject(trade);
		assetsManager.addObject(board);
		assetsManager.addObject(history);
		assetsManager.addObject(mortgageButton);
		assetsManager.addObject(playerPropertySlideshow);

		tradeManager.addObject(gameplay);
		tradeManager.addObject(assets);
		tradeManager.addObject(trade);
		tradeManager.addObject(board);
		tradeManager.addObject(history);

		boardManager.addObject(gameplay);
		boardManager.addObject(assets);
		boardManager.addObject(trade);
		boardManager.addObject(board);
		boardManager.addObject(history);
		boardManager.addObject(allPropertySlideshow);

		historyManager.addObject(gameplay);
		historyManager.addObject(assets);
		historyManager.addObject(trade);
		historyManager.addObject(board);
		historyManager.addObject(history);
	}

	public void update() {
		if (initRun) {
			for (int i = 0; i < handler.getGame().getNumPlayers(); i++) {
				playerList.add(new Player(0, 0, 32, 32, Assets.gamePieces[handler.getGame().getPlayerIcon()[i]], 1500));
			}
			for (int i = 0; i < handler.getGame().getNumBots(); i++) {
				playerList.add(new Bot(0, 0, 32, 32, Assets.gamePieces[handler.getGame().getBotIcon()[i]], 1500));
			}
			playerList.get(0).incrementRollsLeft(1);
			initRun = false;
		} else {
			if (tab == 1) {
				handler.getMouseManager().setUIManager(gameplayManager);
				gameplayManager.update();
			} else if (tab == 2) {
				handler.getMouseManager().setUIManager(assetsManager);
				assetsManager.update();
			} else if (tab == 3) {
				handler.getMouseManager().setUIManager(tradeManager);
				tradeManager.update();
			} else if (tab == 4) {
				handler.getMouseManager().setUIManager(boardManager);
				boardManager.update();
			} else if (tab == 5) {
				handler.getMouseManager().setUIManager(historyManager);
				historyManager.update();
			}
		}

		for (int i = 0; i < playerList.size() - 1; i++) {
			playerList.get(i).update();
			if (i == 0)
				playerList.get(i).setPlaceModifier(0);
			if (playerList.get(i).getPosition() == playerList.get(i + 1).getPosition()) {
				playerList.get(i + 1).setPlaceModifier(playerList.get(i).getPlaceModifier() + 2);
			}
		}

	}

	public void render(Graphics g) {
		if (!initRun) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 1000);
			g.fillRect(1000, 0, 618, 1000);

			g.setColor(new Color(153, 204, 255));
			g.fillRect(1000, 10, 608, 980);

			g.setColor(Color.BLACK);
			g.fillRect(1000, 0, 618, 80);

			g.drawImage(Assets.gameBoard, 10, 10, 980, 980, null);

			if (tab == 1) {
				g.setColor(Color.black);
				g.fillRect(1254, 795, 110, 70);

				g.fillRect(1204, 265, 210, 70);

				g.fillRect(1164, 345, 290, 70);

				card.render(g);

				if (playerIndex < handler.getGame().getNumPlayers()) {
					Utils.drawString(g, "Player " + (playerIndex + 1), 1304, 110, true, Color.black, Assets.kabel48);
					g.drawImage(Assets.gamePieces[handler.getGame().getPlayerIcon()[playerIndex]], 1249, 140, 120, 120,
							null);
				} else if (playerIndex < handler.getGame().getNumPlayers() + handler.getGame().getNumBots()) {
					Utils.drawString(g, "Bot " + (playerIndex + 1), 1304, 110, true, Color.black, Assets.kabel48);
					g.drawImage(Assets.gamePieces[handler.getGame().getBotIcon()[playerIndex
							- handler.getGame().getNumPlayers()]], 1249, 140, 120, 120, null);
				}

				diceOne.render(g);
				diceTwo.render(g);
				Utils.drawString(g, "Total: " + (diceOne.getCurrent() + diceTwo.getCurrent()), 1304, 670, true,
						Color.black, Assets.kabel48);
				Utils.drawString(g, "Rolls Left: " + (playerList.get(playerIndex).getRollsLeft()), 1304, 750, true,
						Color.black, Assets.kabel48);

				gameplayManager.render(g);
			} else if (tab == 2) {
				g.setColor(Color.BLACK);
				g.fillRect(1164, 675, 290, 70);
				g.fillRect(1179, 755, 260, 70);
				g.fillRect(1179, 835, 260, 70);

				assetsManager.render(g);

				Utils.drawString(g, "Money: $" + playerList.get(playerIndex).getMoney(), 1304, 110, true, Color.black,
						Assets.kabel48);
				Utils.drawString(g, "Properties", 1304, 210, true, Color.black, Assets.kabel48);
				
				if (playerList.get(playerIndex).getProperties().get(playerPropertySlideshow.getImageIndex()).isMortgaged())
					Utils.drawString(g, "Mortgaged", 1304, 610, true, Color.black, Assets.kabel24);
				else
					Utils.drawString(g, "Unmortgaged", 1304, 610, true, Color.black, Assets.kabel24);
				Utils.drawString(g, "Houses: " + Assets.propertyDeck.getCard(allPropertySlideshowIndex).getHouses(),
						1304, 640, true, Color.black, Assets.kabel24);
			} else if (tab == 3) {
				tradeManager.render(g);
			} else if (tab == 4) {
				boardManager.render(g);

				Utils.drawString(g, "Board Info", 1304, 120, true, Color.black, Assets.kabel48);
				Utils.drawString(g, "Price: $" + Assets.propertyDeck.getCard(allPropertySlideshowIndex).getPrice(),
						1304, 530, true, Color.black, Assets.kabel24);

				if (Assets.propertyDeck.getCard(allPropertySlideshowIndex).getOwner() == null)
					Utils.drawString(g, "Owner: None", 1304, 560, true, Color.black, Assets.kabel24);
				else if (Assets.propertyDeck.getCard(allPropertySlideshowIndex).getOwner() instanceof Bot)
					Utils.drawString(g, "Owner: Bot "
							+ Assets.propertyDeck.getCard(allPropertySlideshowIndex).getOwner().getPlayerNumber(), 1304,
							560, true, Color.black, Assets.kabel24);
				else
					Utils.drawString(g, "Owner: Player "
							+ Assets.propertyDeck.getCard(allPropertySlideshowIndex).getOwner().getPlayerNumber(), 1304,
							560, true, Color.black, Assets.kabel24);

				if (Assets.propertyDeck.getCard(allPropertySlideshowIndex).isMortgaged())
					Utils.drawString(g, "Mortgaged", 1304, 590, true, Color.black, Assets.kabel24);
				else
					Utils.drawString(g, "Unmortgaged", 1304, 590, true, Color.black, Assets.kabel24);

				Utils.drawString(g, "Houses: " + Assets.propertyDeck.getCard(allPropertySlideshowIndex).getHouses(),
						1304, 620, true, Color.black, Assets.kabel24);
			} else if (tab == 5) {
				historyManager.render(g);
			}

			for (Player p : playerList)
				p.render(g);

			uiManager.render(g);
		}
	}

}

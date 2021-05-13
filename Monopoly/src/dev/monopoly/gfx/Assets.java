package dev.monopoly.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	public static Font kabel48, kabel24, kabel12;
	
	public static BufferedImage[] chanceCards, communityChestCards;
	public static final int chanceWidth = 458, chanceHeight=292;
	
	public static BufferedImage[] titleDeeds;
	public static final int deedWidth = 450, deedHeight = 685;
	
	public static BufferedImage[] nextButtons;
	
	public static BufferedImage[] slideshowButtons;
	
	public static BufferedImage[] startButtons;
	
	public static BufferedImage[] playerSelectionButtonZero, playerSelectionButtonOne, playerSelectionButtonTwo, playerSelectionButtonThree, playerSelectionButtonFour;
	
	public static BufferedImage[] gamePieces;
	
	public static BufferedImage gameBoard, startScreen;
	
	public static void init() {
		SpriteSheet chanceCardsSheet = new SpriteSheet(Utils.loadImage("/ChanceCards.png"));
		SpriteSheet communityChestCardsSheet = new SpriteSheet(Utils.loadImage("/CommunityChestCards.png"));
		SpriteSheet titleDeedsSheet = new SpriteSheet(Utils.loadImage("/TitleDeeds.png"));
		SpriteSheet startButtonsSheet = new SpriteSheet(Utils.loadImage("/StartButtons.png"));
		SpriteSheet slideshowButtonsSheet = new SpriteSheet(Utils.loadImage("/SlideshowButtons.png"));
		SpriteSheet gamePieceSheet = new SpriteSheet(Utils.loadImage("/GamePieces.png"));
		SpriteSheet playerSelectionButtonsSheet = new SpriteSheet(Utils.loadImage("/PlayerSelectionButtons.png"));
		SpriteSheet nextButtonsSheet = new SpriteSheet(Utils.loadImage("/SettingsNextButtons.png"));
		
		gameBoard =  Utils.loadImage("/GameBoard.png");
		
		startScreen = Utils.loadImage("/StartScreen.png");
		
		kabel12 = Utils.loadFont("res/fonts/kabelc-medium.otf", 12);
		kabel24 = Utils.loadFont("res/fonts/kabelc-medium.otf", 24);
		kabel48 = Utils.loadFont("res/fonts/kabelc-medium.otf", 48);
		
		playerSelectionButtonZero = new BufferedImage[2];
		playerSelectionButtonZero[0] = playerSelectionButtonsSheet.crop(0, 800, 200, 200);
		playerSelectionButtonZero[1] = playerSelectionButtonsSheet.crop(200, 800, 200, 200);
		
		playerSelectionButtonOne = new BufferedImage[2];
		playerSelectionButtonOne[0] = playerSelectionButtonsSheet.crop(0, 0, 200, 200);
		playerSelectionButtonOne[1] = playerSelectionButtonsSheet.crop(0, 400, 200, 200);
		
		playerSelectionButtonTwo = new BufferedImage[2];
		playerSelectionButtonTwo[0] = playerSelectionButtonsSheet.crop(200, 0, 200, 200);
		playerSelectionButtonTwo[1] = playerSelectionButtonsSheet.crop(200, 400, 200, 200);
		
		playerSelectionButtonThree = new BufferedImage[2];
		playerSelectionButtonThree[0] = playerSelectionButtonsSheet.crop(0, 200, 200, 200);
		playerSelectionButtonThree[1] = playerSelectionButtonsSheet.crop(0, 600, 200, 200);
		
		playerSelectionButtonFour = new BufferedImage[2];
		playerSelectionButtonFour[0] = playerSelectionButtonsSheet.crop(200, 200, 200, 200);
		playerSelectionButtonFour[1] = playerSelectionButtonsSheet.crop(200, 600, 200, 200);

		nextButtons = new BufferedImage[2];
		nextButtons[0] = nextButtonsSheet.crop(0,0,608,80);
		nextButtons[1] = nextButtonsSheet.crop(0,80,608,80);
		
		
		slideshowButtons = new BufferedImage[4];
		slideshowButtons[0] = slideshowButtonsSheet.crop(0, 0, 185, 220);
		slideshowButtons[1] = slideshowButtonsSheet.crop(185, 0, 185, 220);
		slideshowButtons[2] = slideshowButtonsSheet.crop(0, 220, 185, 220);
		slideshowButtons[3] = slideshowButtonsSheet.crop(185, 220, 185, 220);
		
		startButtons = new BufferedImage[2];
		startButtons[0] = startButtonsSheet.crop(0, 0, 496, 150);
		startButtons[1] = startButtonsSheet.crop(0, 150, 496, 150);
		
		gamePieces = new BufferedImage[8];
		gamePieces[0] = gamePieceSheet.crop(0,0,300,300);
		gamePieces[1] = gamePieceSheet.crop(300,0,300,300);
		gamePieces[2] = gamePieceSheet.crop(0,300,300,300);
		gamePieces[3] = gamePieceSheet.crop(300,300,300,300);
		gamePieces[4] = gamePieceSheet.crop(0,600,300,300);
		gamePieces[5] = gamePieceSheet.crop(300,600,300,300);
		gamePieces[6] = gamePieceSheet.crop(0,900,300,300);
		gamePieces[7] = gamePieceSheet.crop(300,900,300,300);
		
		chanceCards = new BufferedImage[18];
		chanceCards[0] = chanceCardsSheet.crop(0 * chanceWidth,0 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[1] = chanceCardsSheet.crop(1 * chanceWidth,0 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[2] = chanceCardsSheet.crop(0 * chanceWidth,1 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[3] = chanceCardsSheet.crop(1 * chanceWidth,1 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[4] = chanceCardsSheet.crop(0 * chanceWidth,2 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[5] = chanceCardsSheet.crop(1 * chanceWidth,2 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[6] = chanceCardsSheet.crop(0 * chanceWidth,3 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[7] = chanceCardsSheet.crop(1 * chanceWidth,3 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[8] = chanceCardsSheet.crop(0 * chanceWidth,4 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[9] = chanceCardsSheet.crop(1 * chanceWidth,4 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[10] = chanceCardsSheet.crop(0 * chanceWidth,5 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[11] = chanceCardsSheet.crop(1 * chanceWidth,5 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[12] = chanceCardsSheet.crop(0 * chanceWidth,6 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[13] = chanceCardsSheet.crop(1 * chanceWidth,6 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[14] = chanceCardsSheet.crop(0 * chanceWidth,7 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[15] = chanceCardsSheet.crop(1 * chanceWidth,7 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[16] = chanceCardsSheet.crop(0 * chanceWidth,8 * chanceHeight,chanceWidth,chanceHeight);
		chanceCards[17] = chanceCardsSheet.crop(1 * chanceWidth,8 * chanceHeight,chanceWidth,chanceHeight);
		
		communityChestCards= new BufferedImage[18];
		communityChestCards[0] = communityChestCardsSheet.crop(0 * chanceWidth,0 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[1] = communityChestCardsSheet.crop(1 * chanceWidth,0 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[2] = communityChestCardsSheet.crop(0 * chanceWidth,1 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[3] = communityChestCardsSheet.crop(1 * chanceWidth,1 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[4] = communityChestCardsSheet.crop(0 * chanceWidth,2 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[5] = communityChestCardsSheet.crop(1 * chanceWidth,2 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[6] = communityChestCardsSheet.crop(0 * chanceWidth,3 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[7] = communityChestCardsSheet.crop(1 * chanceWidth,3 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[8] = communityChestCardsSheet.crop(0 * chanceWidth,4 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[9] = communityChestCardsSheet.crop(1 * chanceWidth,4 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[10] = communityChestCardsSheet.crop(0 * chanceWidth,5 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[11] = communityChestCardsSheet.crop(1 * chanceWidth,5 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[12] = communityChestCardsSheet.crop(0 * chanceWidth,6 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[13] = communityChestCardsSheet.crop(1 * chanceWidth,6 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[14] = communityChestCardsSheet.crop(0 * chanceWidth,7 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[15] = communityChestCardsSheet.crop(1 * chanceWidth,7 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[16] = communityChestCardsSheet.crop(0 * chanceWidth,8 * chanceHeight,chanceWidth,chanceHeight);
		communityChestCards[17] = communityChestCardsSheet.crop(1 * chanceWidth,8 * chanceHeight,chanceWidth,chanceHeight);
		
		titleDeeds = new BufferedImage[28];
		titleDeeds[0] = titleDeedsSheet.crop(0 * deedWidth,0 * deedHeight,deedWidth,deedHeight);
		titleDeeds[1] = titleDeedsSheet.crop(1 * deedWidth,0 * deedHeight,deedWidth,deedHeight);
		titleDeeds[2] = titleDeedsSheet.crop(2 * deedWidth,0 * deedHeight,deedWidth,deedHeight);
		titleDeeds[3] = titleDeedsSheet.crop(3 * deedWidth,0 * deedHeight,deedWidth,deedHeight);
		titleDeeds[4] = titleDeedsSheet.crop(0 * deedWidth,1 * deedHeight,deedWidth,deedHeight);
		titleDeeds[5] = titleDeedsSheet.crop(1 * deedWidth,1 * deedHeight,deedWidth,deedHeight);
		titleDeeds[6] = titleDeedsSheet.crop(2 * deedWidth,1 * deedHeight,deedWidth,deedHeight);
		titleDeeds[7] = titleDeedsSheet.crop(3 * deedWidth,1 * deedHeight,deedWidth,deedHeight);
		titleDeeds[8] = titleDeedsSheet.crop(0 * deedWidth,2 * deedHeight,deedWidth,deedHeight);
		titleDeeds[9] = titleDeedsSheet.crop(1 * deedWidth,2 * deedHeight,deedWidth,deedHeight);
		titleDeeds[10] = titleDeedsSheet.crop(2 * deedWidth,2 * deedHeight,deedWidth,deedHeight);
		titleDeeds[11] = titleDeedsSheet.crop(3 * deedWidth,2 * deedHeight,deedWidth,deedHeight);
		titleDeeds[12] = titleDeedsSheet.crop(0 * deedWidth,3 * deedHeight,deedWidth,deedHeight);
		titleDeeds[13] = titleDeedsSheet.crop(1 * deedWidth,3 * deedHeight,deedWidth,deedHeight);
		titleDeeds[14] = titleDeedsSheet.crop(2 * deedWidth,3 * deedHeight,deedWidth,deedHeight);
		titleDeeds[15] = titleDeedsSheet.crop(3 * deedWidth,3 * deedHeight,deedWidth,deedHeight);
		titleDeeds[16] = titleDeedsSheet.crop(0 * deedWidth,4 * deedHeight,deedWidth,deedHeight);
		titleDeeds[17] = titleDeedsSheet.crop(1 * deedWidth,4 * deedHeight,deedWidth,deedHeight);
		titleDeeds[18] = titleDeedsSheet.crop(2 * deedWidth,4 * deedHeight,deedWidth,deedHeight);
		titleDeeds[19] = titleDeedsSheet.crop(3 * deedWidth,4 * deedHeight,deedWidth,deedHeight);
		titleDeeds[20] = titleDeedsSheet.crop(0 * deedWidth,5 * deedHeight,deedWidth,deedHeight);
		titleDeeds[21] = titleDeedsSheet.crop(1 * deedWidth,5 * deedHeight,deedWidth,deedHeight);
		titleDeeds[22] = titleDeedsSheet.crop(2 * deedWidth,5 * deedHeight,deedWidth,deedHeight);
		titleDeeds[23] = titleDeedsSheet.crop(3 * deedWidth,5 * deedHeight,deedWidth,deedHeight);
		titleDeeds[24] = titleDeedsSheet.crop(0 * deedWidth,6 * deedHeight,deedWidth,deedHeight);
		titleDeeds[25] = titleDeedsSheet.crop(1 * deedWidth,6 * deedHeight,deedWidth,deedHeight);
		titleDeeds[26] = titleDeedsSheet.crop(2 * deedWidth,6 * deedHeight,deedWidth,deedHeight);
		titleDeeds[27] = titleDeedsSheet.crop(3 * deedWidth,6 * deedHeight,deedWidth,deedHeight);

	}
	
}

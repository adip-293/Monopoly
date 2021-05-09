package dev.monopoly.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage[] chanceCards, communityChestCards;
	public static final int chanceWidth = 458, chanceHeight=292;
	
	public static BufferedImage[] titleDeeds;
	public static final int deedWidth = 450, deedHeight = 658;
	
	public static BufferedImage gameBoard;
	
	public static void init() {
		SpriteSheet chanceCardsSheet = new SpriteSheet(ImageLoader.loadImage("/ChanceCards.png"));
		SpriteSheet communityChestCardsSheet = new SpriteSheet(ImageLoader.loadImage("/CommunityChestCards.png"));
		SpriteSheet titleDeedsSheet = new SpriteSheet(ImageLoader.loadImage("/TitleDeeds.png"));
		
		gameBoard =  ImageLoader.loadImage("/GameBoard.png");
		
		chanceCards= new BufferedImage[18];
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

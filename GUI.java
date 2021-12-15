import java.awt.*;

public class GUI {
	private int sizeX;
	private int sizeY;

	private Boolean debugLog = false;
	private int boardSize;

	private Color backgroundColor;
	private Color frontColor;
	private Color boardLineColor = new Color(192, 192, 192);



	public GUI() {
		sizeX = 720;
		sizeY = 720;
		boardSize = 15;
	}
	public GUI(boolean debugLog) {
		sizeX = 720;
		sizeY = 720;
		this.debugLog = debugLog;
		boardSize = 15;
	}
	public GUI(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		backgroundColor = new Color(255,245,255);
		frontColor = new Color(255,255,245);
		boardSize = 15;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public void drawMenu(Color backgroundColor) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(sizeX, sizeY);
		StdDraw.setXscale(0, sizeX);
		StdDraw.setYscale(0, sizeY);
		StdDraw.setPenColor(backgroundColor);
		StdDraw.filledRectangle(sizeX / 2.0, sizeY / 2.0, sizeX / 2.0, sizeY / 2.0);
		StdDraw.show();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void generateStartWindows(){
		StdDraw.setCanvasSize(sizeX, sizeY);
		StdDraw.setXscale(0, sizeX);
		StdDraw.setYscale(0, sizeY);
	}
	public void generateGameWindows(){
		StdDraw.setCanvasSize(sizeX, sizeY);
		StdDraw.setXscale(0, sizeX);
		StdDraw.setYscale(0, sizeY);
	}
	public void generateNoSavesWindows(){
		StdDraw.setCanvasSize(sizeX, sizeY);
		StdDraw.setXscale(0, sizeX);
		StdDraw.setYscale(0, sizeY);
	}
	public void generateExitSaveReminderWindows(){
		StdDraw.setCanvasSize(sizeX, sizeY);
		StdDraw.setXscale(0, sizeX);
		StdDraw.setYscale(0, sizeY);
	}

	public void drawStart(){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		double posXTitle = 0.50*sizeX + shiftX;
		double posYTitle = 0.90*sizeY + shiftY;
		StdDraw.setPenColor(Color.white);
		StdDraw.filledRectangle(posXTitle,posYTitle,150,30);
		drawTitle(posXTitle,posYTitle,40,"Gomoku Game");
		StdDraw.setPenColor(Color.black);
		double posXButton01 = 0.50*sizeX + shiftX;
		double posYButton01 = 0.70*sizeY + shiftY;
		drawButton(posXButton01,posYButton01,fontSize,"Start Game");
		double posXButton02 = 0.50*sizeX + shiftX;
		double posYButton02 = 0.55*sizeY + shiftY;
		drawButton(posXButton02,posYButton02,fontSize,"Load Game");
		double posXButton03 = 0.50*sizeX + shiftX;
		double posYButton03 = 0.40*sizeY + shiftY;
		drawButton(posXButton03,posYButton03,fontSize,"Play with Computer");
		double posXButton04 = 0.312*sizeX + shiftX;
		double posYButton04 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton04,posYButton04,fontSize,"Settings");
		double posXButton05 = 0.685*sizeX + shiftX;
		double posYButton05 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
	}
	public void drawStart(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.50*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButton(posXButton01,posYButton01,fontSize,"Start Game");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButton(posXButton02,posYButton02,fontSize,"Load Game");
				break;
			case 3:
				double posXButton03 = 0.50*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButton(posXButton03,posYButton03,fontSize,"Play with Computer");
				break;
			case 4:
				double posXButton04 = 0.312*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Settings");
				break;
			case 5:
				double posXButton05 = 0.685*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
				break;
		}





	}
	public void drawStartPress(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.50*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButtonPressed(posXButton01,posYButton01,fontSize,"Start Game");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButtonPressed(posXButton02,posYButton02,fontSize,"Load Game");
				break;
			case 3:
				double posXButton03 = 0.50*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButtonPressed(posXButton03,posYButton03,fontSize,"Play with Computer");
				break;
			case 4:
				double posXButton04 = 0.312*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmallPressed(posXButton04,posYButton04,fontSize,"Settings");
				break;
			case 5:
				double posXButton05 = 0.685*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmallPressed(posXButton05,posYButton05,fontSize,"Quit");
				break;
		}
	}

	public void drawMenu() {
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		double posXTitle = 0.80*sizeX + shiftX;
		double posYTitle = 0.85*sizeY + shiftY;
		drawTitle(posXTitle,posYTitle,40,"Gomoku Game");
		double posXButton01 = 0.80*sizeX + shiftX;
		double posYButton01 = 0.70*sizeY + shiftY;
		drawButton(posXButton01,posYButton01,fontSize,"Pause Game");
		double posXButton02 = 0.80*sizeX + shiftX;
		double posYButton02 = 0.55*sizeY + shiftY;
		drawButton(posXButton02,posYButton02,fontSize,"Save Game");
		double posXButton03 = 0.80*sizeX + shiftX;
		double posYButton03 = 0.40*sizeY + shiftY;
		drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
		double posXButton04 = 0.722*sizeX + shiftX;
		double posYButton04 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
		double posXButton05 = 0.8777*sizeX + shiftX;
		double posYButton05 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
	}
	public void drawMenu(int buttonNum) {
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.80*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButton(posXButton01,posYButton01,fontSize,"Pause Game");
				break;
			case 2:
				double posXButton02 = 0.80*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButton(posXButton02,posYButton02,fontSize,"Save Game");
				break;
			case 3:
				double posXButton03 = 0.80*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
				break;
			case 4:
				double posXButton04 = 0.722*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
				break;
			case 5:
				double posXButton05 = 0.8777*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
				break;
		}





	}
	public void drawMenuPress(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		double posXTitle = 0.80*sizeX + shiftX;
		double posYTitle = 0.85*sizeY + shiftY;
		drawTitle(posXTitle,posYTitle,40,"Gomoku Game");

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.80*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButtonPressed(posXButton01,posYButton01,fontSize,"Pause Game");
				break;
			case 2:
				double posXButton02 = 0.80*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButtonPressed(posXButton02,posYButton02,fontSize,"Save Game");
				break;
			case 3:
				double posXButton03 = 0.80*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButtonPressed(posXButton03,posYButton03,fontSize,"Back to Menu");
				break;
			case 4:
				double posXButton04 = 0.722*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmallPressed(posXButton04,posYButton04,fontSize,"Undo");
				break;
			case 5:
				double posXButton05 = 0.8777*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmallPressed(posXButton05,posYButton05,fontSize,"Quit");
				break;
		}

	}
	public void drawMenuPause(){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调
		double posXTitle = 0.80*sizeX + shiftX;
		double posYTitle = 0.85*sizeY + shiftY;
		drawTitle(posXTitle,posYTitle,40,"Gomoku Game");
		double posXButton01 = 0.80*sizeX + shiftX;
		double posYButton01 = 0.70*sizeY + shiftY;
		drawButton(posXButton01,posYButton01,fontSize,"Continue");
		double posXButton02 = 0.80*sizeX + shiftX;
		double posYButton02 = 0.55*sizeY + shiftY;
		drawButton(posXButton02,posYButton02,fontSize,"Save Game");
		double posXButton03 = 0.80*sizeX + shiftX;
		double posYButton03 = 0.40*sizeY + shiftY;
		drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
		double posXButton04 = 0.722*sizeX + shiftX;
		double posYButton04 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
		double posXButton05 = 0.8777*sizeX + shiftX;
		double posYButton05 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
	}
	public void drawMenuPause(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.80*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButton(posXButton01,posYButton01,fontSize,"Continue");
			case 2:
				double posXButton02 = 0.80*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButton(posXButton02,posYButton02,fontSize,"Save Game");
			case 3:
				double posXButton03 = 0.80*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
			case 4:
				double posXButton04 = 0.722*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
			case 5:
				double posXButton05 = 0.8777*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
		}





	}
	public void drawMenuPausePress(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		double posXTitle = 0.80*sizeX + shiftX;
		double posYTitle = 0.85*sizeY + shiftY;
		drawTitle(posXTitle,posYTitle,40,"Gomoku Game");

		double posXButton01 = 0.80*sizeX + shiftX;
		double posYButton01 = 0.70*sizeY + shiftY;

		double posXButton02 = 0.80*sizeX + shiftX;
		double posYButton02 = 0.55*sizeY + shiftY;

		double posXButton03 = 0.80*sizeX + shiftX;
		double posYButton03 = 0.40*sizeY + shiftY;

		double posXButton04 = 0.722*sizeX + shiftX;
		double posYButton04 = 0.25*sizeY + shiftY;

		double posXButton05 = 0.8777*sizeX + shiftX;
		double posYButton05 = 0.25*sizeY + shiftY;
		switch (buttonNum){
			case 1:
				drawButtonPressed(posXButton01,posYButton01,fontSize,"Continue");
				drawButton(posXButton02,posYButton02,fontSize,"Save Game");
				drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
				break;
			case 2:
				drawButton(posXButton01,posYButton01,fontSize,"Continue");
				drawButtonPressed(posXButton02,posYButton02,fontSize,"Save Game");
				drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
				break;
			case 3:
				drawButton(posXButton01,posYButton01,fontSize,"Continue");
				drawButton(posXButton02,posYButton02,fontSize,"Save Game");
				drawButtonPressed(posXButton03,posYButton03,fontSize,"Back to Menu");
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
				break;
			case 4:
				drawButton(posXButton01,posYButton01,fontSize,"Continue");
				drawButton(posXButton02,posYButton02,fontSize,"Save Game");
				drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
				drawButtonSmallPressed(posXButton04,posYButton04,fontSize,"Undo");
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Quit");
				break;
			case 5:
				drawButton(posXButton01,posYButton01,fontSize,"Continue");
				drawButton(posXButton02,posYButton02,fontSize,"Save Game");
				drawButton(posXButton03,posYButton03,fontSize,"Back to Menu");
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Undo");
				drawButtonSmallPressed(posXButton05,posYButton05,fontSize,"Quit");
				break;
		}
	}



	public void drawOptions(){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		double posXTitle = 0.50*sizeX + shiftX;
		double posYTitle = 0.90*sizeY + shiftY;
		StdDraw.setPenColor(Color.white);
		StdDraw.filledRectangle(posXTitle,posYTitle,150,30);
		drawTitle(posXTitle,posYTitle,40,"Game Setting");
		double posXButton01 = 0.50*sizeX + shiftX;
		double posYButton01 = 0.70*sizeY + shiftY;
		drawButton(posXButton01,posYButton01,fontSize,"15-15 Board");
		double posXButton02 = 0.50*sizeX + shiftX;
		double posYButton02 = 0.55*sizeY + shiftY;
		drawButton(posXButton02,posYButton02,fontSize,"17-17 Board");
		double posXButton03 = 0.50*sizeX + shiftX;
		double posYButton03 = 0.40*sizeY + shiftY;
		drawButton(posXButton03,posYButton03,fontSize,"19-19 Board");
		double posXButton04 = 0.312*sizeX + shiftX;
		double posYButton04 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton04,posYButton04,fontSize,"Forbidden");
		double posXButton05 = 0.685*sizeX + shiftX;
		double posYButton05 = 0.25*sizeY + shiftY;
		drawButtonSmall(posXButton05,posYButton05,fontSize,"Back");
	}
	public void drawOptions(int buttonNum) {
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.50*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButton(posXButton01,posYButton01,fontSize,"15-15 Board");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButton(posXButton02,posYButton02,fontSize,"17-17 Board");
				break;
			case 3:
				double posXButton03 = 0.50*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButton(posXButton03,posYButton03,fontSize,"19-19 Board");
				break;
			case 4:
				double posXButton04 = 0.312*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton04,posYButton04,fontSize,"Forbidden");
				break;
			case 5:
				double posXButton05 = 0.685*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmall(posXButton05,posYButton05,fontSize,"Back");
				break;
		}
	}
	public void drawOptionsPress(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.50*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButtonPressed(posXButton01,posYButton01,fontSize,"15-15 Board");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButtonPressed(posXButton02,posYButton02,fontSize,"17-17 Board");
				break;
			case 3:
				double posXButton03 = 0.50*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButtonPressed(posXButton03,posYButton03,fontSize,"19-19 Board");
				break;
			case 4:
				double posXButton04 = 0.312*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmallPressed(posXButton04,posYButton04,fontSize,"Forbidden");
				break;
			case 5:
				double posXButton05 = 0.685*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmallPressed(posXButton05,posYButton05,fontSize,"Back");
				break;
		}
	}
	public void drawOptionsChosen(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.50*sizeX + shiftX;
				double posYButton01 = 0.70*sizeY + shiftY;
				drawButtonChosen(posXButton01,posYButton01,fontSize,"15-15 Board");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.55*sizeY + shiftY;
				drawButtonChosen(posXButton02,posYButton02,fontSize,"17-17 Board");
				break;
			case 3:
				double posXButton03 = 0.50*sizeX + shiftX;
				double posYButton03 = 0.40*sizeY + shiftY;
				drawButtonChosen(posXButton03,posYButton03,fontSize,"19-19 Board");
				break;
			case 4:
				double posXButton04 = 0.312*sizeX + shiftX;
				double posYButton04 = 0.25*sizeY + shiftY;
				drawButtonSmallChosen(posXButton04,posYButton04,fontSize,"Forbidden");
				break;
			case 5:
				double posXButton05 = 0.685*sizeX + shiftX;
				double posYButton05 = 0.25*sizeY + shiftY;
				drawButtonSmallChosen(posXButton05,posYButton05,fontSize,"Back");
				break;
		}
	}

	public void drawNoSaves(){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调
		double posXTitle = 0.50*sizeX + shiftX;
		double posYTitle = 0.75*sizeY + shiftY;
		drawTitle(posXTitle,posYTitle,30,"Opos! Save File Missing!");
		double posXButton = 0.5*sizeX + shiftX;
		double posYButton = 0.40*sizeY + shiftY;
		drawButton(posXButton,posYButton,fontSize,"Back to Menu");

	}
	public void drawNoSavesPress(){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调
		double posXButton = 0.5*sizeX + shiftX;
		double posYButton = 0.40*sizeY + shiftY;
		drawButtonPressed(posXButton,posYButton,fontSize,"Back to Menu");
	}

	public void drawExitSaveReminder(){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		double posXTitle = 0.50*sizeX + shiftX;
		double posYTitle = 0.70*sizeY + shiftY;
		drawTitle(posXTitle,posYTitle,40,"Save the Game?");
		double posXButton01 = 0.20*sizeX + shiftX;
		double posYButton01 = 0.35*sizeY + shiftY;
		drawButtonExtraSmall(posXButton01,posYButton01,fontSize,"Yes");
		double posXButton02 = 0.50*sizeX + shiftX;
		double posYButton02 = 0.35*sizeY + shiftY;
		drawButtonExtraSmall(posXButton02,posYButton02,fontSize,"No");
		double posXButton03 = 0.80*sizeX + shiftX;
		double posYButton03 = 0.35*sizeY + shiftY;
		drawButtonExtraSmall(posXButton03,posYButton03,fontSize,"Back");
	}
	public void drawExitSaveReminder(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.20*sizeX + shiftX;
				double posYButton01 = 0.35*sizeY + shiftY;
				drawButtonExtraSmall(posXButton01,posYButton01,fontSize,"Yes");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.35*sizeY + shiftY;
				drawButtonExtraSmall(posXButton02,posYButton02,fontSize,"No");
				break;
			case 3:
				double posXButton03 = 0.80*sizeX + shiftX;
				double posYButton03 = 0.35*sizeY + shiftY;
				drawButtonExtraSmall(posXButton03,posYButton03,fontSize,"Back");
				break;
		}
	}
	public void drawExitSaveReminderPress(int buttonNum){
		int fontSize = 28;//按钮字体大小
		double shiftX = 0;//按钮组整体横向微调
		double shiftY = 0;//按钮组整体纵向微调

		switch (buttonNum){
			case 1:
				double posXButton01 = 0.20*sizeX + shiftX;
				double posYButton01 = 0.35*sizeY + shiftY;
				drawButtonExtraSmallPressed(posXButton01,posYButton01,fontSize,"Yes");
				break;
			case 2:
				double posXButton02 = 0.50*sizeX + shiftX;
				double posYButton02 = 0.35*sizeY + shiftY;
				drawButtonExtraSmallPressed(posXButton02,posYButton02,fontSize,"No");
				break;
			case 3:
				double posXButton03 = 0.80*sizeX + shiftX;
				double posYButton03 = 0.35*sizeY + shiftY;
				drawButtonExtraSmallPressed(posXButton03,posYButton03,fontSize,"Back");
				break;
		}
	}

	public void drawCanvas() {
		Color mainColor = new Color(245,245,245);
		Color boardBackgroundColor = new Color(240,200,0,150);
		StdDraw.setPenColor(mainColor);
		StdDraw.filledRectangle(sizeX / 2.0, sizeY / 2.0,
				sizeX / 2.0, sizeY / 2.0);
		StdDraw.setPenColor(boardBackgroundColor);
		double coordinate = (Math.min(sizeX, sizeY)) * 0.15;
		double areaLength = (Math.min(sizeX, sizeY)) * 0.7;
		StdDraw.filledRectangle(coordinate + areaLength / 2.0, sizeY - coordinate - areaLength / 2.0,
				areaLength / 2.0, areaLength / 2.0);
		StdDraw.setPenColor(boardLineColor);
		for(int i = 0; i < boardSize; i++) {
			StdDraw.line(coordinate + (i * areaLength / ((double) boardSize - 1)), sizeY -coordinate,
					coordinate + (i * areaLength / ((double) boardSize - 1)), sizeY - areaLength - coordinate);
		}
		for(int i = 0; i < boardSize; i++) {
			StdDraw.line(coordinate, sizeY - coordinate - (i * areaLength / ((double) boardSize - 1)),
					areaLength + coordinate, sizeY - coordinate - (i * areaLength / ((double) boardSize - 1)));
		}
	}


	public void drawAllChess(ChessBoard board){
		double coordinate = (Math.min(sizeX, sizeY)) * 0.15;
		double areaLength = (Math.min(sizeX, sizeY)) * 0.7;
		int[][] temp = board.getChessBoard();
		for (int x=0 ; x<temp.length ; x++){
			for (int y=0 ; y<temp[x].length ; y++){
				switch (temp[x][y]){
					case 0:
						break;
					case 1:
						StdDraw.setPenColor(0, 0, 0);
						StdDraw.filledCircle(coordinate + (x * areaLength / ((double) boardSize - 1)),
								sizeY - coordinate - (y * areaLength / ((double) boardSize - 1)),
								(areaLength / ((double) boardSize * 2)) * 0.9);
						break;
					case 2:
						StdDraw.setPenColor(255, 255, 255);
						StdDraw.filledCircle(coordinate + (x * areaLength / ((double) boardSize - 1)),
								sizeY - coordinate - (y * areaLength / ((double) boardSize - 1)),
								(areaLength / ((double) boardSize * 2)) * 0.9);
						break;
				}
			}
		}
	}


	public static void drawButton(double posX , double posY , int fontSize , String text){
		Color ringColor = new Color(255, 192, 225);
		Color innerColor = new Color(192, 255, 255);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 185, 20);
		StdDraw.filledRectangle(posX, posY, 170, 35);
		StdDraw.filledCircle(posX - 170, posY - 20, 15);
		StdDraw.filledCircle(posX + 170, posY - 20, 15);
		StdDraw.filledCircle(posX - 170, posY + 20, 15);
		StdDraw.filledCircle(posX + 170, posY + 20, 15);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 180, 20);
		StdDraw.filledRectangle(posX, posY, 170, 30);
		StdDraw.filledCircle(posX - 170, posY - 20, 10);
		StdDraw.filledCircle(posX + 170, posY - 20, 10);
		StdDraw.filledCircle(posX - 170, posY + 20, 10);
		StdDraw.filledCircle(posX + 170, posY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}
	public static void drawButtonSmall(double posX , double posY , int fontSize , String text){
		Color ringColor = new Color(255, 192, 225);
		Color innerColor = new Color(192, 255, 255);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 85, 20);
		StdDraw.filledRectangle(posX, posY, 70, 35);
		StdDraw.filledCircle(posX - 70, posY - 20, 15);
		StdDraw.filledCircle(posX + 70, posY - 20, 15);
		StdDraw.filledCircle(posX - 70, posY + 20, 15);
		StdDraw.filledCircle(posX + 70, posY + 20, 15);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 80, 20);
		StdDraw.filledRectangle(posX, posY, 70, 30);
		StdDraw.filledCircle(posX - 70, posY - 20, 10);
		StdDraw.filledCircle(posX + 70, posY - 20, 10);
		StdDraw.filledCircle(posX - 70, posY + 20, 10);
		StdDraw.filledCircle(posX + 70, posY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}
	public static void drawButtonExtraSmall(double posX , double posY , int fontSize , String text){
		double factor = 0.70;
		Color ringColor = new Color(255, 192, 225);
		Color innerColor = new Color(192, 255, 255);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 85*factor, 20*factor);
		StdDraw.filledRectangle(posX, posY, 70*factor, 35*factor);
		StdDraw.filledCircle(posX - 70*factor, posY - 20*factor, 15*factor);
		StdDraw.filledCircle(posX + 70*factor, posY - 20*factor, 15*factor);
		StdDraw.filledCircle(posX - 70*factor, posY + 20*factor, 15*factor);
		StdDraw.filledCircle(posX + 70*factor, posY + 20*factor, 15*factor);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 80*factor, 20*factor);
		StdDraw.filledRectangle(posX, posY, 70*factor, 30*factor);
		StdDraw.filledCircle(posX - 70*factor, posY - 20*factor, 10*factor);
		StdDraw.filledCircle(posX + 70*factor, posY - 20*factor, 10*factor);
		StdDraw.filledCircle(posX - 70*factor, posY + 20*factor, 10*factor);
		StdDraw.filledCircle(posX + 70*factor, posY + 20*factor, 10*factor);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}

	public static void drawButtonPressed(double posX , double posY , int fontSize , String text){
		Color ringColor = new Color(255, 170, 255);
		Color innerColor = new Color(110, 255, 255);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 185, 20);
		StdDraw.filledRectangle(posX, posY, 170, 35);
		StdDraw.filledCircle(posX - 170, posY - 20, 15);
		StdDraw.filledCircle(posX + 170, posY - 20, 15);
		StdDraw.filledCircle(posX - 170, posY + 20, 15);
		StdDraw.filledCircle(posX + 170, posY + 20, 15);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 180, 20);
		StdDraw.filledRectangle(posX, posY, 170, 30);
		StdDraw.filledCircle(posX - 170, posY - 20, 10);
		StdDraw.filledCircle(posX + 170, posY - 20, 10);
		StdDraw.filledCircle(posX - 170, posY + 20, 10);
		StdDraw.filledCircle(posX + 170, posY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}
	public static void drawButtonSmallPressed(double posX , double posY , int fontSize , String text){
		Color ringColor = new Color(255, 170, 255);
		Color innerColor = new Color(110, 255, 255);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 85, 20);
		StdDraw.filledRectangle(posX, posY, 70, 35);
		StdDraw.filledCircle(posX - 70, posY - 20, 15);
		StdDraw.filledCircle(posX + 70, posY - 20, 15);
		StdDraw.filledCircle(posX - 70, posY + 20, 15);
		StdDraw.filledCircle(posX + 70, posY + 20, 15);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 80, 20);
		StdDraw.filledRectangle(posX, posY, 70, 30);
		StdDraw.filledCircle(posX - 70, posY - 20, 10);
		StdDraw.filledCircle(posX + 70, posY - 20, 10);
		StdDraw.filledCircle(posX - 70, posY + 20, 10);
		StdDraw.filledCircle(posX + 70, posY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}
	public static void drawButtonExtraSmallPressed(double posX , double posY , int fontSize , String text){
		double factor = 0.70;
		Color ringColor = new Color(255, 170, 255);
		Color innerColor = new Color(110, 255, 255);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 85*factor, 20*factor);
		StdDraw.filledRectangle(posX, posY, 70*factor, 35*factor);
		StdDraw.filledCircle(posX - 70*factor, posY - 20*factor, 15*factor);
		StdDraw.filledCircle(posX + 70*factor, posY - 20*factor, 15*factor);
		StdDraw.filledCircle(posX - 70*factor, posY + 20*factor, 15*factor);
		StdDraw.filledCircle(posX + 70*factor, posY + 20*factor, 15*factor);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 80*factor, 20*factor);
		StdDraw.filledRectangle(posX, posY, 70*factor, 30*factor);
		StdDraw.filledCircle(posX - 70*factor, posY - 20*factor, 10*factor);
		StdDraw.filledCircle(posX + 70*factor, posY - 20*factor, 10*factor);
		StdDraw.filledCircle(posX - 70*factor, posY + 20*factor, 10*factor);
		StdDraw.filledCircle(posX + 70*factor, posY + 20*factor, 10*factor);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}

	public static void drawButtonChosen(double posX , double posY , int fontSize , String text){
		Color ringColor = new Color(170,230,243);
		Color innerColor = new Color(255, 135, 135);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 185, 20);
		StdDraw.filledRectangle(posX, posY, 170, 35);
		StdDraw.filledCircle(posX - 170, posY - 20, 15);
		StdDraw.filledCircle(posX + 170, posY - 20, 15);
		StdDraw.filledCircle(posX - 170, posY + 20, 15);
		StdDraw.filledCircle(posX + 170, posY + 20, 15);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 180, 20);
		StdDraw.filledRectangle(posX, posY, 170, 30);
		StdDraw.filledCircle(posX - 170, posY - 20, 10);
		StdDraw.filledCircle(posX + 170, posY - 20, 10);
		StdDraw.filledCircle(posX - 170, posY + 20, 10);
		StdDraw.filledCircle(posX + 170, posY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}
	public static void drawButtonSmallChosen(double posX , double posY , int fontSize , String text){
		Color ringColor = new Color(170,230,243);
		Color innerColor = new Color(255, 135, 135);
		StdDraw.setPenColor(ringColor);
		StdDraw.filledRectangle(posX, posY, 85, 20);
		StdDraw.filledRectangle(posX, posY, 70, 35);
		StdDraw.filledCircle(posX - 70, posY - 20, 15);
		StdDraw.filledCircle(posX + 70, posY - 20, 15);
		StdDraw.filledCircle(posX - 70, posY + 20, 15);
		StdDraw.filledCircle(posX + 70, posY + 20, 15);
		StdDraw.setPenColor(innerColor);
		StdDraw.filledRectangle(posX, posY, 80, 20);
		StdDraw.filledRectangle(posX, posY, 70, 30);
		StdDraw.filledCircle(posX - 70, posY - 20, 10);
		StdDraw.filledCircle(posX + 70, posY - 20, 10);
		StdDraw.filledCircle(posX - 70, posY + 20, 10);
		StdDraw.filledCircle(posX + 70, posY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}


	public static void drawTitle(double posX , double posY , int fontSize , String text){
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.BOLD ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(posX, posY, text);
	}


	public void drawFakeChess(int x, int y, int color){
		Color fakeBlack = new Color(0,0,0,80);
		Color fakeWhite = new Color(255,255,255,220);


		double coordinate = (Math.min(sizeX, sizeY)) * 0.15;
		double areaLength = (Math.min(sizeX, sizeY)) * 0.7;

		if(color == 1) {
			StdDraw.setPenColor(fakeBlack);
		}
		if (color == 2){
			StdDraw.setPenColor(fakeWhite);
		}
		StdDraw.filledCircle(coordinate + (x * areaLength / ((double) boardSize - 1)),
				sizeY - coordinate - (y * areaLength / ((double) boardSize - 1)),
				(areaLength / ((double) boardSize * 2)) * 0.9);
	}

	public void drawChessReverse(int x,int y){
		Color mainColor = new Color(245,245,245);
		Color boardBackgroundColor = new Color(240,200,0,150);

		double coordinate = (Math.min(sizeX, sizeY)) * 0.15;
		double areaLength = (Math.min(sizeX, sizeY)) * 0.7;

		double drawX = coordinate + (x * areaLength / ((double) boardSize - 1));
		double drawY = sizeY - coordinate - (y * areaLength / ((double) boardSize - 1));
		double radius = areaLength / ((double) boardSize * 2) * 0.9;

		if (x == 0){
			if (y == 0){
				StdDraw.setPenColor(mainColor);
				StdDraw.filledSquare(drawX,drawY,radius);
				StdDraw.setPenColor(boardBackgroundColor);
				StdDraw.filledSquare(drawX+radius/2,drawY-radius/2,radius/2);
				StdDraw.setPenColor(boardLineColor);
				StdDraw.line(drawX,drawY,drawX+radius,drawY);
				StdDraw.line(drawX,drawY,drawX,drawY-radius);
			}else {
				if (y == boardSize-1){
					StdDraw.setPenColor(mainColor);
					StdDraw.filledSquare(drawX,drawY,radius);
					StdDraw.setPenColor(boardBackgroundColor);
					StdDraw.filledSquare(drawX+radius/2,drawY+radius/2,radius/2);
					StdDraw.setPenColor(boardLineColor);
					StdDraw.line(drawX,drawY,drawX+radius,drawY);
					StdDraw.line(drawX,drawY,drawX,drawY+radius);
				}else {
					StdDraw.setPenColor(mainColor);
					StdDraw.filledSquare(drawX,drawY,radius);
					StdDraw.setPenColor(boardBackgroundColor);
					StdDraw.filledSquare(drawX+radius/2,drawY+radius/2,radius/2);
					StdDraw.filledSquare(drawX+radius/2,drawY-radius/2,radius/2);
					StdDraw.setPenColor(boardLineColor);
					StdDraw.line(drawX,drawY,drawX+radius,drawY);
					StdDraw.line(drawX,drawY,drawX,drawY+radius);
					StdDraw.line(drawX,drawY,drawX,drawY-radius);
				}
			}
		}else {
			if (x == boardSize-1){
				if (y == 0){
					StdDraw.setPenColor(mainColor);
					StdDraw.filledSquare(drawX,drawY,radius);
					StdDraw.setPenColor(boardBackgroundColor);
					StdDraw.filledSquare(drawX-radius/2,drawY-radius/2,radius/2);
					StdDraw.setPenColor(boardLineColor);
					StdDraw.line(drawX,drawY,drawX-radius,drawY);
					StdDraw.line(drawX,drawY,drawX,drawY-radius);
				}else {
					if (y == boardSize-1){
						StdDraw.setPenColor(mainColor);
						StdDraw.filledSquare(drawX,drawY,radius);
						StdDraw.setPenColor(boardBackgroundColor);
						StdDraw.filledSquare(drawX-radius/2,drawY+radius/2,radius/2);
						StdDraw.setPenColor(boardLineColor);
						StdDraw.line(drawX,drawY,drawX-radius,drawY);
						StdDraw.line(drawX,drawY,drawX,drawY+radius);
					}else {
						StdDraw.setPenColor(mainColor);
						StdDraw.filledSquare(drawX,drawY,radius);
						StdDraw.setPenColor(boardBackgroundColor);
						StdDraw.filledSquare(drawX-radius/2,drawY+radius/2,radius/2);
						StdDraw.filledSquare(drawX-radius/2,drawY-radius/2,radius/2);
						StdDraw.setPenColor(boardLineColor);
						StdDraw.line(drawX,drawY,drawX-radius,drawY);
						StdDraw.line(drawX,drawY,drawX,drawY+radius);
						StdDraw.line(drawX,drawY,drawX,drawY-radius);
					}
				}
			}else {
				if (y == 0){
					StdDraw.setPenColor(mainColor);
					StdDraw.filledSquare(drawX,drawY,radius);
					StdDraw.setPenColor(boardBackgroundColor);
					StdDraw.filledSquare(drawX+radius/2,drawY-radius/2,radius/2);
					StdDraw.filledSquare(drawX-radius/2,drawY-radius/2,radius/2);
					StdDraw.setPenColor(boardLineColor);
					StdDraw.line(drawX,drawY,drawX-radius,drawY);
					StdDraw.line(drawX,drawY,drawX+radius,drawY);
					StdDraw.line(drawX,drawY,drawX,drawY-radius);
				}else {
					if (y == boardSize-1){
						StdDraw.setPenColor(mainColor);
						StdDraw.filledSquare(drawX,drawY,radius);
						StdDraw.setPenColor(boardBackgroundColor);
						StdDraw.filledSquare(drawX+radius/2,drawY+radius/2,radius/2);
						StdDraw.filledSquare(drawX-radius/2,drawY+radius/2,radius/2);
						StdDraw.setPenColor(boardLineColor);
						StdDraw.line(drawX,drawY,drawX-radius,drawY);
						StdDraw.line(drawX,drawY,drawX+radius,drawY);
						StdDraw.line(drawX,drawY,drawX,drawY+radius);
					}else {
						StdDraw.setPenColor(mainColor);
						StdDraw.filledSquare(drawX,drawY,radius);
						StdDraw.setPenColor(boardBackgroundColor);
						StdDraw.filledSquare(drawX,drawY,radius);
						StdDraw.setPenColor(boardLineColor);
						StdDraw.line(drawX,drawY,drawX+radius,drawY);
						StdDraw.line(drawX,drawY,drawX-radius,drawY);
						StdDraw.line(drawX,drawY,drawX,drawY+radius);
						StdDraw.line(drawX,drawY,drawX,drawY-radius);
					}
				}
			}
		}

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public void drawCanvas( int scaleX, int scaleY, Color backgroundColor, Color frontGroundColor) {
		StdDraw.setCanvasSize(sizeX, sizeY);
		StdDraw.setXscale(0, scaleX);
		StdDraw.setYscale(0, scaleY);
		StdDraw.setPenColor(backgroundColor);
		StdDraw.enableDoubleBuffering();
		if(debugLog) {
			System.out.println("X scale is set from 0 to " + scaleX);
			System.out.println("Y scale is set from 0 to " + scaleY);
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
			System.out.println("Enable Double Buffering");
		}
		StdDraw.filledRectangle(scaleX / 2.0, scaleY / 2.0,
				scaleX / 2.0, scaleY / 2.0);
		StdDraw.setPenColor(frontGroundColor);
		if(debugLog) {
			System.out.println("Background filled");
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
		}
		double coordinate = (Math.min(scaleX, scaleY)) * 0.15;
		double areaLength = (Math.min(scaleX, scaleY)) * 0.7;
		StdDraw.filledRectangle(coordinate + areaLength / 2.0, scaleY - coordinate - areaLength / 2.0,
				areaLength / 2.0, areaLength / 2.0);
		StdDraw.setPenColor(192, 192, 192);
		if(debugLog) {
			System.out.println("Front ground filled");
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
		}
		for(int i = 0; i < boardSize; i++) {
			StdDraw.line(coordinate + (i * areaLength / ((double) boardSize - 1)), scaleY -coordinate,
					coordinate + (i * areaLength / ((double) boardSize - 1)), scaleY - areaLength - coordinate);
		}
		for(int i = 0; i < boardSize; i++) {
			StdDraw.line(coordinate,scaleY - coordinate - (i * areaLength / ((double) boardSize - 1)),
					areaLength + coordinate, scaleY - coordinate - (i * areaLength / ((double) boardSize - 1)));
		}
		if(debugLog) {
			System.out.println("Canvas drawn!");
		}
		StdDraw.show();
	}
	public void place(int x, int y, boolean isBlack) {
		double coordinate = (Math.min(sizeX, sizeY)) * 0.15;
		double areaLength = (Math.min(sizeX, sizeY)) * 0.7;
		StdDraw.enableDoubleBuffering();
		if(isBlack) {
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledCircle(coordinate + (x * areaLength / ((double) boardSize - 1)),
					sizeY - coordinate - (y * areaLength / ((double) boardSize - 1)),
					(areaLength / ((double) boardSize * 2)) * 0.9);
			if(debugLog)
				System.out.println("Filled black chess at (" + x + ", " + y + ")");
		}
		else {
			StdDraw.setPenColor(192, 192, 255);
			StdDraw.filledCircle(coordinate + (x * areaLength / ((double) boardSize - 1)),
					sizeY - coordinate - (y * areaLength / ((double) boardSize - 1)),
					(areaLength / ((double) boardSize * 2)) * 0.9);
			if(debugLog)
				System.out.println("Filled white chess at (" + x + ", " + y + ")");
		}
		StdDraw.show();
	}
	public void drawPlayer(boolean isBlack) {
		double coordinate = sizeY * 0.08;
		double areaLength = (Math.min(sizeX, sizeY)) * 0.7;
		StdDraw.enableDoubleBuffering();
		if(isBlack) {
			StdDraw.setPenColor(0, 255, 255);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double) boardSize * 2)) * 1.1);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double) boardSize * 2)) * 0.9);
			StdDraw.setPenColor(255, 240, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double) boardSize * 2)) * 1.1);
			StdDraw.setPenColor(192, 192, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double) boardSize * 2)) * 0.9);
			StdDraw.show();
		}
		else {
			StdDraw.setPenColor(0, 255, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double) boardSize * 2)) * 1.1);
			StdDraw.setPenColor(192, 192, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double) boardSize * 2)) * 0.9);
			StdDraw.setPenColor(255, 240, 255);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double) boardSize * 2)) * 1.1);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double) boardSize * 2)) * 0.9);
			StdDraw.show();
		}
	}
	public void drawOptionsL(int positionX, int positionY, String text, int fontSize) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(255, 192, 225);
		StdDraw.filledRectangle(positionX, positionY, 185, 20);
		StdDraw.filledRectangle(positionX, positionY, 170, 35);
		StdDraw.filledCircle(positionX - 170, positionY - 20, 15);
		StdDraw.filledCircle(positionX + 170, positionY - 20, 15);
		StdDraw.filledCircle(positionX - 170, positionY + 20, 15);
		StdDraw.filledCircle(positionX + 170, positionY + 20, 15);
		StdDraw.setPenColor(192, 255, 255);
		StdDraw.filledRectangle(positionX, positionY, 180, 20);
		StdDraw.filledRectangle(positionX, positionY, 170, 30);
		StdDraw.filledCircle(positionX - 170, positionY - 20, 10);
		StdDraw.filledCircle(positionX + 170, positionY - 20, 10);
		StdDraw.filledCircle(positionX - 170, positionY + 20, 10);
		StdDraw.filledCircle(positionX + 170, positionY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(positionX, positionY, text);
		StdDraw.show();
	}
	public void drawOptionsS(int positionX, int positionY, String text, int fontSize) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(255, 192, 225);
		StdDraw.filledRectangle(positionX, positionY, 85, 20);
		StdDraw.filledRectangle(positionX, positionY, 70, 35);
		StdDraw.filledCircle(positionX - 70, positionY - 20, 15);
		StdDraw.filledCircle(positionX + 70, positionY - 20, 15);
		StdDraw.filledCircle(positionX - 70, positionY + 20, 15);
		StdDraw.filledCircle(positionX + 70, positionY + 20, 15);
		StdDraw.setPenColor(192, 255, 255);
		StdDraw.filledRectangle(positionX, positionY, 80, 20);
		StdDraw.filledRectangle(positionX, positionY, 70, 30);
		StdDraw.filledCircle(positionX - 70, positionY - 20, 10);
		StdDraw.filledCircle(positionX + 70, positionY - 20, 10);
		StdDraw.filledCircle(positionX - 70, positionY + 20, 10);
		StdDraw.filledCircle(positionX + 70, positionY + 20, 10);
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(positionX, positionY, text);
		StdDraw.show();
	}
	public void drawTitle(int positionX, int positionY, String text, int fontSize) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(0, 0, 0);
		Font font = new Font("Microsoft JhengHei", Font.BOLD ,fontSize);
		StdDraw.setFont(font);
		StdDraw.text(positionX, positionY, text);
		StdDraw.show();
	}


	public static void main(String[] args) {
		GUI test = new GUI(450,250);
		test.generateExitSaveReminderWindows();
		test.drawExitSaveReminder();
		StdDraw.show();
	}
}


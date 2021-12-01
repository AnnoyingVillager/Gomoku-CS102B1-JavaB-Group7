import java.awt.*;

public class GUI {
	private int resolutionX;
	private int resolutionY;
	private Boolean debugLog = false;
	private int num;

	public GUI() {
		resolutionX = 720;
		resolutionY = 720;
		num = 15;
	}
	public GUI(boolean debugLog) {
		resolutionX = 720;
		resolutionY = 720;
		this.debugLog = debugLog;
		num = 15;
	}
	public GUI(int resolutionX, int resolutionY) {
		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
		num = 15;
	}
	public GUI(int resolutionX, int resolutionY, int num, boolean debugLog) {
		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
		this.debugLog = debugLog;
		this.num = num;
		if(debugLog) {
			System.out.println("board size is set to " + this.num + " x " + this.num);
		}
	}

	public void drawMenu(Color backgroundColor) {
		StdDraw.setCanvasSize(resolutionX, resolutionY);
		StdDraw.setXscale(0, resolutionX);
		StdDraw.setYscale(0, resolutionY);
		StdDraw.setPenColor(backgroundColor);
		StdDraw.enableDoubleBuffering();
		if(debugLog) {
			System.out.println("Menu canvas size is set to " + resolutionX + " x " + resolutionY);
			System.out.println("X scale is set from 0 to " + resolutionX);
			System.out.println("Y scale is set from 0 to " + resolutionY);
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
			System.out.println("Enable Double Buffering");
		}
		StdDraw.filledRectangle(resolutionX / 2.0, resolutionY / 2.0,
		                 resolutionX / 2.0, resolutionY / 2.0);
		if(debugLog) {
			System.out.println("Background filled");
		}
		StdDraw.show();
		if(debugLog) {
			System.out.println("Menu canvas drawn!");
		}
	}
	public void drawCanvas() {
		StdDraw.setCanvasSize(resolutionX, resolutionY);
		StdDraw.setXscale(0, resolutionX);
		StdDraw.setYscale(0, resolutionY);
		StdDraw.setPenColor(245, 245, 245);
		StdDraw.enableDoubleBuffering();
		if(debugLog) {
			System.out.println("Canvas size is set to " + resolutionX + " x " + resolutionY);
			System.out.println("X scale is set from 0 to " + resolutionX);
			System.out.println("Y scale is set from 0 to " + resolutionY);
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
			System.out.println("Enable Double Buffering");
		}
		StdDraw.filledRectangle(resolutionX / 2.0, resolutionY / 2.0,
		                 resolutionX / 2.0, resolutionY / 2.0);
		StdDraw.setPenColor(255, 255, 255);
		if(debugLog) {
			System.out.println("Background filled");
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
		}
		double coordinate = (Math.min(resolutionX, resolutionY)) * 0.15;
		double areaLength = (Math.min(resolutionX, resolutionY)) * 0.7;
		StdDraw.filledRectangle(coordinate + areaLength / 2.0, resolutionY - coordinate - areaLength / 2.0,
						 areaLength / 2.0, areaLength / 2.0);
		StdDraw.setPenColor(192, 192, 192);
		if(debugLog) {
			System.out.println("Front ground filled");
			System.out.println("Pen color is set to " + StdDraw.getPenColor());
		}
		for(int i = 0; i < num; i++) {
			StdDraw.line(coordinate + (i * areaLength / ((double)num - 1)), resolutionY -coordinate,
			 coordinate + (i * areaLength / ((double)num - 1)), resolutionY - areaLength - coordinate);
		}
		for(int i = 0; i < num; i++) {
			StdDraw.line(coordinate,resolutionY - coordinate - (i * areaLength / ((double)num - 1)),
			 areaLength + coordinate, resolutionY - coordinate - (i * areaLength / ((double)num - 1)));
		}
		if(debugLog) {
			System.out.println("Canvas drawn!");
		}
		StdDraw.show();
	}
	public void drawCanvas( int scaleX, int scaleY, Color backgroundColor, Color frontGroundColor) {
		StdDraw.setCanvasSize(resolutionX, resolutionY);
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
		for(int i = 0; i < num; i++) {
			StdDraw.line(coordinate + (i * areaLength / ((double)num - 1)), scaleY -coordinate,
			 coordinate + (i * areaLength / ((double)num - 1)), scaleY - areaLength - coordinate);
		}
		for(int i = 0; i < num; i++) {
			StdDraw.line(coordinate,scaleY - coordinate - (i * areaLength / ((double)num - 1)),
			 areaLength + coordinate, scaleY - coordinate - (i * areaLength / ((double)num - 1)));
		}
		if(debugLog) {
			System.out.println("Canvas drawn!");
		}
		StdDraw.show();
	}
	public void place(int x, int y, boolean isBlack) {
		double coordinate = (Math.min(resolutionX, resolutionY)) * 0.15;
		double areaLength = (Math.min(resolutionX, resolutionY)) * 0.7;
		StdDraw.enableDoubleBuffering();
		if(isBlack) {
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledCircle(coordinate + (x * areaLength / ((double)num - 1)),
			                     resolutionY - coordinate - (y * areaLength / ((double)num - 1)),
			                 (areaLength / ((double)num * 2)) * 0.9);
			if(debugLog)
				System.out.println("Filled black chess at (" + x + ", " + y + ")");
		}
		else {
			StdDraw.setPenColor(192, 192, 255);
			StdDraw.filledCircle(coordinate + (x * areaLength / ((double)num - 1)),
			                     resolutionY - coordinate - (y * areaLength / ((double)num - 1)),
			                 (areaLength / ((double)num * 2)) * 0.9);
			if(debugLog)
				System.out.println("Filled white chess at (" + x + ", " + y + ")");
		}
		StdDraw.show();
	}
	public void drawPlayer(boolean isBlack) {
		double coordinate = resolutionY * 0.08;
		double areaLength = (Math.min(resolutionX, resolutionY)) * 0.7;
		StdDraw.enableDoubleBuffering();
		if(isBlack) {
			StdDraw.setPenColor(0, 255, 255);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double)num * 2)) * 1.1);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double)num * 2)) * 0.9);
			StdDraw.setPenColor(255, 240, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double)num * 2)) * 1.1);
			StdDraw.setPenColor(192, 192, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double)num * 2)) * 0.9);
			StdDraw.show();
		}
		else {
			StdDraw.setPenColor(0, 255, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double)num * 2)) * 1.1);
			StdDraw.setPenColor(192, 192, 255);
			StdDraw.filledCircle(520, coordinate, (areaLength / ((double)num * 2)) * 0.9);
			StdDraw.setPenColor(255, 240, 255);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double)num * 2)) * 1.1);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledCircle(120, coordinate, (areaLength / ((double)num * 2)) * 0.9);
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
	//Do not use these methods! They can not use multi-thread.
	/* public void drawTimer(int fontSize) {
		double coordinate = resolutionY * 0.94;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		while(true) {
			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 2.0, coordinate,
			                 resolutionX / 4.0, resolutionY / 25.0);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.text(resolutionX / 2.0, coordinate, "Time spent: " + Timer.timeSpent());
			StdDraw.show();
			StdDraw.pause(100);
		}
	}
	public void drawTimerB(int fontSize) {
		double coordinate = resolutionY * 0.06;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		while(true) {
			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 2.0, coordinate,
			                 resolutionX / 4.0, resolutionY / 25.0);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.text(resolutionX / 2.0, coordinate, "Time spent: " + Timer.timeSpent());
			StdDraw.show();
			StdDraw.pause(100);
		}
	}
	 */
	public static void main(String[] args) throws InterruptedException {
		GUI gui = new GUI(1280, 720, 17,true);
		GUI gui2 = new GUI(540, 720, 17,true);
		Color bg = new Color(255, 245, 255);
		Color fg = new Color(255, 255, 245);
		gui2.drawMenu(bg);
		gui.drawTitle(270, 640, "Gomoku GUI Test", 40);
		gui.drawOptionsS(168, 150, "Option 4", 28);
		gui.drawOptionsS(372, 150, "Option 5", 28);
		gui.drawOptionsL(270, 270, "Option 3", 28);
		gui.drawOptionsL(270, 390, "Option 2", 28);
		gui.drawOptionsL(270, 510, "Option 1", 28);
		StdDraw.pause(3000);
		gui.drawCanvas(1280, 720, bg, fg);
		gui.drawTitle(1000, 640, "Gomoku GUI Test", 40);
		gui.drawOptionsS(898, 150, "Option 4", 28);
		gui.drawOptionsS(1102, 150, "Option 5", 28);
		gui.drawOptionsL(1000, 270, "Option 3", 28);
		gui.drawOptionsL(1000, 390, "Option 2", 28);
		gui.drawOptionsL(1000, 510, "Option 1", 28);
		gui.place(0, 0, false);
		gui.place(1, 1, true);
		gui.place(2, 2, false);
		gui.place(3, 3, true);
		gui.place(4, 4, false);
		gui.place(5, 5, true);
		gui.place(6, 6, false);
		gui.place(7, 7, true);
		gui.place(8, 8, false);
		gui.place(9, 9, true);
		gui.place(10, 10, false);
		gui.place(11, 11, true);
		gui.place(12, 12, false);
		gui.place(13, 13, true);
		gui.place(14, 14, false);
		gui.place(15, 15, true);
		gui.place(16, 16, false);
		Thread.sleep(200);
		Timer timer1 = new Timer(gui.resolutionX, gui.resolutionY, 24, 0);
		Timer timer2 = new Timer(gui.resolutionX, gui.resolutionY, 24, 1);
		Thread thread1 = new Thread(timer1);
		timer1.started();
		thread1.start();
		boolean b = true;
		while(true) {
			gui.drawPlayer(b);
			gui.drawPlayer(b);
			timer2.started();
			timer2.drawTimerLeft(24, gui.resolutionX, gui.resolutionY);
			Thread.sleep(1000);
			b = !b;
		}
		// System.out.println("Multiple thread timer");
	}
	// add other methods here
}
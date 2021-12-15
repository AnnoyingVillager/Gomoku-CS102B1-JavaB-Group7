import java.awt.*;
import java.text.SimpleDateFormat;

public class Timer extends Thread implements Runnable{
	private long startTime;
	private int resolutionX = 720;
	private int resolutionY = 720;
	private int fontSize = 24;
	private int runNum;
	private Thread t;
	private  long endTime;
	static boolean isPlaced;
	static boolean isEnd;

	public Timer() { }
	public Timer(int resolutionX, int resolutionY, int fontSize, int runNum) {
		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
		this.fontSize = fontSize;
		this.runNum = runNum;
	}

	public static boolean isEnd() {
		return isEnd;
	}
	public static boolean isPlaced() {
		return isPlaced;
	}
	public static void setPlaced(boolean b) {
		isPlaced = b;
	}
	public static void setEnd(boolean b) {
		isEnd = b;
	}
	public void start() {
		if (t == null) {
			t = new Thread (this, "threadName");
			t.start ();
		}
	}
	public String timeSpent() {
		if(startTime != 0) {
			SimpleDateFormat date = new SimpleDateFormat("mm:ss");
			return date.format(System.currentTimeMillis() - startTime);
		}
		return "Not started!";
	}
	public String timeLeft() {
		if(endTime - System.currentTimeMillis() >= 0) {
			SimpleDateFormat date = new SimpleDateFormat("mm:ss");
			return date.format(endTime - System.currentTimeMillis());
		}
		return "Time's up!";
	}
	public void started() {
		startTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis() + 30600; // Need time-delay to avoid performance issues
	}
	public void started(int millisSpent, int millisLeft) {
		startTime = System.currentTimeMillis() - millisSpent;
		endTime = System.currentTimeMillis() + millisLeft + 600; // Need time-delay to avoid performance issues
	}
	public int getTimeSpent() {
		return (int)(System.currentTimeMillis() - startTime);
	}
	public int getTimeLeft() {
		return (int)(endTime - System.currentTimeMillis());
	}
	@Override
	public void run() {
		switch (runNum) {
			case 0:
				drawTimer(fontSize ,resolutionX, resolutionY);
				break;
			case 1:
				try {
					drawTimerLeft(fontSize ,resolutionX, resolutionY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("runNum error");
				break;
		}

	}
	public void drawTimer(int fontSize, int resolutionX, int resolutionY) {
		double coordinate = resolutionY * 0.94;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		while(!isEnd) {
			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
			 150, resolutionY / 25.0);
			if(getTimeSpent() <= 1740000)
				StdDraw.setPenColor(0, 0, 0);
			else
				StdDraw.setPenColor(255, 0, 0);
			StdDraw.text(resolutionX / 4.0, coordinate, "Time spent: " + timeSpent());
			StdDraw.show();
			if(getTimeSpent() >= 1800000)
				break;
			StdDraw.pause(293); // use prime numbers to avoid performance issues
		}
		StdDraw.pause(800);
		StdDraw.setPenColor(255, 255, 225);
		StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
						 150, resolutionY / 25.0);
		StdDraw.setPenColor(255, 0, 0);
		StdDraw.text(resolutionX / 4.0, coordinate, "Game Over!");
		isEnd = true;
		StdDraw.show();
	}

	public void drawTimerLeft(int fontSize, int resolutionX, int resolutionY) throws InterruptedException {
		double coordinate = resolutionY * 0.06;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		StdDraw.pause(300);
		isEnd = false;
		while(!timeLeft().equals("Time's up!") && !isPlaced && !isEnd) {

			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
			 150, resolutionY / 25.0);
			if (getTimeLeft() >= 11000) {
				StdDraw.setPenColor(0, 0, 0);
			} else {
				// isPlaced = true; // test case
				StdDraw.setPenColor(255, 0, 0);
			}
			StdDraw.text(resolutionX / 4.0, coordinate, "Time left: " + timeLeft());
			StdDraw.show();
			StdDraw.pause(457);  // use prime numbers to avoid performance issues
		}
		if(!isPlaced) {
			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
					150, resolutionY / 25.0);
			StdDraw.setPenColor(255, 0, 0);
			StdDraw.text(resolutionX / 4.0, coordinate, "Time's up!");
			isEnd = true;
			System.out.println("Game Over");
			StdDraw.show();
			Thread.sleep(1000);
		}
		isPlaced = false;
	}
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.started();
		while(true) {
			System.out.println(timer.timeSpent());
			Thread.sleep(1000);
		}
	}
}
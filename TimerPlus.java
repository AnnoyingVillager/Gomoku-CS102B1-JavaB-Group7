import java.awt.*;
import java.text.SimpleDateFormat;

public class TimerPlus extends Thread implements Runnable{
	static int count = 0;
	private static boolean paused = false;
	private long startTime;
	private int resolutionX = 1280;
	private int resolutionY = 720;
	private int fontSize = 24;
	private int runNum;
	private int timeLeft;
	private int timeSpent;
	private Thread t;
	private  long endTime;
	static boolean isPlaced;
	static boolean isEnd;
	private boolean isStarted = false;
	private boolean isStart = false;

	public TimerPlus() {
		timeSpent = 0;
		timeLeft = 30600;
	}
	public TimerPlus(int resolutionX, int resolutionY, int fontSize, int runNum) {
		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
		this.fontSize = fontSize;
		this.runNum = runNum;
		timeSpent = 0;
		timeLeft = 30600;
	}

	public static boolean isEnd() {
		return isEnd;
	}
	public static boolean isPlaced() {
		return isPlaced;
	}
	public boolean isStarted() {
		return isStarted;
	}
	public boolean isStart() {
		return isStart;
	}
	public static void setPlaced(boolean b) {
		isPlaced = b;
	}
	public static void setEnd(boolean b) {
		isEnd = b;
	}
	public void setStarted(boolean b) {
		isStarted = b;
	}
	public void setStart(boolean b) {
		isStart = b;
	}

	public void start() {
		isStart = true;
		if (t == null) {
			t = new Thread (this, "threadName");
			t.start ();
		}
	}
	public String timeSpent() {
		if(startTime != 0) {
			SimpleDateFormat date = new SimpleDateFormat("mm:ss");
			// timeSpent = (int)(System.currentTimeMillis() - startTime);
			if(System.currentTimeMillis() - startTime > 1800000)
			{
				return "Time's up!";
			}
			return date.format(System.currentTimeMillis() - startTime);
		}
		return "Not started!";
	}
	public String timeLeft() {
		if(endTime - System.currentTimeMillis() >= 0) {
			SimpleDateFormat date = new SimpleDateFormat("mm:ss");
			// timeLeft = (int)(endTime - System.currentTimeMillis());
			return date.format(endTime - System.currentTimeMillis());
		}
		return "Time's up!";
	}
	public void started() {
		startTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis() + 30100; // Need time-delay to avoid performance issues
		isStarted = true;
	}
	public void started(int millisSpent, int millisLeft) {
		startTime = System.currentTimeMillis() - millisSpent;
		endTime = System.currentTimeMillis() + millisLeft + 100; // Need time-delay to avoid performance issues
		isStarted = true;
	}
	public void pause() {
		timeSpent = (int)(System.currentTimeMillis() - startTime);
		timeLeft = (int)(endTime - System.currentTimeMillis());
		paused = true;
		isStarted = false;
		isStart = false;
	}
	public void reset() {
		timeSpent = 0;
		timeLeft = 30600;
		paused = true;
		isStarted = false;
		isStart = false;
		isEnd = false;
		isPlaced = false;
	}

	public void restore() {
		timeSpent = (int)(System.currentTimeMillis() - startTime);
		timeLeft = 30600;
		paused = true;
		isStarted = false;
		isStart = false;
		isEnd = false;
		isPlaced = false;
		count++;
	}

	public boolean isPaused() {
		return paused;
	}

	public void startedOrContinue() {
		paused = false;
		isStarted = true;
		started(timeSpent, timeLeft);
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public int getTimeSpent() {
		return timeSpent;
	}
	public int getTimeLeft() {
		return timeLeft;
	}
	@Override
	public synchronized void run() {
		if(runNum == 0) {
			try {
				drawTimer(fontSize, resolutionX, resolutionY);
			} catch (InterruptedException e) {
				System.out.println("Paused");
			}
		}
		else if(runNum == 1) {
			try {
				drawTimerLeft(fontSize, resolutionX, resolutionY);
			} catch (InterruptedException e) {
				System.out.println("Paused");
			}
		}
		else
			System.out.println("runNum error");
	}
	public synchronized void drawTimer(int fontSize, int resolutionX, int resolutionY) throws InterruptedException {
		double coordinate = resolutionY * 0.94;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		Thread.sleep(79);
		if(!timeSpent().equals("Time's up!") && !isEnd) {
			StdDraw.setPenColor(235, 245, 245);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
			 150, resolutionY / 25.0);
			if(System.currentTimeMillis() - startTime <= 1740000) {
				StdDraw.setPenColor(0, 0, 0);
			}
			else {
				StdDraw.setPenColor(255, 0, 0);
			}
			StdDraw.text(resolutionX / 4.0, coordinate, "Time spent: " + timeSpent());
			StdDraw.show();
			Thread.sleep(83); // use prime numbers to avoid performance issues
		}
		else {
			StdDraw.setPenColor(235, 245, 245);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
			 150, resolutionY / 25.0);
			StdDraw.setPenColor(255, 0, 0);
			StdDraw.text(resolutionX / 4.0, coordinate, "Game Over!");
			isEnd = true;
			isStarted = false;
			StdDraw.show();
		}
	}

	public synchronized void drawTimerLeft(int fontSize, int resolutionX, int resolutionY) throws InterruptedException {
		double coordinate = resolutionY * 0.06;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		Thread.sleep(87);
		if(!timeLeft().equals("Time's up!") && !isEnd) {
			StdDraw.setPenColor(235, 245, 245);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
			 150, resolutionY / 25.0);
			if (endTime - System.currentTimeMillis() >= 11000) {
				StdDraw.setPenColor(0, 0, 0);
			} else {
				// isPlaced = true; // test case
				StdDraw.setPenColor(255, 0, 0);
			}
			StdDraw.text(resolutionX / 4.0, coordinate, "Time left: " + timeLeft());
			StdDraw.show();
			Thread.sleep(91);  // use prime numbers to avoid performance issues
		}
		else {
			StdDraw.setPenColor(235, 245, 245);
			StdDraw.filledRectangle(resolutionX / 4.0, coordinate,
			 150, resolutionY / 25.0);
			StdDraw.setPenColor(255, 0, 0);
			// Thread.sleep(277);
			StdDraw.text(resolutionX / 4.0, coordinate, "Game Over!");
			// isStart = false;
			isStarted = false;
			isEnd = true;
			// System.out.println("Game Over");
			StdDraw.show();
			isPlaced = false;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		TimerPlus timer = new TimerPlus();
		timer.started();
		while(true) {
			System.out.println(timer.timeSpent());
			Thread.sleep(1000);
		}
	}
}
import java.awt.*;
import java.text.SimpleDateFormat;

public class Timer implements Runnable{
	private long startTime;
	private int resolutionX = 720;
	private int resolutionY = 720;
	private int fontSize = 24;
	private int runNum;
	private Thread t;
	private  long endTime;

	public Timer() { }
	public Timer(int resolutionX, int resolutionY, int fontSize, int runNum) {
		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
		this.fontSize = fontSize;
		this.runNum = runNum;
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
		endTime = System.currentTimeMillis() + 30500;
	}
	@Override
	public void run() {
		switch (runNum) {
			case 0:
				drawTimer(fontSize ,resolutionX, resolutionY);
				break;
			case 1:
				drawTimerLeft(fontSize ,resolutionX, resolutionY);
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
		StdDraw.pause(50);
		while(true) {
			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 2.0, coordinate,
			 resolutionX / 4.0, resolutionY / 25.0);
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.text(resolutionX / 2.0, coordinate, "Time spent: " + timeSpent());
			StdDraw.show();
			StdDraw.pause(1000);
		}
	}

	public void drawTimerLeft(int fontSize, int resolutionX, int resolutionY) {
		double coordinate = resolutionY * 0.06;
		Font font = new Font("Microsoft JhengHei", Font.PLAIN ,fontSize);
		StdDraw.setFont(font);
		int i = 30;
		while(!timeLeft().equals("Time's up!")) {
			StdDraw.setPenColor(255, 255, 225);
			StdDraw.filledRectangle(resolutionX / 2.0, coordinate,
			 resolutionX / 4.0, resolutionY / 25.0);
			if (i > 10) {
				StdDraw.setPenColor(0, 0, 0);
			} else {
				StdDraw.setPenColor(255, 0, 0);
			}
			StdDraw.text(resolutionX / 2.0, coordinate, "Time left: " + timeLeft());
			StdDraw.show();
			StdDraw.pause(1000);
			i--;
		}
		StdDraw.setPenColor(255, 255, 225);
		StdDraw.filledRectangle(resolutionX / 2.0, coordinate,
		                 resolutionX / 4.0, resolutionY / 25.0);
		StdDraw.setPenColor(255, 0, 0);
		StdDraw.text(resolutionX / 2.0, coordinate, "Time's up!");
		System.out.println("Game Over");
		StdDraw.show();
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
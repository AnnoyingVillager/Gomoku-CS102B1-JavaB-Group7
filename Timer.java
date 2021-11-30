import java.awt.*;
import java.text.SimpleDateFormat;

public class Timer implements Runnable{
	private static long startTime;
	private int resolutionX = 720;
	private int resolutionY = 720;
	private int fontSize = 24;
	private int runNum;
	private Thread t;

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
	public static String timeSpent() {
		if(startTime != 0) {
			SimpleDateFormat date = new SimpleDateFormat("mm:ss");
			return date.format(System.currentTimeMillis() - startTime);
		}
		return "Not started!";
	}
	public void started() {
		startTime = System.currentTimeMillis();
	}
	@Override
	public void run() {
		switch (runNum) {
			case 0:
				drawTimer(fontSize ,resolutionX, resolutionY);
				break;
			case 1:
				drawTimerB(fontSize ,resolutionX, resolutionY);
				break;
			default:
				System.out.println("runNum error");
				break;
		}

	}
	public static void drawTimer(int fontSize, int resolutionX, int resolutionY) {
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
			StdDraw.pause(1000);
		}
	}
	public static void drawTimerB(int fontSize, int resolutionX, int resolutionY) {
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
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(timeSpent());
	}
}

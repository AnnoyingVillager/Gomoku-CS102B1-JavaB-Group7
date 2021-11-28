public class Options {
	private static boolean forbidden; // switch to open or close the option of 3x3 forbidden
	private static boolean timer; // switch to open or close the option of time limit
	// add other options here

	public Options() {
		forbidden = true;
		timer = true;
	}
	public Options(boolean allowForbidden, boolean allowTimer) {
		forbidden = allowForbidden;
		timer = allowTimer;
	}

	public static boolean getForbidden() {
		return forbidden;
	}
	public static boolean getTimer() {
		return timer;
	}
	// add other methods here
}

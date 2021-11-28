public abstract class Events {
	public void forbidden(int status) {}
	public int scan(Board board) { return 0; } // 0-empty; 1-normal; 2-end by game; 3 forbidden
	public void end(Board board) {} // end by game or end by user
	public boolean exit() { return false; } // exit by user
	public void undo(int steps) {} // undo 1-3 steps
	public void placeChess(int positionX, int positionY) {}
	public void saveGame(Board board) {}
	// add other methods here
}

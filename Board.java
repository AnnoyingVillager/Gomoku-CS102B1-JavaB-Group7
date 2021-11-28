public class Board {
	private int size;
	private int[][] board;

	public Board() {
		size = 15;
		board = new int[size][size];
	}
	public Board(int size) {
		this.size = size;
		board = new int[size][size];
	}

	// add other methods here
}

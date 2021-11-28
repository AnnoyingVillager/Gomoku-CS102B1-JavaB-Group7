public class Game {
	Player blackPlayer;
	Player whitePlayer;
	private int turn; // 0 for black player's turn, 1 for white player's
	public Game(Player blackPlayer, Player whitePlayer) {
		this.blackPlayer = blackPlayer;
		this.whitePlayer = whitePlayer;
		turn = 0;
	}

	// add other methods here
}

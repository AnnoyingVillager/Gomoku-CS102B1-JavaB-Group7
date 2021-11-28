public class Player {
	private String name;
	private Picture profilePicture; // 头像
	private static int playerCnt = 0;

	public Player() {
		name = "Player" + (++playerCnt);
		profilePicture = new Picture("default.png");
	}
	public Player(String playerName, Picture picture) {
		name = playerName;
		profilePicture = picture;
	}

	// add other methods here
}

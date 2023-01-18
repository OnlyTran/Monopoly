import java.util.*;

public class chance extends gameboard {
	private String[][] cards = new String[3][5];

	public chance() {
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				cards[i][j] = null;
			}
		}
	}

	public void getChance() {
		Random rand = new Random();

		int row = rand.nextInt(3) + 1;
		int column = rand.nextInt(5) + 1;
		
		System.out.println(cards[row][column]);
	}
	
	
}

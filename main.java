
import java.util.*;

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int menu;

		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Menu:");
			System.out.println("0. Exit");
			System.out.println("1. Instructions");
			System.out.println("2. Play Game");
			System.out.println("Enter choice: ");
			menu = input.nextInt();
			input.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			if (menu == 1) {
				System.out.println("Welcome to Monopoly: Coder Edition!");
				System.out.println("This game works the exact same way as normal monopoly.");
				System.out.println("The difference is that instead of buying property, ");
				System.out.println("You're buying experience from the brands");
				System.out.println("With this, you'll be able to charge others for your lesson if they land on it.");
				System.out.println("Every lap around the board will give you your monthly paycheck.");
				System.out.println("You can also save your game when it's your turn.");
				System.out.println("Enjoy the game!");
			} else if (menu == 2) {
				gamemenu();
			} else if (menu == 3) { // USED TO BE WHERE LOAD FILE WAS
				// Read all the files and put it back
				// Make separate save files for each class
				// Use a toString method in each class to save and display all
				// info
			}

			System.out.println("Enter to continue...");
			input.nextLine();
		} while (menu != 0);
	}

	public static void game() {
		Scanner input = new Scanner(System.in);
		player[] p = new player[2];
		System.out.println("Enter player one name: ");
		String one = input.nextLine();
		p[0] = new player(one);
		System.out.println("Enter player two name: ");
		String two = input.nextLine();
		p[1] = new player(two);

		gameboard[][] board = new gameboard[8][8];

		// Construct the blank objects in the middle of the arrray (middle of
		// board)
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (i != 0 && i != 7) {
					if (j != 0 && j != 7) {
						board[i][j] = new gameboard();
						board[i][j].setPosition(i, j);
					}
				}
			}
		}
		// Name, row, column
		board[0][0] = new gameboard("G", 0, 0); // GO
		board[0][1] = new brand(); // Property (Alphabet Inc)
		board[0][1].setDisplay("B");
		board[0][1].setPosition(0, 1);
		board[0][2] = new chance(); // Chance card
		board[0][2].setDisplay("?");
		board[0][2].setPosition(0, 2);
		board[0][3] = new brand(); // Property (Alphabet Inc)
		board[0][3].setDisplay("B");
		board[0][3].setPosition(0, 3);
		board[0][4] = new gameboard("T", 0, 4); // Tax
		board[0][5] = new gameboard("T", 0, 5); // Tax
		board[0][6] = new brand(); // Property (Alphabet Inc)
		board[0][6].setDisplay("B");
		board[0][6].setPosition(0, 6);
		board[0][7] = new gameboard("J", 0, 7); // Jail visit
		board[1][0] = new gameboard("T", 1, 0); // Tax
		board[2][0] = new gameboard(); // Property (Amazon)
		board[2][0].setDisplay("B");
		board[2][0].setPosition(2, 0);
		board[3][0] = new chance(); // Chance
		board[3][0].setDisplay("?");
		board[3][0].setPosition(3, 0);
		board[4][0] = new gameboard(); // Property (Amazon)
		board[4][0].setDisplay("B");
		board[4][0].setPosition(4, 0);
		board[5][0] = new gameboard();// Property (Amazon)
		board[5][0].setDisplay("B");
		board[5][0].setPosition(5, 0);
		board[6][0] = new gameboard("T", 6, 0); // Tax
		board[1][7] = new brand(); // Property (Microsoft)
		board[1][7].setDisplay("B");
		board[1][7].setPosition(1, 7);
		board[2][7] = new chance(); // Chance
		board[2][7].setDisplay("?");
		board[2][7].setPosition(2, 7);
		board[3][7] = new brand(); // Property (Microsoft)
		board[3][7].setDisplay("B");
		board[3][7].setPosition(3, 7);
		board[4][7] = new chance(); // Chance
		board[4][7].setDisplay("?");
		board[4][7].setPosition(4, 7);
		board[5][7] = new brand(); // Property (Microsoft)
		board[5][7].setDisplay("B");
		board[5][7].setPosition(5, 7);
		board[6][7] = new brand(); // Property (Microsoft)
		board[6][7].setDisplay("B");
		board[6][7].setPosition(6, 7);
		board[7][0] = new gameboard("A", 7, 0); // Go to jail (Arrested)
		board[7][1] = new brand(); // Property (Sony)
		board[7][1].setDisplay("B");
		board[7][1].setPosition(7, 1);
		board[7][2] = new chance(); // Chance
		board[7][2].setDisplay("?");
		board[7][2].setPosition(7, 2);
		board[7][3] = new gameboard("T", 7, 3); // Tax
		board[7][4] = new brand(); // Property (Sony)
		board[7][4].setDisplay("B");
		board[7][4].setPosition(7, 4);
		board[7][5] = new brand(); // Property (Sony)
		board[7][5].setDisplay("B");
		board[7][5].setPosition(7, 5);
		board[7][6] = new chance(); // Chance
		board[7][6].setDisplay("?");
		board[7][6].setPosition(7, 6);
		board[7][7] = new gameboard("P", 7, 7); // Free parking
		boolean exit = false;
		String[][] display = new String[board.length][board[0].length];
		printBoard(board, p, display);
		// setPlayers(board, p[i], p2, display);
		do {
			for (int i = 0; i < p.length; i++) {
				System.out.println(p[i].getName() + "'s Menu:");

				System.out.println("0. Save and Exit");
				System.out.println("1. Roll");
				System.out.println("2. Display Board");
				System.out.println("3. Load Save File");
				System.out.println("Enter choice: ");
				int choice = input.nextInt();
				input.nextLine();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				if (choice == 1) {

					int roll = roll();
					int x;
					int y;
					int sum = 0;
					int diff = 0;
					System.out.println("You rolled a " + roll);
					// Check if player is on rightmost column
					if (p[i].getColumn() == 7) {
						sum = (p[i].getRow() + roll);
						if (sum > 7) {
							p[i].setRow(7);
							diff = sum - 7;
							p[i].setColumn(7 - diff);
						} else {
							p[i].setRow(sum);
						}
					}
					// Check if player is on bottom row
					else if (p[i].getRow() == 7) {
						sum = (p[i].getColumn() + roll);
						if (sum > 7) {
							p[i].setColumn(0);
							diff = sum - 7;
							p[i].setRow(7 - diff);
						} else {
							p[i].setColumn(7 - sum);
						}
					}
					// Check if player is on leftmost column
					else if (p[i].getColumn() == 0) {
						diff = (p[i].getRow() - roll);
						if (diff < 0) {
							p[i].setRow(0);
							diff = diff * -1;
							p[i].setColumn(diff);
						} else {
							p[i].setRow(diff);
						}
					}
					// Check if player is on top row
					else if (p[i].getRow() == 0) {
						sum = (p[i].getColumn() + roll);
						if (sum > 7) {
							p[i].setColumn(7);
							diff = sum - 7;
							p[i].setRow(diff);
						} else {
							p[i].setColumn(sum);
						}
					}
					// setPlayers(board, p, display);
					printBoard(board, p, display);
				} else if (choice == 2) {
					printBoard(board, p, display);
				} else if (choice == 3) {
					System.out.println("WIP");
				} else if (choice == 0) {
					System.out.println("WIP");
					exit = true;
				}
			}
		} while (win(p) != true && exit != true);

		// Use a for loop to compare everything inside of the gameboard
		// Do if statement to see compare the positions of the player and board
		// object
		// Nest another if statement to get the String of each individual object
		// (Make a
		// method inside of the class to display what type of object it is)
		// Use the .equals string method to compare
		// End the for loop immediately after completing
	}

	public static int roll() {
		Random rand = new Random();

		return rand.nextInt(6) + 1;
	}

	public static void setPlayers(gameboard[][] board, player[] p, String[][] display) {
		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[i].length; j++) {

				if (p[0].getRow() == board[i][j].getRow() && p[0].getColumn() == board[i][j].getColumn()) {
					display[i][j] = "1";
				} else if ((p[1].getRow() == board[i][j].getRow()) && (p[1].getColumn() == board[i][j].getColumn())) {

					display[i][j] = "2";
				}

			}
		}
	}

	public static void printBoard(gameboard[][] board, player[] p, String[][] display) {
		System.out.println("P1 Spots: " + p[0].getRow() + ", " + p[0].getColumn());
		System.out.println("P2 Spots: " + p[1].getRow() + ", " + p[1].getColumn());
		    //loop through the display array and set the values to the corresponding board values
			for (int i = 0; i < display.length; i++) {
				for (int j = 0; j < display[i].length; j++) {
					if (i == p[0].getRow() && j == p[0].getColumn()) {
						display[i][j] = "1";
					} else if (i == p[1].getRow() && j == p[1].getColumn()) {
						display[i][j] = "2";
					} else {
						display[i][j] = board[i][j].getDisplay();
					}
				}
			}
			//print the display array
			System.out.println("Only see one player: Both players are on the spot");
			System.out.println("1: Player One");
			System.out.println("2: Player Two");
			System.out.println("G: GO!");
			System.out.println("B: Brand (Property)");
			System.out.println("?: Chance");
			System.out.println("T: Tax");
			System.out.println("J: Visit Jail/Jail");
			System.out.println("P: Free Parking");
			System.out.println("A: Get Arrested");
			for (int i = 0; i < display.length; i++) {
				for (int j = 0; j < display[i].length; j++) {
					System.out.print(display[i][j] + "   ");
				}
				System.out.println();
			}
	}

	public static boolean win(player[] p) {
		if (p[0].getMoney() < 1 || p[1].getMoney() < 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void classic() {
		game();
	}

	public static void turn() {
		Scanner input = new Scanner(System.in);
		// System.out.println("How many turns do you want?: ");
		// int turns = input.nextInt();

		System.out.println("WIP");
	}

	public static void gamemenu() {
		Scanner input = new Scanner(System.in);
		int gamemenu;

		System.out.println("Game Menu:");
		System.out.println("0. Exit");
		System.out.println("1. Mode Differences");
		System.out.println("2. Classic Mode");
		System.out.println("3. Turn Mode");
		System.out.println("Enter choice: ");
		gamemenu = input.nextInt();
		input.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		if (gamemenu == 1) {
			System.out.println("The classic mode works as classic Monopoly,");
			System.out.println("The game ends when only one person has money.");
			System.out.println("The turn mode ends the game at a set amount of turns set by the player.");
			System.out.println("At the end, the person with the most money wins.");
		} else if (gamemenu == 2) {
			classic();
		} else if (gamemenu == 3) {
			turn();
		} else if (gamemenu != 0) {
			System.out.println("Enter to continue...");
			input.nextLine();
		}

	}
}

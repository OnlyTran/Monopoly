import java.io.*;
import java.util.*;

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int menu;

		do { // Main menu
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Menu:");
			System.out.println("0. Exit");
			System.out.println("1. Instructions");
			System.out.println("2. Play Game");
			System.out.println("Enter choice: ");
			menu = input.nextInt();
			input.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			if (menu == 1) { // If they choose the tutorial
				System.out.println("Welcome to Monopoly: Coder Edition!");
				System.out.println("This game works the exact same way as normal monopoly.");
				System.out.println("The difference is that instead of buying property, ");
				System.out.println("You're buying experience from the brands");
				System.out.println("With this, you'll be able to charge others for your lesson if they land on it.");
				System.out.println("Every lap around the board will give you your monthly paycheck.");
				System.out.println("You can also save your game when it's your turn.");
				System.out.println("Enjoy the game!");
			} else if (menu == 2) { // If they choose to play
				game();
			} else if (menu == 0) { // If they choose to exit
				System.out.println("Goodbye and thanks for playing!");
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
		board[0][1] = new brand("Fitbit", 50, 40); // Property (Alphabet Inc)
		board[0][1].setDisplay("B");
		board[0][1].setPosition(0, 1);
		board[0][2] = new gameboard("?", 0, 2); // Chance card
		board[0][3] = new brand("Youtube", 40, 30); // Property (Alphabet Inc)
		board[0][3].setDisplay("B");
		board[0][3].setPosition(0, 3);
		board[0][4] = new gameboard("T", 0, 4); // Tax
		board[0][5] = new gameboard("T", 0, 5); // Tax
		board[0][6] = new brand("Nest", 100, 70); // Property (Alphabet Inc)
		board[0][6].setDisplay("B");
		board[0][6].setPosition(0, 6);
		board[0][7] = new gameboard("J", 0, 7); // Jail visit
		board[1][0] = new gameboard("T", 1, 0); // Tax
		board[2][0] = new brand("Twitch", 60, 45); // Property (Amazon)
		board[2][0].setDisplay("B");
		board[2][0].setPosition(2, 0);
		board[3][0] = new gameboard("?", 3, 0); // Chance
		board[4][0] = new brand("IMDb", 30, 20); // Property (Amazon)
		board[4][0].setDisplay("B");
		board[4][0].setPosition(4, 0);
		board[5][0] = new brand("Presto", 25, 20);// Property (Amazon)
		board[5][0].setDisplay("B");
		board[5][0].setPosition(5, 0);
		board[6][0] = new gameboard("T", 6, 0); // Tax
		board[1][7] = new brand("GitHub", 65, 50); // Property (Microsoft)
		board[1][7].setDisplay("B");
		board[1][7].setPosition(1, 7);
		board[2][7] = new gameboard("?", 2, 7); // Chance
		board[3][7] = new brand("LinkedIn", 40, 60); // Property (Microsoft)
		board[3][7].setDisplay("B");
		board[3][7].setPosition(3, 7);
		board[4][7] = new gameboard("?", 4, 7); // Chance
		board[5][7] = new brand("Mojang", 20, 50); // Property (Microsoft)
		board[5][7].setDisplay("B");
		board[5][7].setPosition(5, 7);
		board[6][7] = new brand("Skype", 60, 100); // Property (Microsoft)
		board[6][7].setDisplay("B");
		board[6][7].setPosition(6, 7);
		board[7][0] = new gameboard("A", 7, 0); // Go to jail (Arrested)
		board[7][1] = new brand("Facebook", 50, 60); // Property (Meta)
		board[7][1].setDisplay("B");
		board[7][1].setPosition(7, 1);
		board[7][2] = new gameboard("?", 7, 2); // Chance
		board[7][3] = new gameboard("T", 7, 3); // Tax
		board[7][4] = new brand("Instagram", 20, 15); // Property (Meta)
		board[7][4].setDisplay("B");
		board[7][4].setPosition(7, 4);
		board[7][5] = new brand("WhatsApp", 25, 30); // Property (Meta)
		board[7][5].setDisplay("B");
		board[7][5].setPosition(7, 5);
		board[7][6] = new gameboard("?", 7, 6); // Chance
		board[7][7] = new gameboard("P", 7, 7); // Free parking
		boolean exit = false;
		String[][] display = new String[board.length][board[0].length];
		printBoard(board, p, display);
		System.out.println("Enter to continue...");
		input.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		int choice = -1;
		boolean passgo = false;
		do {
			for (int i = 0; i < p.length; i++) {
				do {
					if (i < p.length) {
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						if (p[i].isArrested() == false) {
							System.out.println(p[i].getName() + "'s Menu:");
							System.out.println("0. Save and Exit");
							System.out.println("1. Roll");
							System.out.println("2. Check stats");
							System.out.println("3. Load Save File");
							System.out.println("Enter choice: ");
							choice = input.nextInt();
							input.nextLine();
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

							if (choice == 1) {
								// Use a for loop to compare everything inside of the
								// gameboard
								// Do if statement to see compare the positions of the
								// player and board
								// Nest another if statement to get the String of each
								// individual object
								// (Make a method inside of the class to display what type
								// of object it is)
								// Use the .equals string method to compare
								// End the for loop immediately after completing
								if (i != 0) {
									passgo = setPosition(p[i]);
								} else {
									setPosition(p[i]);
								}
								printBoard(board, p, display);
								System.out.println("Enter to continue...");
								input.nextLine();
								System.out.println(
										"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								if (passgo) {
									System.out.println("You just got your monthly paycheck!");
									System.out.println("Heres $150!");
									p[i].addMoney(150);
									System.out.println("Enter to continue...");
									input.nextLine();
									System.out.println(
											"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								}
								for (int j = 0; j < board.length; j++) {
									for (int k = 0; k < board[j].length; k++) {
										if ((p[i].getRow() == board[j][k].getRow())
												&& (p[i].getColumn() == board[j][k].getColumn())) {
											String objecttype = board[j][k].getDisplay();
											if (objecttype.equalsIgnoreCase("B")) { // Landed
																					// on
																					// Brand
												boolean notvalid = false;
												// Linked list should hold objects
												System.out.println("You landed on a brand!");
												System.out.println("Enter to continue...");
												input.nextLine();
												if (((brand) board[j][k]).isBought() == false) {
													System.out.println(
															"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													System.out.println(board[j][k].toString());
													System.out.println("Would you like to learn from this brand?: ");
													String brandchoice = input.nextLine();

													if (brandchoice.equalsIgnoreCase("yes")
															|| brandchoice.equalsIgnoreCase("y")) {
														if (p[i].getMoney() > ((brand) board[j][k]).getMoney()) {
															((brand) board[j][k]).buy();
															p[i].subtractMoney(((brand) board[j][k]).getMoney());
															p[i].addProperty((brand) board[j][k]);
															((brand) board[j][k]).setOwner(p[i].getName());
															System.out.println("You learned so much about Java!");
														} else {
															System.out.println("You don't have enough money!");
														}
													} else if (brandchoice.equalsIgnoreCase("no")
															|| brandchoice.equalsIgnoreCase("n")) {
														System.out.println(":(");
													} else {
														System.out.println("This isn't a valid answer!");
														System.out.println("Enter to continue...");
														input.nextLine();
														notvalid = true;
													}
												} else {
													System.out.println("Uh oh! You landed on someones brand.");
													System.out.println(
															"Its time to pay up: $"
																	+ (((brand) board[j][k]).getLessons()));
													p[i].subtractMoney(((brand) board[j][k]).getLessons());
													if (i == 0) {
														p[1].addMoney(((brand) board[j][k]).getLessons());
													} else {
														p[0].addMoney(((brand) board[j][k]).getLessons());
													}
													System.out.println("The other player gets $"
															+ ((brand) board[j][k]).getLessons());
												}
											} else if (objecttype.equalsIgnoreCase("?")) { // Landed on chance
												System.out.println("Oh? A chance...");
												System.out.println("Enter to continue...");
												input.nextLine();
												if (board[j][k].getRow() == 0 && board[j][k].getColumn() == 2) {
													System.out.println("Woah your code got so famous!");
													System.out.println("You got $200!");
													p[i].addMoney(200);
												} else if (board[j][k].getRow() == 2 && board[j][k].getColumn() == 7) {
													System.out.println("Oh no! Your parents forced you to go outside.");
													System.out.println("You can't code for 3 days :(");
													p[i].Arrest();
												} else if (board[j][k].getRow() == 4 && board[j][k].getColumn() == 7) {
													System.out.println(
															"You got stuck on this code for so long you paid your way to solve it.");
													System.out.println("You paid $25, ouch a steep price.");
													p[i].subtractMoney(25);
												} else if (board[j][k].getRow() == 7 && board[j][k].getColumn() == 2) {
													System.out
															.println("Lucky you! You get to travel back to the start.");
													p[i].setRow(0);
													p[i].setColumn(0);
												} else if (board[j][k].getRow() == 7 && board[j][k].getColumn() == 6) {
													System.out.println("You get to go to free parking.");
													p[i].setRow(7);
													p[i].setColumn(7);
												} else if (board[j][k].getRow() == 3 && board[j][k].getColumn() == 0) {
													System.out.println("Electricity bill came in.");
													System.out.println("YOu paid $20");
													p[i].subtractMoney(20);
												}
											} else if (objecttype.equalsIgnoreCase("T")) { // Landed
																							// on
																							// tax
												System.out.println("You landed on tax!");
												System.out.println("It's time to pay up $50");
												p[i].subtractMoney(50);
											} else if (objecttype.equalsIgnoreCase("A")) { // Landed
																							// on
																							// arrest
												System.out.println("Uh oh!");
												System.out.println("It's time to take a break and go outside.");
												System.out.println("You'll be out for 3 days.");
												p[i].Arrest();
												// Arrest the player
											} else { // Landed on blank space
												System.out.println("Peaceful...");
											}
											System.out.println("Enter to continue...");
											input.nextLine();
										}
									}
								}

							} else if (choice == 2) {
								System.out.println(p[i].toString());
								System.out.println("Enter to continue...");
								input.nextLine();
							} else if (choice == 3) {
								loadPlayerData(p);
								loadBrands(board, p);
							} else if (choice == 0) {
								savePlayerData(p);
								saveBrandData(board);
								exit = true;
								i = 10;
							}
						} else {
							if (p[i].getArrestedCount() < 3) {
								System.out.println("Your currently outside :(");
								System.out.println("This is day " + p[i].getArrestedCount() + " of torture...");
								p[i].addArrestedCount();
								System.out.println("Enter to continue...");
								input.nextLine();
							} else {
								System.out.println("Woohoo final day!");
								System.out.println("Happiness is close...");
								p[i].resetArrestedCount();
								p[i].resetArrest();
								System.out.println("Enter to continue...");
								input.nextLine();
							}
						}
					}
				} while (choice != 1 && choice != 0);
			}
		} while (win(p) != true && exit != true);
		if (exit == false) {
			if (p[0].getMoney() > p[1].getMoney()) {
				System.out.println(p[0].getName() + " wins!");
			} else {
				System.out.println(p[1].getName() + " wins!");
			}
			System.out.println(p[0].getName() + " had $" + p[0].getMoney());
			System.out.println(p[1].getName() + " had $" + p[1].getMoney());
		} else {
			System.out.println("Goodbye!");
		}
	}

	private static void loadBrands(gameboard[][] board, player[] p) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("branddata.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String name = data[0];
				boolean bought = Boolean.parseBoolean(data[1]);
				if (data.length > 2) {
					String ownerName = data[2];
					for (int i = 0; i < board.length; i++) {
						for (int j = 0; j < board[i].length; j++) {
							if (board[i][j].getDisplay().equalsIgnoreCase("B")) {
								if (((brand) board[i][j]).getName() == name) {
									if (p[0].getName().equalsIgnoreCase(ownerName)) {
										((brand) board[i][j]).buy();
										p[0].addProperty((brand) board[i][j]);
									} else {
										((brand) board[i][j]).buy();
										p[1].addProperty((brand) board[i][j]);
									}
								}
							}
						}
					}
					System.out.println("Brand files loaded");
				}
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadPlayerData(player[] p) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("playerdata.txt"));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				p[i].setName(data[0]);
				p[i].setMoney(Integer.parseInt(data[1]));
				p[i].setArrest(Boolean.parseBoolean(data[2]));
				p[i].setArrestedCount(Integer.parseInt(data[3]));
				p[i].setRow(Integer.parseInt(data[4]));
				p[i].setColumn(Integer.parseInt(data[5]));
				i++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Player files loaded!");
	}

	public static void saveBrandData(gameboard[][] board) {
		try {
			FileWriter fw = new FileWriter("branddata.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j].getDisplay().equalsIgnoreCase("B")) {
						brand b = (brand) board[i][j];
						bw.write(b.getName() + "," + b.isBought() + "," + b.getOwner());
						bw.newLine();
					}
				}
			}
			bw.close();
			fw.close();
			System.out.println("Brand data saved.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void savePlayerData(player[] p) {

		try {
			FileWriter fw = new FileWriter("playerdata.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			// Write player data to file
			for (int i = 0; i < p.length; i++) {
				bw.write(p[i].getName() + "," + p[i].getMoney() + "," + p[i].isArrested() + ","
						+ p[i].getArrestedCount() + "," + p[i].getRow() + ","
						+ p[i].getColumn());
				bw.newLine();
			}

			bw.close();
			System.out.println("Player data saved to file.");
		} catch (IOException e) {
			System.out.println("Error saving player data to file.");
			e.printStackTrace();
		}
	}

	public static boolean setPosition(player p) {
		int roll = roll();
		int sum = 0;
		int diff = 0;
		int prevRow = p.getRow();
		int prevColumn = p.getColumn();
		System.out.println("You rolled a " + roll);
		// Check if player is on rightmost column
		if (p.getColumn() == 7) {
			sum = (p.getRow() + roll);
			if (sum > 7) {
				p.setRow(7);
				diff = sum - 7;
				p.setColumn(7 - diff);
			} else {
				p.setRow(sum);
			}
		}
		// Check if player is on bottom row
		else if (p.getRow() == 7) {
			sum = (p.getColumn() + roll);
			if (sum > 7) {
				p.setColumn(0);
				diff = sum - 7;
				p.setRow(7 - diff);
			} else {
				p.setColumn(7 - sum);
			}
		}
		// Check if player is on leftmost column
		else if (p.getColumn() == 0) {
			diff = (p.getRow() - roll);
			if (diff < 0) {
				p.setRow(0);
				diff = diff * -1;
				p.setColumn(diff);
			} else {
				p.setRow(diff);
			}
		}
		// Check if player is on top row
		else if (p.getRow() == 0) {
			sum = (p.getColumn() + roll);
			if (sum > 7) {
				p.setColumn(7);
				diff = sum - 7;
				p.setRow(diff);
			} else {
				p.setColumn(sum);
			}
		}
		int row = p.getRow();
		int column = p.getColumn();
		boolean passgo = false;

		if (prevColumn == 0) {
			if (row == 0) {
				passgo = true;
			}
		} else {
			passgo = false;
		}
		return passgo;

	}

	public static int roll() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}

	public static void printBoard(gameboard[][] board, player[] p, String[][] display) {
		Scanner input = new Scanner(System.in);
		System.out.println("P1 Spots: " + p[0].getRow() + ", " + p[0].getColumn());
		System.out.println("P2 Spots: " + p[1].getRow() + ", " + p[1].getColumn());
		System.out.println("Enter to continue...");
		input.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		// loop through the display array and set the values to the
		// corresponding board values
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
		// print the display array
		System.out.println("Only see one player: Both players are on the spot");
		System.out.println("1: Player One");
		System.out.println("2: Player Two");
		System.out.println("G: GO!");
		System.out.println("B: Brand (Property)");
		System.out.println("?: Chance");
		System.out.println("T: Tax");
		System.out.println("J: Visit Outside");
		System.out.println("P: Free Parking");
		System.out.println("A: Go Outside");
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

}

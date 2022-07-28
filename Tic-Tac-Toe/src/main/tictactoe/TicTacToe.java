package main.tictactoe;

import java.util.Scanner;


/*X -> A -> 1
 *O -> B -> 0
 */
public class TicTacToe {
	static int[][] game = new int[3][3];
	private static String playerA = "X";
	private static String playerB = "O";
	private static int player = 0;
	//private static String gameString = "";
	private static boolean play = true;
	private static int moves = 0;
	static Scanner s = new Scanner(System.in);
	private static String currentPlayer  = "playerX";
	private static boolean win = false;
	
	public static void main(String[] args) {
		creatNewGame();
		printGame();
		while(play == true) {
			gameOver();
			playerMove();
			chelkWinner();
			if(win == true) {
				printGame();
				System.out.println("Winner is : " + currentPlayer);
				creatNewGame();
			}
			printGame();
		}
		printGame();
	}
	
	private static void gameOver() {
		
		if(win == true) {
			
		}
		if(moves == 9) {
			System.out.println("Game Tie");
			creatNewGame();
		}
	}

	private static void chelkWinner() {
		win = false;
		for(int i=0;i<3;i++) {
			chelkRow(i);
		}
		for(int i=0;i<3;i++) {
			chelkCol(i);
		}
		chelkX();
	}

	private static void chelkX() {
		int miss = 0;
		for(int j=0;j<3;j++) {
			if(game[j][j] != player) {
				miss++;
			}
		}
		if(miss == 0) {
			win = true;
		}
		miss = 0;
		for(int j=0;j<3;j++) {
			if(game[j][2-j] != player) {
				miss++;
			}
		}
		if(miss == 0) {
			win = true;
		}
	}

	private static void chelkCol(int i) {
		int miss = 0;
		for(int j=0;j<3;j++) {
			if(game[j][i] != player) {
				miss++;
			}
		}
		if(miss == 0) {
			win = true;
		}
	}

	private static void chelkRow(int i) {
		int miss = 0;
		for(int j=0;j<3;j++) {
			if(game[i][j] != player) {
				miss++;
			}
		}
		if(miss == 0) {
			win = true;
		}
	}

	private static void playerMove() {
		
		System.out.println(currentPlayer);
		System.out.print("row number :");
		int i = s.nextInt();
		System.out.print("colum number :" );
		int j = s.nextInt();
		if(game[i-1][j-1] == 2) {
			changPlayer();
			game[i-1][j-1] = player;
			System.out.println(game[i-1][j-1]);
		}
	}

	private static void changPlayer() {
		if (player == 0) {
			player = 1;
			currentPlayer  = "playerX";
		}
		else if(player == 1) { 
			player = 0;
			currentPlayer  = "playerO1";
		}
	}

	private static void creatNewGame() {
		System.out.println("Creating New Game");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				game[i][j] = 2;
			}
		}
	}

	private static void printGame() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				String x =" ";
				if(game[i][j]==0) { 
					x = playerB;
				}
				else if(game[i][j]==1) {
					x = playerA;
				}
				System.out.print( x + "|");
			}
			System.out.print("\n");
		}
		
	}
	
	
	
}

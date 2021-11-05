import java.util.Scanner;

public class ProgramFourInLine {

	public static void main(String[] args) {
		// declaration o board, pieces and players (piece form)
		Scanner sc = new Scanner(System.in);
		Board board = new Board(new String[7][6]);
		String firstPlayer = board.firstPlayer();
		System.out.println("First " + firstPlayer);
		String secondPlayer = board.secondPlayer(firstPlayer);
		String currentPlayer = secondPlayer;
		
		// game 
		int row =0;
		System.out.println("You can start! To finish press -1");
		boolean exit = false;
		while (!exit && row!=-1) {
			System.out.println("Choose a column: player"+board.currentPlayer(firstPlayer, secondPlayer, currentPlayer));
			row = sc.nextInt();
			Position position = new Position(board.lineFree(row), row);
			Piece piece = new Piece(board.currentPlayer(firstPlayer, secondPlayer, currentPlayer), position);
			board.addPieces(piece);
			board.printBoard();
			exit = board.allSolution(piece);
			currentPlayer = board.currentPlayer(firstPlayer, secondPlayer, currentPlayer);
			System.out.println();
			
		}
		System.out.println("You won " + currentPlayer);
		sc.close();
	}
}

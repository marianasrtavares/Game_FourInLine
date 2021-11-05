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
		int totalPieces = 42;
		// game
		int row = 0;
		System.out.println("You can start! To finish press -1");
		boolean exit = false;
		
			while (!exit && row != -1 && totalPieces > 0) {
				try {
				System.out.println(
						"Choose a column: player" + board.currentPlayer(firstPlayer, secondPlayer, currentPlayer));
				row = sc.nextInt();
				while ((row >= board.getBoard().length || row < 0 || board.isThereAPiece(row)) && row != -1) {
					if (board.isThereAPiece(row)) {
						System.out.println("There is a piece, choose other column");
						row = sc.nextInt();
					} else {
						System.out.println("Choose a row between 0 and 5");
						row = sc.nextInt();
					}
				}

				if (row != -1 && !board.isThereAPiece(row)) {
					Position position = new Position(board.lineFree(row), row);
					Piece piece = new Piece(board.currentPlayer(firstPlayer, secondPlayer, currentPlayer), position);
					board.addPieces(piece);
					totalPieces--;
					board.printBoard();
					exit = board.allSolution(piece);
					currentPlayer = board.currentPlayer(firstPlayer, secondPlayer, currentPlayer);
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println("Error! You needed to choose a row between 0 and 5");
				sc.nextLine();
			} 
			}

			// result of the game
			if (row != -1)
				System.out.println("You won " + currentPlayer);
			else if(totalPieces==0) {
				System.out.println("Its a draw! ");
			}else {
				System.out.println(board.currentPlayer(firstPlayer, secondPlayer, currentPlayer) + " give up");
			sc.close();		
	}
}
}

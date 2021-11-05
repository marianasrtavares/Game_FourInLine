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
		// game instructions
		int column = 0;
		System.out.println("You can start! To finish press -1");
		boolean exit = false;
		
		    //start the game
			while (!exit && column != -1 && totalPieces > 0) {
				try {
				System.out.println(
						"Choose a column: player" + board.currentPlayer(firstPlayer, secondPlayer, currentPlayer));
				column = sc.nextInt();
			
				//if is an incompatible column to put the piece
				
				while ((column >= board.getBoard().length || column < 0 || board.isThereAPiece(column)) && column != -1) {
					if (board.isThereAPiece(column)) {
						System.out.println("There is a piece, choose other column");
						column = sc.nextInt();
					} else {
						System.out.println("Choose a column between 0 and 5");
						column = sc.nextInt();
					}
				}
				
                //continue the game
				if (column != -1 && !board.isThereAPiece(column)) {
					Position position = new Position(board.lineFree(column), column);
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
			if (column != -1)
				System.out.println("You won " + currentPlayer);
			else if(totalPieces==0) {
				System.out.println("Its a draw! ");
			}else {
				System.out.println(board.currentPlayer(firstPlayer, secondPlayer, currentPlayer) + " give up");
			sc.close();		
	}
}
}

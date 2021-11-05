import java.util.ArrayList;
import java.util.List;

public class Board {
	private String[][] board;
	private List<Piece> pieces = new ArrayList<>();

	public Board() {

	}

	public Board(String[][] board) {
		this.board = board;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void addPieces(Piece piece) {
		pieces.add(piece);
		board[piece.getPosition().getRow()][piece.getPosition().getColumn()] = piece.getForm();

	}

	public int lineFree(int row) {
		int rowFree = board[0].length;
		for (int line = 0; line < board.length; line++) {
			if (board[line][row] != null) {
				rowFree--;
			}

		}
		return rowFree;
	}

	public void printBoard() {
		System.out.print("0 1 2 3 4 5");
		for (int i = 0; i < board.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null)
					System.out.print("-" + " ");
				else
					System.out.print(board[i][j] + " ");

			}
			System.out.print(i);
		}
	}

	public String firstPlayer() {
		int random = (int) Math.random() * 2 + 1;
		return random == 1 ? "X" : "O";

	}

	public String secondPlayer(String firstPlayer) {
		return firstPlayer.equals("O") ? "X" : "O";

	}

	public String currentPlayer(String player1, String player2, String currentPlayer) {
		return currentPlayer.equals(player1) ? player2 : player1;
	}

	public boolean solutionHorizontal(Piece piece) {
		int line = piece.getPosition().getRow();
		int column = piece.getPosition().getColumn();
		int columnRigth = piece.getPosition().getColumn() + 1;
		int columnLeft = piece.getPosition().getColumn() - 1;
		int countLeft = 1, countRigth = 0;
		while (column < board[0].length - 1 && columnRigth < board[0].length
				&& board[line][columnRigth] == piece.getForm()) {
			countRigth++;
			columnRigth++;

		}

		while (column > 0 && columnLeft >= 0 && board[line][columnLeft] == piece.getForm()) {
			countLeft++;
			columnLeft--;
		}

		if (countLeft + countRigth >= 4) {
			return true;
		}

		return false;
	}

	public boolean solutionVertical(Piece piece) {
		int line = piece.getPosition().getRow();
		int column = piece.getPosition().getColumn();
		int lineDown = piece.getPosition().getRow() + 1;
		int lineUp = piece.getPosition().getRow() - 1;
		int countUp = 0, counteDown = 1;
		while (line < board.length - 1 && lineDown < board.length && board[lineDown][column] == piece.getForm()) {
			counteDown++;
			lineDown++;

		}

		while (column > 0 && lineUp >= 0 && board[lineUp][column] == piece.getForm()) {
			countUp++;
			lineUp--;
		}

		if (countUp + counteDown >= 4) {
			return true;
		}

		return false;
	}

	public boolean solutionPrincipalDiagonal(Piece piece) {
		int line = piece.getPosition().getRow();
		int column = piece.getPosition().getColumn();
		int columnRigth = piece.getPosition().getColumn() + 1;
		int lineRigth = piece.getPosition().getRow() + 1;
		int columnLeft = piece.getPosition().getColumn() - 1;
		int lineLeft = piece.getPosition().getRow() - 1;
		int countDiagonalLeft = 1, countDiagonalRigth = 0;
		while (column < board[0].length - 1 && columnRigth < board[0].length && lineRigth < board.length
				&& board[lineRigth][columnRigth] == piece.getForm()) {
			countDiagonalLeft++;
			columnRigth++;
			lineRigth++;

		}
		while (column > 0 && columnLeft >= 0 && lineLeft >= 0 && board[lineLeft][columnLeft] == piece.getForm()) {
			countDiagonalLeft++;
			columnLeft--;
			lineLeft--;
		}

		if (countDiagonalRigth + countDiagonalLeft >= 4) {
			return true;
		}

		return false;
	}

	public boolean solutionSecondDiagonal(Piece piece) {
		int line = piece.getPosition().getRow();
		int column = piece.getPosition().getColumn();
		int columnRigth = piece.getPosition().getColumn() + 1;
		int lineRigth = piece.getPosition().getRow() - 1;
		int columnLeft = piece.getPosition().getColumn() - 1;
		int lineLeft = piece.getPosition().getRow() + 1;
		int countDiagonalLeft = 1, countDiagonalRigth = 0;
		while (column < board[0].length - 1 && line > 0 && columnRigth < board[0].length && lineRigth >= 0
				&& board[lineRigth][columnRigth] == piece.getForm()) {
			countDiagonalRigth++;
			columnRigth++;
			lineRigth--;

		}

		while (column > 0 && line < board.length - 1 && lineLeft < board.length && columnLeft >= 0
				&& board[lineLeft][columnLeft] == piece.getForm()) {
			countDiagonalLeft++;
			columnLeft--;
			lineLeft++;
		}

		if (countDiagonalRigth + countDiagonalLeft >= 4) {
			return true;
		}

		return false;
	}

	public boolean allSolution(Piece piece) {
		if (solutionSecondDiagonal(piece) || solutionPrincipalDiagonal(piece) || solutionVertical(piece)
				|| solutionHorizontal(piece))
			return true;
		return false;
	}

}

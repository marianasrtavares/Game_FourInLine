
public class Piece {
	private String form;
	private Position position;

	public Piece() {

	}

	public Piece(String form, Position position) {
		this.position=position;
		this.form = form;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Piece "+ form ;
	}

	public static String getFirstForm() {
		int random = (int) (Math.random() * 2 + 1);
		return random == 1 ? "X" : "O";
	}

}

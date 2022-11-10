package application;

import java.util.ArrayList;

public class Knight extends Piece {
	public Knight(String color,String skin, Square square) {
		super(color,"N",skin, square);
		
	}
	@Override 
	public ArrayList<Square> getAccessibleSquares(){
		ArrayList<Square> sList= new ArrayList<>();
		addSquare(x + 2, y + 1, sList);
		addSquare(x + 2, y - 1, sList);
		addSquare(x + 1, y + 2, sList);
		addSquare(x + 1, y - 2, sList);
		addSquare(x - 2, y + 1, sList);
		addSquare(x - 2, y - 1, sList);
		addSquare(x - 1, y + 2, sList);
		addSquare(x - 1, y - 2, sList);
		return sList;
		
		
		
		
		
	
	}
	private void addSquare(int x, int y, ArrayList<Square> squares) {
		Square square = this.square.getBoard().getSquare(x, y);
		if (square != null && (square.getPiece() == null || square.getPiece().color != color)) {
			squares.add(square);
		}
	}
}

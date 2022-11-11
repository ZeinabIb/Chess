package application;

import java.util.ArrayList;

public class Pawn extends Piece {
	public Pawn(String color,String skin, Square square) {
		super(color,"P",skin, square);
		
	}
	@Override 
	public ArrayList<Square> getAccessibleSquares(){
		
		ArrayList<Square> sList= new ArrayList<>();
		addSquare(x,y-1,sList);
		addSquare(x,y-2,sList);
		return sList;
		
		
	
	}
	private void addSquare(int x, int y, ArrayList<Square> squares) {
		Square square = this.square.getBoard().getSquare(x, y);
		if (square != null && (square.getPiece() == null || square.getPiece().color != color)) {
			squares.add(square);
		}
	}
}

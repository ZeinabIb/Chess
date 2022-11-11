package application;

import java.util.ArrayList;

public class King extends Piece {
	public King(String color,String skin, Square square) {
		super(color,"K",skin, square);
		
	}
	@Override 
	public ArrayList<Square> getAccessibleSquares(){
		
		ArrayList<Square> sList= new ArrayList<>();
		addSquare(x+1,y+1,sList);
		addSquare(x-1,y-1,sList);
		addSquare(x+1,y,sList);
		addSquare(x,y+1,sList);
		addSquare(x,y-1,sList);
		addSquare(x-1,y,sList);
		addSquare(x-1,y+1,sList);
		addSquare(x+1,y-1,sList);
		return sList;
		
		
	
	}
	private void addSquare(int x, int y, ArrayList<Square> squares) {
		Square square = this.square.getBoard().getSquare(x, y);
		if (square != null && (square.getPiece() == null || square.getPiece().color != color)) {
			squares.add(square);
		}
	}
}

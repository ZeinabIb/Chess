package application;

import java.util.ArrayList;


public class Bishop extends Piece {

	public Bishop(String color,String skin, Square square) {
		super(color,"B",skin, square);
		
	}
	@Override 
	public ArrayList<Square> getAccessibleSquares(){
		ArrayList<Square> sList= new ArrayList<>();
		
		
		for (int i=1; x+i<8 && y-i>=0;i++) 
			if(!addSquare(x+i,y-i,sList))
				break;
			

		for (int i=1; x+i<8 && y+i<8;i++) 
			if(!addSquare(x+i,y+i,sList))
			break;
			
		
		for (int i=1; x-i>=0 && y+i<8;i++)
			if(!addSquare(x-i,y+i,sList))
			break;
		
		
			
		for (int i=1; x-i>=0 && y-i>=0;i++) 
			if(!addSquare(x-i,y-i,sList))
				break;

			
		
		
		return sList;
		
	
	}
	
	private boolean addSquare(int x, int y, ArrayList<Square> squares) {
		Square square = this.square.getBoard().getSquare(x, y);
		if (square != null) {
			if(square.getPiece() == null) {
				squares.add(square);
				return true;
			}
		
			else if (square.getPiece().color != color) {
				squares.add(square);
				return false;
				
			
			}
		}
		return false;
	} 

}
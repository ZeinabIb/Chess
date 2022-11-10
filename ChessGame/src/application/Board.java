package application;

import java.util.Arrays;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Board extends GridPane{
	
	
	private Square[] squares = new Square[64];
	private int currentPlayer;
	private Piece selectedPiece ;
	private Square selectedSquare;
	
	
	
	Board(){
		currentPlayer=0;
		
		for(int i=0; i<64; i++) {
			int x = getX(i);
			int y = getY(i);
			Square square = new Square(this, x, y);
			add(square, x, y);
			squares[i] = square;
			setPositionRef(squares[i]);
			
			
			
			 
			
		}
	
	}
	
	private int getX(int index) {
		return index % 8;
	}

	private int getY(int index) {
		return (index - getX(index)) / 8;
	}
	
	public void setPositionRef(Square s) {
		int y =s.getY();
		int x =s.getX();
		
		
		switch(x) {
		case 0:
			switch(y) {
			case 0:
				squareNumeration ( s ,new Text (5,18,"8"));
				break;
			case 1:
				squareNumeration ( s ,new Text (5,18,"7"));
				break;
			case 2:
				squareNumeration ( s ,new Text (5,18,"6"));
				break;
			case 3:
				squareNumeration ( s ,new Text (5,18,"5"));
				break;
			case 4:
				squareNumeration ( s ,new Text (5,18,"4"));
				break;
			case 5:
				squareNumeration ( s ,new Text (5,18,"3"));
				break;
			case 6:
				squareNumeration ( s ,new Text (5,18,"2"));
				break;
			case 7:
				squareNumeration ( s ,new Text (5,18,"1"));
				break;
		
		}
			break;
		
		
		}
		
		switch(y) {
		case 7:
			switch(x) {
			case 0:
				squareNumeration ( s ,new Text (58,63,"a"));
				break;
			case 1:
				squareNumeration ( s ,new Text (58,63,"b"));
				break;
			case 2:
				squareNumeration ( s ,new Text (58,63,"c"));
				break;
			case 3:
				squareNumeration ( s ,new Text (58,63,"d"));
				break;
			case 4:
				squareNumeration ( s ,new Text (58,63,"e"));
				break;
			case 5:
				squareNumeration ( s ,new Text (58,63,"f"));
				break;
			case 6:
				squareNumeration ( s ,new Text (58,63,"g"));
				break;
			case 7:
				squareNumeration ( s ,new Text (58,63,"h"));
				break;
		
		}
			break;
		
		
		}
		
		
	}
	
	void squareNumeration (Square s , Text t) {
		s.getChildren().add(t);
		t.setStyle("-fx-fill:"+s.getOppositeColor()+"; -fx-font-weight:700;  -fx-font-size:16;");
		
	}
	
	
	public Square getSquare(int x, int y) {
		if(x<0 || y<0 || x>7 || y>7)
			return null;
		return squares[y*8+x];
	}
	
	public Square[] getSquares() {
		return squares;
	}
	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
	
	public Square getSelectedSquare() {
		return selectedSquare;
	}
	public void setSelectedSquare(Square selectedSquare) {
		this.selectedSquare = selectedSquare;
	}
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public Piece getSelectedPiece() {
		return selectedPiece;
	}
	
	@Override
	public String toString() {
		return "Board [squares=" + ", currentPlayer=" + currentPlayer + ", selectedPiece="
				+ selectedPiece + "]";
	}
	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	
}

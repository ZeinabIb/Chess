package application;

import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Square extends Pane {
	
	private int x,y;
	private String defColor;
	private Board board;
	private Piece piece;
	private boolean highlighted=false;
	
	private static  String defaultDarkSquare = "#759655";
	private static  String defaultLightSquare = "#eeeed1";
	private static  String highlightedDarkSquare = "#bac92c";
	private static  String highlightedLightSquare = "#f6f668";
	private static  String killSquare = "#";
	

	public Square(Board board, int x,int y){
		this.board = board;
		this.x = x;
		this.y = y;
		
		if((x+y)%2==0 ) {
			this.setStyle("-fx-background-color:"+defaultLightSquare);
			defColor ="light";
			
		}else {
			setStyle("-fx-background-color:"+defaultDarkSquare);
			defColor="dark";
		}
		
		setMinSize(70, 70);
		setMaxSize(70, 70);
		setOnMouseClicked(e->{onMouseClicked (board);
			
		});
		
		
	}
	
	public String getDefColor() {
		return this.defColor;
	}
	
public String getOppositeColor() {
	if(defColor.equals("dark")) {
		return  defaultLightSquare;
	}
	return defaultDarkSquare;
	
	}




	public Piece getPiece() {
		return piece;
	}



	public void setPiece(Piece piece) {
		this.piece = piece;
		ImageView imgV = piece.getImageView();
		getChildren().add(imgV);
		imgV.xProperty().bind(this.widthProperty().divide(2).subtract(imgV.maxWidth(x)/2));
		
		
	}
	
	
	public void removePiece() {
		piece= null;
		getChildren().remove(getChildren().toArray().length - 1);
	}
	
	


	


	public void onMouseClicked (Board board) {
		
		Piece selectedPiece =board.getSelectedPiece();
		
		
		if(highlighted == false && getPiece()!= null) {
			if(selectedPiece==null) {
				setHighlightAccessible(this);
				board.setSelectedPiece(piece);
				board.setSelectedSquare(this);
				
			}else {
				setHighlightAccessible(board.getSelectedSquare());
				setHighlightAccessible(this);
				board.setSelectedPiece(piece);
				board.setSelectedSquare(this);
			}
			
			
		
		
		
		}else if(highlighted == true && getPiece()!=null ) {
			setHighlightAccessible(board.getSelectedSquare());
			board.setSelectedPiece(null);
			board.setSelectedSquare(null);
			
		}else if(highlighted == false && getPiece()==null && board.getSelectedSquare()!= null) {
			setHighlightAccessible(board.getSelectedSquare());
			board.setSelectedPiece(null);
			board.setSelectedSquare(null);
			
			
			
		}
		
		else if (highlighted == true && getPiece()==null) {
			
		
			
			setHighlightAccessible(selectedPiece.getSquare());
			setPiece(selectedPiece);
			selectedPiece.getSquare().removePiece();
			selectedPiece.setSquare(this);
			board.setSelectedPiece(null);
			board.setSelectedSquare(null);
		
			
			
			
		}
		
		
	}
	
	public boolean isHighlighted() {
		return highlighted;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public void setHighlightAccessible(Square square) {
		square.setHighlight();
		ArrayList <Square> Accessible =square.piece.getAccessibleSquares();
		for (Square a : Accessible) {
			
			a.setHighlight();
		
		}
	}
	
	
	
	public void setHighlight() {
		if(highlighted == false) {
			
			if(defColor.equals("dark")) {
				this.setStyle("-fx-background-color:"+highlightedDarkSquare);
				
			}else {
				this.setStyle("-fx-background-color:"+highlightedLightSquare);
			}
			highlighted = true;
			
			
		}else {
			
			if(defColor.equals("dark")) {
				this.setStyle("-fx-background-color:"+defaultDarkSquare);
				
			}else {
				this.setStyle("-fx-background-color:"+defaultLightSquare);
			}
			highlighted = false;
			
			
		}
		
	}
	
	
	
	public void setDefColor(String defColor) {
		this.defColor = defColor;
	}
	public String getDefaultColor() {
		return defColor;
	}
	
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Board getBoard() {
		return this.board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}
	@Override
	public String toString() {
		return "Square [x=" + x + ", y=" + y + ", defColor=" + defColor + ", board=" + board + ", piece=" + piece + "]";
	}

	
	
	
	
	
}

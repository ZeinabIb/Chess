package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Piece {
	

	protected int x;
	protected int y;
	protected Square square;
	protected String color,type;
	protected String imgPath;
	
	private Map<String,Image> pieceImages = new HashMap<>();
	
	
	public Piece (String color,String type,String skin,Square square){
		this.color=color;
		this.type =type;
		this.square = square;
		this.x =square.getX();
		this.y =square.getY();
		imgPath ="imgs/"+skin+"/"+color+""+type+ ".png";
		
		if ( pieceImages.containsKey(imgPath) == false)
			pieceImages.put(imgPath, new Image(getClass().getResource(imgPath).toString(),70,70,true,true));
			
		
	}
	
	
	public abstract ArrayList<Square> getAccessibleSquares();
	
	
	public Image getImage() {
		return pieceImages.get(imgPath);
	}
	
	public ImageView getImageView() {
		return new ImageView(getImage());
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

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
		setX(square.getX());
		setY(square.getY());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Piece [x=" + x + ", y=" + y + ", square=" + square + ", color=" + color + ", type=" + type
				+ ", imgPath=" + imgPath + ", pieceImages=" + pieceImages + "]";
	}
		
	
}

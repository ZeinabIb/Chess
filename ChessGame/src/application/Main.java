package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;





public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
			Board board = new Board();
			StackPane pane = new StackPane();
			board.setAlignment(Pos.CENTER);
			  
		
			board.getSquare(3, 3).setPiece(new Bishop("w","basic",board.getSquare(3, 3)));
			
			board.getSquare(2, 5).setPiece(new Knight("b","basic",board.getSquare(2, 5)));
			
			
			pane.getChildren().add(board);
			pane.setStyle("-fx-effect: dropshadow(gaussian,rgb(0,0,0,0.5),20,0.4,0.0,0.0); ");
			Scene scene = new Scene(pane,600,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

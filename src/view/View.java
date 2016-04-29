package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class View{
	AnchorPane anchorpane = new AnchorPane();
	Slider interceptS = new Slider(-40, 40, 0);
	Slider slopeS = new Slider(-10, 10, 0);
	Label position = new Label();
	Label positionL = new Label("position: ");
	Label scoreL = new Label("\tscore: ");
	Label score = new Label();
	

	
	


	public void start(Stage primaryStage) {
		primaryStage.setTitle("BubbleShooter");
		GridPane root = new GridPane();
		GridPane panel = new GridPane();
		anchorpane.setPrefSize(600, 600);
		root.getChildren().add(anchorpane);
		
		Label interceptL = new Label("Intercept");
		Label slopeL = new Label("Slope");
		Button button = new Button("Draw");
		
		root.add(panel, 0, 1);
		panel.add(interceptL, 0, 1);
		panel.add(interceptS, 1, 1);
		panel.add(slopeL, 2, 1);
		panel.add(slopeS, 3, 1);
		panel.add(button, 4, 1);
		
		panel.add(positionL, 5, 1);
		panel.add(position, 6, 1);
		panel.add(scoreL, 7, 1);
		panel.add(score, 8, 1);
		
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		for(int i = 0; i < 20; i++){
			anchorpane.getChildren().add(new Line(0, 30 * i, 600, 30 * i));
			anchorpane.getChildren().add(new Line(30 * i, 0, 30 * i, 600));
		}
	}

	public Label getScore() {
		return score;
	}

	public AnchorPane getAnchorpane() {
		return anchorpane;
	}

	public Slider getInterceptS() {
		return interceptS;
	}

	public Slider getSlopeS() {
		return slopeS;
	}
	
	public Label getPosition() {
		return position;
	}
}

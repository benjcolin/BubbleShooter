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
	private AnchorPane anchorpane = new AnchorPane();
	private Slider interceptS = new Slider(-40, 40, 0);
	private Slider slopeS = new Slider(-10, 10, 0);
	private Label position = new Label();
	private Label score = new Label();
	private Button buttonD = new Button("Shoot");
	private Button resetE = new Button("Reset Easy");
	private Button resetH = new Button("Reset Hard");
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("BubbleShooter");
		GridPane root = new GridPane();
		GridPane panel = new GridPane();
		anchorpane.setPrefSize(600, 600);
		root.getChildren().add(anchorpane);
		
		Label interceptL = new Label("Intercept");
		Label slopeL = new Label("Slope");
		Label scoreL = new Label("\tscore: ");
		Label positionL = new Label("position: ");
		
		
		root.add(panel, 0, 1);
		panel.add(interceptL, 0, 1);
		panel.add(interceptS, 1, 1);
		panel.add(slopeL, 2, 1);
		panel.add(slopeS, 3, 1);
		panel.add(buttonD, 4, 1);
		
		panel.add(positionL, 5, 1);
		panel.add(position, 6, 1);
		panel.add(scoreL, 7, 1);
		panel.add(score, 8, 1);

		panel.add(resetE, 0, 2);
		panel.add(resetH, 1, 2);
		
		
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

	public Button getButtonD() {
		return buttonD;
	}

	public Button getResetE() {
		return resetE;
	}

	public Button getResetH() {
		return resetH;
	}
}

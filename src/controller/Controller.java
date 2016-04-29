package controller;

import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.*;
import view.View;

public class Controller extends Application {
	View view = new View();
	Game game = new Game();
	Preview preview = new Preview();
	Parameter parameter = new Parameter();
	Score score = new Score();

	@Override
	public void start(Stage primaryStage) {
		view.start(primaryStage);
		view.getInterceptS().valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				parameter.setIntercept(newValue.doubleValue());
				preview.updatePreview(parameter.getIntercept(), parameter.getSlope());
			}
		});

		view.getSlopeS().valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				parameter.setSlope(newValue.doubleValue());
				preview.updatePreview(parameter.getIntercept(), parameter.getSlope());
			}
		});
		
		view.getButtonD().setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        
		    }
		});
		
		view.getResetE().setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        
		    }
		});
		
		view.getResetH().setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        
		    }
		});

		view.getAnchorpane().getChildren().add(preview.getLine());

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			game.addBubble(new Bubble(new Circle(rand.nextInt(20) * 30, rand.nextInt(20) * 30, 5)));
			game.getBubbles().get(i).getCircle().setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(final MouseEvent t) {
					Circle circle = (Circle) t.getSource();
					view.getPosition().setText(Math.round((circle.getCenterX() / 30) - 10) + ", " + Math.round((circle.getCenterY() / 30) - 10));
				}
			});

			game.getBubbles().get(i).getCircle().setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent t) {
					view.getPosition().setText("");

				}

			});

			view.getAnchorpane().getChildren().add(game.getBubbles().get(i).getCircle());
		}

		String scoreText = "" + score.getScore();
		view.getScore().setText(scoreText);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

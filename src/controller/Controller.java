package controller;

import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

		view.getAnchorpane().getChildren().add(preview.getLine());

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			// view.getGraphicscontext().strokeOval(rand.nextInt(800), y, w, h);
			game.addBubble(new Bubble(new Circle(rand.nextInt(1000), rand.nextInt(1000), 10)));
			game.getBubbles().get(i).getCircle().setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(final MouseEvent t) {
					Circle circle = (Circle) t.getSource();
					view.getPosition().setText(circle.getCenterX() + ", " + circle.getCenterY());
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

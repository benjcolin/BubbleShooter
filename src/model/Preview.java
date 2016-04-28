package model;

import javafx.scene.paint.Color;

public class Preview {
	private double intercept;
	private double slope;
	private javafx.scene.shape.Line line = new javafx.scene.shape.Line(350, 400, 450, 400);

	public void Preview() {
		line.setFill(Color.BLACK);
		line.setStroke(Color.BLACK);
		line.setVisible(true);
	}

	public double getIntercept() {
		return intercept;
	}

	public double getSlope() {
		return slope;
	}

	public void updatePreview(double intercept, double slope) {
		this.intercept = intercept;
		this.slope = slope;
		double sX;
		double sY;
		double eX;
		double eY;

		if(slope == 0){
			slope = 0.001;
		}
		if (slope > 1 || slope < -1) {
			// startX and endX
			if (slope > 0) {
				sX = (-50 + intercept) / -slope;
				eX = (50 + intercept) / -slope;
			} else {
				sX = (50 + intercept) / slope;
				eX = (-50 + intercept) / slope;
			}
			// startY
			sY = (-slope * sX) - intercept;
			// endY
			eY = (-slope * eX) - intercept;
		} else {
			// startY
			sY = (-slope * -50) - intercept;
			// endY
			eY = (-slope * 50) - intercept;
			// startX
			sX = (sY + intercept) / -slope;
			// endX
			eX = (eY + intercept) / -slope;
		}

		sX += 500;
		sY += 500;
		eX += 500;
		eY += 500;

		line.setStartX(sX);
		line.setStartY(sY);
		line.setEndX(eX);
		line.setEndY(eY);
	}

	public javafx.scene.shape.Line getLine() {
		return line;
	}
}

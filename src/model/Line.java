package model;

public class Line {
	private double intercept;
	private double slope;
	private javafx.scene.shape.Line line;

	public Line(double intercept, double slope){
		this.intercept = intercept;
		this.slope = intercept;
	}
	
	public double getIntercept() {
		return intercept;
	}

	public double getSlope() {
		return slope;
	}

	public javafx.scene.shape.Line getLine() {
		return line;
	}
}

package model;

import javafx.scene.shape.Circle;

public class Bubble {
	
	private double xaxis;
	private double yaxis;
	private boolean hit;
	private Circle circle;
	
	public Bubble(Circle circle){
		xaxis = circle.getLayoutX();
		yaxis = circle.getLayoutY();
		hit = false;
		this.circle = circle;
	}
	
	public void markAsHit() {
		hit = true;
	}
	
	public double getXaxis() {
		return xaxis;
	}
	
	public double getYaxis() {
		return yaxis;
	}
 
	public void changeStatus() {
		if(hit){
			hit = false;
		}else{
			hit = true;
		}
		
	}

	public boolean isHit() {
		return hit;
	}

	public Circle getCircle() {
		return circle;
	}
}

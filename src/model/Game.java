package model;

import java.util.ArrayList;

public class Game {
	private ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
	private int score;
	
	public void Bubble(){
		
	}
	
	public void markBubbles(){
		
	}
	
	public ArrayList<Bubble> getBubbles(){
		return this.bubbles;
	}
	
	public void addBubble(Bubble bubble) {
		this.bubbles.add(bubble);
	}

	public int getScore(){
		return this.score;
	}
}

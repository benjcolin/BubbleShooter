package model;

import java.util.ArrayList;

public class Game {
	private ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
	private Score score = new Score();
	
	public void markBubbles(){
		
	}
	
	public ArrayList<Bubble> getBubbles(){
		return this.bubbles;
	}
	
	public void addBubble(Bubble bubble) {
		this.bubbles.add(bubble);
	}

	public Score getScore(){
		return score;
	}
}

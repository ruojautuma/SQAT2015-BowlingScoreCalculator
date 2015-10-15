package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	private boolean last = false;
	private int bonus = 0;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		return this.firstThrow+this.secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		return (this.firstThrow == 10) ? true : false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		return ((this.firstThrow+this.secondThrow == 10) && !this.isStrike()) ? true : false;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){		
		return this.last;
	}
	
	public void setLast() {
		this.last = true;
		this.bonus = 3;
	}

	//bonus throws
	public int bonus(){
		return this.bonus;
	}
}

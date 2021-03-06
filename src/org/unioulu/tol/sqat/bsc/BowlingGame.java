package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		if(this.frames.size() == 9) {
			frame.setLast();
		}
		this.frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		this.bonus = new Frame(firstThrow, secondThrow);
	}
	
	public int score(){
		int total = 0;
		Iterator<Frame> frameIter = this.frames.iterator();
		Frame frame = null;		
		while(frameIter.hasNext()) {
			if(frame != null && frame.isLastFrame()) {
				//in case the previous frame was the last but there are still more frames
				break;
			}
			frame = frameIter.next();

			if(frame.isSpare()) {
				if(this.isNextFrameBonus()) {
					total += this.bonus.getFirstThrow();
				} else {
					total += this.frames.get(this.frames.indexOf(frame)+1).getFirstThrow(); //get the first of next throw
				}
			} else if(frame.isStrike()) {
				if(this.isNextFrameBonus()) {
					total += this.bonus.score();
				} else {
					total += this.frames.get(this.frames.indexOf(frame)+1).score(); //get the score of next throw
				}
			}

			total += frame.score();
		}
		if(this.isNextFrameBonus()) {
			total += this.bonus.score();
		}
		return total;
	}
	
	public boolean isNextFrameBonus(){
		if(this.frames.size() == 10) {
			return (this.frames.get(9).bonus() > 0) ? true : false;
		}
		return false;
	}
}

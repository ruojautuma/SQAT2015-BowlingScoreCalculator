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
		this.frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		this.bonus = new Frame(firstThrow, secondThrow);
	}
	
	public int score(){
		int total = 0;
		Iterator<Frame> frameIter = this.frames.iterator();
		Frame frame;		
		while(frameIter.hasNext()) {
			frame = frameIter.next();
			if(frame.isSpare()) {
				total += this.frames.get(this.frames.indexOf(frame)+1).getFirstThrow(); //get the first of next throw
			} else if(frame.isStrike()) {
				total += this.frames.get(this.frames.indexOf(frame)+1).score(); //get the score of next throw
			}
			total += frame.score();
		}
		return total;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}

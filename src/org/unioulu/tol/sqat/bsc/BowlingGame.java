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
		//to be implemented
	}
	
	public int score(){
		int total = 0;
		Iterator<Frame> frameIter = this.frames.iterator();
		while(frameIter.hasNext()) {
			total += frameIter.next().score();
		}
		return total;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}

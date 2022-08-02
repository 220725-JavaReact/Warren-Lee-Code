package com.revature.hangman.model;

import com.revature.hangman.util.*;
import com.revature.hangman.util.Logger.*;

public class Player {
	
	private static Logger logger = Logger.getLogger();
	
	private String name;
	private int score;
	
	public Player(String name) {
		
		logger.log(LogLevel.INFO, "Creating a player called " + name + ".");
		
		this.name = name;
		score = 0;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public int getScore() {
		
		return score;
		
	}
	
	public void addPoint() {
		
		logger.log(LogLevel.INFO, "Adding a point to " + name + ".");
		
		score++;
		
	}

}

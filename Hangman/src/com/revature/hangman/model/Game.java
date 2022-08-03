package com.revature.hangman.model;

import java.util.*;

import com.revature.hangman.util.*;
import com.revature.hangman.util.Logger.*;

public class Game {
	
	private Logger logger = Logger.getLogger();
	
	private Scanner scanner = new Scanner(System.in);
	private Player[] players;
	private int scoreLimit;
	private String[] mysteryWords = {"zebra", "coordinate", "royal", "thunder"};
	
	public Game(Player[] players, int scoreLimit) {
		
		this.players = players;
		this.scoreLimit = scoreLimit;
		
	}
	
	public void startGame() {
		
		do {
			
			logger.log(LogLevel.INFO, "Starting game.");
			
			boolean gameOver = false;
			String mysteryWord = mysteryWords[new Random().nextInt(mysteryWords.length)];
			String progressWord = mysteryWord.replaceAll("\\w", "*");
			int playerTurn = new Random().nextInt(2);
			int guesses = 0;
			int maxGuesses = 6;
			String guessedLetters = "";
			
			System.out.println("Scoreboard\n" + players[0].getName() + ": " + players[0].getScore() + " " + players[1].getName() + ": " + players[1].getScore() + "\nScore Limit: " + scoreLimit);
			
			while (!gameOver) {
				
				Player currentPlayer = players[playerTurn];
				
				if (guesses == maxGuesses) {
					
					logger.log(LogLevel.INFO, "Ending round due to running out of guesses.");
					
					System.out.println("Game over! Ran out of guesses. No points earned.");
					gameOver = true;
					
				} else {
					
					boolean endTurn = false;
					
					do {
						
						System.out.println("Word: " + progressWord + "\nGuessed Letters: " + guessedLetters + "\tGuesses Remaining: " + (maxGuesses - guesses) + "\n" + currentPlayer.getName() + ", Please enter a guess:");
						String guess = scanner.nextLine().toLowerCase();
						
						if (guess.matches("[a-z]{2,}")) {
							
							if (guess.equals(mysteryWord)) {
								
								logger.log(LogLevel.INFO, "Round won by " + currentPlayer.getName() + ".");
								
								System.out.println("Winner! " + currentPlayer.getName() + " guessed the word.");
								currentPlayer.addPoint();
								gameOver = true;
								break;
								
							} else {
								
								logger.log(LogLevel.INFO, "Incorrect guess. Next player's turn.");
								
								System.out.println(guess + " is not the word.");
								guesses++;
								playerTurn = (playerTurn == 0) ? 1 : 0;
								endTurn = true;
								
							}
							
						} else if (!guess.matches("[a-z]")) {
							
							logger.log(LogLevel.WARN, "Player entered non-letter guess.");
							
							System.out.println("Invalid input.");
							continue;
							
						} else if (guessedLetters.contains(guess)) {
							
							logger.log(LogLevel.WARN, "Player entered duplicate guess.");
							
							System.out.println(guess + " has already been guessed.");
							continue;
							
						} else {
							
							guessedLetters += guess;
							
							if (mysteryWord.contains(guess)) {
								
								logger.log(LogLevel.INFO, "Correct guess. Player continues turn.");
								
								System.out.println(guess + " is in the word.");
								progressWord = updateProgress(mysteryWord, progressWord, guess);
								
							} else {
								
								logger.log(LogLevel.INFO, "Incorrect guess. Next player's turn.");
								
								System.out.println(guess + " is not in the word.");
								guesses++;
								playerTurn = (playerTurn == 0) ? 1 : 0;
								endTurn = true;
								
							}
							
						}
						
						if (!progressWord.contains("*")) {
							
							logger.log(LogLevel.INFO, "Round won by " + currentPlayer.getName() + ".");
							
							System.out.println("Winner! " + currentPlayer.getName() + " guessed the word.");
							currentPlayer.addPoint();
							gameOver = true;
							break;
							
						}
						
					} while (!endTurn);
					
				}
				
			}
			
		} while (players[0].getScore() < scoreLimit && players[1].getScore() < scoreLimit);
		
		String overallWinner = (players[0].getScore() == scoreLimit) ? players[0].getName() : players[1].getName();
		
		System.out.println(overallWinner + " is the overall winner!");
		
		logger.log(LogLevel.INFO, "Ending game. " + overallWinner + " is the overall winner.");
		
	}
	
	public String updateProgress(String mysteryWord, String progressWord, String guess) {
		
		logger.log(LogLevel.INFO, "Updating progressWord.");
		
		char[] mysteryWordCharArray = mysteryWord.toCharArray();
		char[] progressWordCharArray = progressWord.toCharArray();
		char guessChar = guess.charAt(0);
		
		for (int i = 0; i < mysteryWordCharArray.length; i++) {
			
			if (mysteryWordCharArray[i] == guessChar) {
				
				progressWordCharArray[i] = guessChar;
				
			}
			
		}
		
		return new String(progressWordCharArray);
		
	}

}

package com.revature.hangman.ui;

import java.util.*;

import com.revature.hangman.model.*;
import com.revature.hangman.util.*;
import com.revature.hangman.util.Logger.*;

public class Menu {
	
	private static Logger logger = Logger.getLogger();
	
	private static Scanner scanner = new Scanner(System.in);
	private static Player player1, player2;
	private static int scoreLimit;
	
	public static void open() {
		
		logger.log(LogLevel.INFO, "Displaying UI.");
		
		String input = "";
		
		System.out.println("Welcome to Hangman!");
		
		while (!input.equals("x")) {
			
			System.out.println("[1] Start new game\n[x] Exit");
			
			input = scanner.nextLine();
			
			switch (input) {
			
			case "1":
				logger.log(LogLevel.INFO, "Gathering information for a game.");
				
				System.out.println("Please enter a name for player 1:");
				player1 = new Player(scanner.nextLine());
				
				System.out.println("Please enter a name for player 2:");
				player2 = new Player(scanner.nextLine());
				
				System.out.println("Please enter the score limit:");
				while (scoreLimit < 1) {
					try {
					
						scoreLimit = Integer.parseInt(scanner.nextLine());
						
					} catch (Exception ex) {
						
						logger.log(LogLevel.WARN, "User entered non-number for scoreLimit.", ex);
						
						System.out.println("Invalid input. Please enter a number.");
						
					}
					
				}
				
				Game game = new Game(new Player[] {player1, player2}, scoreLimit);
				game.startGame();
				break;
			case "x":
				logger.log(LogLevel.INFO, "Closing app.");
				
				System.out.println("Goodbye.");
				break;
			default:
				logger.log(LogLevel.WARN, "User entered invalid menu option.");
				
				System.out.println("Invalid input. Try again.");
				break;
			
			}
			
		}
		
	}

}

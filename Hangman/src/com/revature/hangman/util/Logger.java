package com.revature.hangman.util;

import java.io.*;
import java.time.*;

public class Logger {
	
	private static class Log {
		
		LogLevel level;
		LocalDateTime timestamp;
		String message;
		
		private Log(LogLevel level, LocalDateTime timestamp, String message) {
			
			this.level = level;
			this.timestamp = timestamp;
			this.message = message;
			
		}
		
		@Override
		public String toString() {
			
			return level + "\t" + timestamp + "\t" + message;
			
		}
		
	}
	
	public enum LogLevel {
		
		VERBOSE("Verbose"),
		DEBUG("Debug"),
		INFO("Info"),
		WARN("Warn"),
		ERROR("Error"),
		FATAL("Fatal");
		
		public final String friendlyName;
		
		private LogLevel(String friendlyName) {
			
			this.friendlyName = friendlyName;
			
		}
		
	}
	
	private static Logger logger = new Logger();
	
	private Logger() {
		
	}
	
	public static Logger getLogger() {
		
		return logger;
		
	}
	
	public static void log(LogLevel level, String message) {
		
		Log newLog = new Log(level, LocalDateTime.now(), message);
		writeToFile(newLog.toString());
		
	}
	
	public static void log(LogLevel level, String message, Exception ex) {
		
		Log newLog = new Log(level, LocalDateTime.now(), message + " " + ex.toString());
		writeToFile(newLog.toString());
		
	}
	
	private static void writeToFile(String log) {
		
		try {
			
			FileWriter writer = new FileWriter(LocalDate.now().toString() + ".log", true);
			writer.write(log + "\n");
			writer.close();
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
		}
		
	}

}

import com.revature.hangman.ui.*;
import com.revature.hangman.util.*;
import com.revature.hangman.util.Logger.*;

public class Driver {
	
	private static Logger logger = Logger.getLogger();

	public static void main(String[] args) {
		
		logger.log(LogLevel.INFO, "Starting app.");
		
		Menu.open();

	}

}


public class MyAssertion {
	
	public static void assertEquals(String expected, String actual) {
		
		evaluate(actual.equals(expected), "Fail");
		
	}
	
	public static void assertArrayEquals(String[] expected, String[] actual) {
		
		if (expected.length == actual.length) {
			
			for (int i = 0; i < actual.length; i++) {
			
				evaluate(actual[i].equals(expected[i]), "Fail");
				
			}
			
		} else {
			
			evaluate(false, "Fail");
			
		}
		
	}
	
	private static void evaluate(boolean condition, String message) {
		
		if (!condition) {
			
			throw new AssertionError(message);
			
		}
		
	}

}

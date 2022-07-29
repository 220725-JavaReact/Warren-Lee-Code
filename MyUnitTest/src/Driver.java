import java.lang.reflect.*;

public class Driver {

	public static void main(String[] args) {
		
		int totalUnitTests = 0;
		int passedUnitTests = 0;
		int failedUnitTests = 0;
		int ignoredUnitTests = 0;
		
		BookTest bookTest = new BookTest();
		
		Class<BookTest> bookTestClass = BookTest.class;
		
		Method[] bookTestMethods = bookTestClass.getDeclaredMethods();
		
		for (Method currentMethod : bookTestMethods) {
			
			totalUnitTests++;
			
			if (currentMethod.isAnnotationPresent(Test.class) && currentMethod.getAnnotation(Test.class).enable()) { // Only run if annotation exists and its "enabled" metadata is set to true
				
				System.out.println(currentMethod.getName());
				
				try {

					try {

						currentMethod.invoke(bookTest);
						
						passedUnitTests++;

						System.out.println("Pass");

					} catch (InvocationTargetException ex) {
						
						failedUnitTests++;

						System.out.println(ex.getTargetException().getMessage());

					}

				} catch (Exception ex) {

					ex.printStackTrace();

				}
				
			} else {
				
				ignoredUnitTests++;
				
			}
			
		}
		
		System.out.println("Total unit tests:\t" + totalUnitTests + "\nPassed unit tests:\t" + passedUnitTests + "\nFailed unit tests:\t" + failedUnitTests + "\nIgnored unit tests:\t" + ignoredUnitTests);

	}

}

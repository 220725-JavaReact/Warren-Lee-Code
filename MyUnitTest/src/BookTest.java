
public class BookTest {

	@Test
	public void isbnShouldBeValid() {
		
		// Arrange
		String expectedISBN = "978-1-40-005292-9";
		Book myBook = new Book();
		
		// Act
		myBook.setISBN("978-1-40-005292-9");
		
		// Assert
		MyAssertion.assertEquals(expectedISBN, myBook.getISBN());
		
	}
	
	@Test
	public void arrayShouldMatch() {
		
		// Arrange
		String[] expectedArray = {"This", "is", "a", "string", "array"};
		Book myBook = new Book();
		
		// Act
		myBook.setArray(new String[] {"This", "is", "a", "string", "array"});
		
		// Assert
		MyAssertion.assertArrayEquals(expectedArray, myBook.getArray());
		
	}
	
	@Test(enable = false)
	public void someOtherMethod() {
		
	}
	
}

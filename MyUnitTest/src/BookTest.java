
public class BookTest {

	@Test
	public void isbnShouldBeValid() {
		
		// Arrange
		String expectedISBN = "324-5-47-896451-2";
		Book myBook = new Book();
		
		// Act
		myBook.setISBN("324-5-47-896451-2");
		
		// Assert
		MyAssertion.assertEquals(expectedISBN, myBook.getISBN());
		
	}
	
	@Test
	public void arrayShouldMatch() {
		
		// Arrange
		String[] expectedArray = {"This", "is", "an", "array"};
		Book myBook = new Book();
		
		// Act
		myBook.setArray(new String[] {"This", "is", "an", "array"});
		
		// Assert
		MyAssertion.assertArrayEquals(expectedArray, myBook.getArray());
		
	}
	
	@Test(enable = false)
	public void someOtherMethod() {
		
	}
	
}

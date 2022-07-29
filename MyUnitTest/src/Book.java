
public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private String[] array;
	
	public Book() {
		
		this.title = "";
		this.author = "";
		this.isbn = "";
		
	}
	
	public String getTitle() {
		
		return title;
		
	}
	
	public void setTitle(String title) {
		
		this.title = title;
		
	}
	
	public String getAuthor() {
		
		return author;
		
	}
	
	public void setAuthor(String author) {
		
		this.author = author;
		
	}
	
	public String getISBN() {
		
		return isbn;
		
	}
	
	public void setISBN(String isbn) {
		
		if (isbn.matches("^\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}$")) { // Verify that ISBN is valid and in correct format
			
			this.isbn = isbn;
			
		} else {
			
			// Throw some exception
			
		}
		
	}
	
	public void setArray(String[] array) {
		
		this.array = array;
		
	}
	
	public String[] getArray() {
		
		return array;
		
	}
	
}

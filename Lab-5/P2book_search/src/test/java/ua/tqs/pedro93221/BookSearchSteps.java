package ua.tqs.pedro93221;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ParameterType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BookSearchSteps {
	private Library library = new Library();
	List<Book> books_found;
	
	@ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
	public LocalDateTime iso8601Date(String year, String month, String day){
		return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
	}
	
	@Given("(a|another) book with the title {string}, written by {string}, published in {iso8601Date}")
	public void a_book_with_the_title_written_by_published_in_march(final String title, final String author, final LocalDateTime publish_date) {
		Book b = new Book(title, author, publish_date);
		library.addBook( b );
	}

	@When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
	public void the_customer_searches_for_books_published_between_and(final LocalDateTime from, final LocalDateTime to) {
		books_found = library.findBooks(from, to);
	}

	@Then("{int} books should have been found")
	public void books_should_have_been_found(final int n_books) {
		assertThat( books_found.size(), is( n_books ) );
	}

	@Then("Book {int} should have the title {string}")
	public void book_should_have_the_title(final int book, final String title) {
		assertThat( books_found.get(book-1).getTitle(), is( title ) );
	}

}
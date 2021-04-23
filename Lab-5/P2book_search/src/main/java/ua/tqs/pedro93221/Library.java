package ua.tqs.pedro93221;
 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
 
public class Library {
	private final List<Book> store = new ArrayList<>();
 
	public void addBook(final Book book) {
		store.add(book);
	}
 
	public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to) {
		Calendar end = Calendar.getInstance();

		end.setTime( this.convert(to) );
		end.roll(Calendar.YEAR, 1);
 
		return store.stream().filter(book -> {
			return this.convert( from ).before( this.convert( book.getPublish_date() ) ) && end.getTime().after( this.convert( book.getPublish_date() ) );
		}).sorted(Comparator.comparing(Book::getPublish_date).reversed()).collect(Collectors.toList());
	}

	public Date convert(LocalDateTime dateToConvert) {
    	return java.sql.Timestamp.valueOf(dateToConvert);
	}
}
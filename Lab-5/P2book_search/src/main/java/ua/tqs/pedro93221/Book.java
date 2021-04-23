package ua.tqs.pedro93221;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Book {
	private final String title;
	private final String author;
	private final LocalDateTime publish_date;

	public Book(String title, String author, LocalDateTime publish_date) {
		this.title = title;
		this.author = author;
		this.publish_date = publish_date;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public LocalDateTime getPublish_date() {
		return this.publish_date;
	}
	
	@Override
	public String toString() {
		return "\'" + this.title + "\' written by \'" + this.author + "\', published in " + this.publish_date + "."; 
	}
}
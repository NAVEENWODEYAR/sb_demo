package com.pivotal.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NaveenWodeyar
 * @date 04-Sept-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BATCH_NAME")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	private String bookTitle;
	
	private String bookAuthor;
	
	private Integer yearOfPublish;
	
	public BookEntity() {}

	public BookEntity(Long bookId, String bookTitle, String bookAuthor, Integer yearOfPublish) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.yearOfPublish = yearOfPublish;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Integer getYearOfPublish() {
		return yearOfPublish;
	}

	public void setYearOfPublish(Integer yearOfPublish) {
		this.yearOfPublish = yearOfPublish;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", yearOfPublish=" + yearOfPublish + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookAuthor, bookId, bookTitle, yearOfPublish);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		return Objects.equals(bookAuthor, other.bookAuthor) && Objects.equals(bookId, other.bookId)
				&& Objects.equals(bookTitle, other.bookTitle) && Objects.equals(yearOfPublish, other.yearOfPublish);
	}
	
	
}

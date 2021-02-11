package bg.proba.firstrproj.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue
  private long id;
  private String title;
  private String author;
  private String genre;
  private String notes;
  private float price;
  private boolean available;

  public long getId() {
    return id;
  }

  public Book setId(long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Book setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getAuthor() {
    return author;
  }

  public Book setAuthor(String author) {
    this.author = author;
    return this;
  }

  public String getGenre() {
    return genre;
  }

  public Book setGenre(String genre) {
    this.genre = genre;
    return this;
  }

  public String getNotes() {
    return notes;
  }

  public Book setNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public float getPrice() {
    return price;
  }

  public Book setPrice(float price) {
    this.price = price;
    return this;
  }

  public boolean isAvailable() {
    return available;
  }

  public Book setAvailable(boolean available) {
    this.available = available;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id == book.id && Float.compare(book.price, price) == 0
        && available == book.available && Objects.equals(title, book.title)
        && Objects.equals(author, book.author) && Objects
        .equals(genre, book.genre) && Objects.equals(notes, book.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, genre, notes, price, available);
  }
}

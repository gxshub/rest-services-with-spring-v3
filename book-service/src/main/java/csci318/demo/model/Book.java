package csci318.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    private String isbn;

    @Column
    private String title;

    @Column
    @ElementCollection(fetch = FetchType.EAGER, targetClass=Long.class)
    private List<Long> availableLibraries = new ArrayList<>();

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getAvailableLibraries() {
        return availableLibraries;
    }

    public void addAvailableLibrary(Long libraryId) {
        this.availableLibraries.add(libraryId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", availableLibraries=" + availableLibraries.toString() +
                '}';
    }
}

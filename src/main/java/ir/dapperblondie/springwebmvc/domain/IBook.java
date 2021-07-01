package ir.dapperblondie.springwebmvc.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class IBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ID;
    private String Name;
    private String ISBN;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> Authors;

    public IBook() {}

    public IBook(String name, String ISBN, Set<Author> authors) {
        Name = name;
        this.ISBN = ISBN;
        Authors = authors;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Set<Author> getAuthors() {
        return Authors;
    }

    public void setAuthors(Set<Author> authors) {
        Authors = authors;
    }
}

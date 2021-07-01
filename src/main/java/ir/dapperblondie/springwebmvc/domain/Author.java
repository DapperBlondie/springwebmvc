package ir.dapperblondie.springwebmvc.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "Authors")
    private Set<IBook> Books;

    public Author(){}

    public Author(String firstName, String lastName, Set<IBook> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Books = books;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<IBook> getBooks() {
        return this.Books;
    }

    public void setBooks(Set<IBook> books) {
        this.Books = books;
    }
}

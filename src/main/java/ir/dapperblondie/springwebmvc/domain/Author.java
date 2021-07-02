package ir.dapperblondie.springwebmvc.domain;

import javax.persistence.*;
import java.util.HashSet;
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

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Books = new HashSet<IBook>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return this.ID != null ? this.ID.equals(author.ID) : author.ID == null;
    }

    @Override
    public int hashCode() {
        return this.ID != null ? this.ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Books=" + Books +
                '}';
    }
}

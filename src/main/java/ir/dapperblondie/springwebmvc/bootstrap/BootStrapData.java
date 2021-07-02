package ir.dapperblondie.springwebmvc.bootstrap;

import ir.dapperblondie.springwebmvc.domain.Author;
import ir.dapperblondie.springwebmvc.domain.IBook;
import ir.dapperblondie.springwebmvc.repositories.AuthorRepository;
import ir.dapperblondie.springwebmvc.repositories.IBookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/* We implements this function to do persisting data into the H2 DataBase when we
* Initialize the App at the beginning of the Start */
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final IBookRepository iBookRepository;

    public BootStrapData(AuthorRepository authorRepository, IBookRepository iBookRepository) {
        this.authorRepository = authorRepository;
        this.iBookRepository = iBookRepository;
    }

    public void run(String... args) throws Exception {
        Author dapper = new Author("Dapper", "Blondie");
        Author johnny = new Author("Johnny", "SilverHand");

        IBook ddd = new IBook("Domain Driven Design", "34-234-134");
        IBook dps = new IBook("Design Patterns", "12-231-891");

        dapper.getBooks().add(ddd);
        johnny.getBooks().add(dps);

        ddd.getAuthors().add(dapper);
        ddd.getAuthors().add(johnny);

        this.authorRepository.save(dapper);
        this.authorRepository.save(johnny);
        System.out.println("Authors added to the DB");

        this.iBookRepository.save(ddd);
        this.iBookRepository.save(dps);
        System.out.println("Books added to the DB");
    }
}

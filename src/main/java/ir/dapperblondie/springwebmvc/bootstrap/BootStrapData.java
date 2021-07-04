package ir.dapperblondie.springwebmvc.bootstrap;

import ir.dapperblondie.springwebmvc.domain.Author;
import ir.dapperblondie.springwebmvc.domain.IBook;
import ir.dapperblondie.springwebmvc.domain.Publisher;
import ir.dapperblondie.springwebmvc.repositories.AuthorRepository;
import ir.dapperblondie.springwebmvc.repositories.IBookRepository;
import ir.dapperblondie.springwebmvc.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/* We implements this function to do persisting data into the H2 DataBase when we
 * Initialize the App at the beginning of the Start
*/
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final IBookRepository iBookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, IBookRepository iBookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.iBookRepository = iBookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Dapper Publication");
        publisher.setCity("Texas");
        publisher.setState("Texas");

        this.publisherRepository.save(publisher);

        Author dapper = new Author("Dapper", "Blondie");
        Author johnny = new Author("Johnny", "SilverHand");

        IBook ddd = new IBook("Domain Driven Design", "34-234-134");
        IBook dps = new IBook("Design Patterns", "12-231-891");

        this.iBookRepository.save(ddd);
        this.iBookRepository.save(dps);
        this.authorRepository.save(dapper);
        this.authorRepository.save(johnny);

        dapper.getBooks().add(ddd);
        johnny.getBooks().add(dps);

        ddd.getAuthors().add(dapper);
        ddd.getAuthors().add(johnny);
        dps.getAuthors().add(dapper);
        dps.getAuthors().add(johnny);

        ddd.setPublishers(publisher);
        dps.setPublishers(publisher);

        publisher.getBooks().add(ddd);
        publisher.getBooks().add(dps);

        this.publisherRepository.save(publisher);

        System.out.println("Authors added to the DB");
        System.out.println("Books added to the DB");
    }
}

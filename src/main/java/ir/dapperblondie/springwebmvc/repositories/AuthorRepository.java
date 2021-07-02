package ir.dapperblondie.springwebmvc.repositories;

import ir.dapperblondie.springwebmvc.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

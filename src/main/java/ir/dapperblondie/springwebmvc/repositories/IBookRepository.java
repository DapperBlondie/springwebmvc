package ir.dapperblondie.springwebmvc.repositories;

import ir.dapperblondie.springwebmvc.domain.IBook;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<IBook, Long> {
}

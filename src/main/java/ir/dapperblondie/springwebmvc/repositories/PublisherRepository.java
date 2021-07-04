package ir.dapperblondie.springwebmvc.repositories;

import ir.dapperblondie.springwebmvc.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

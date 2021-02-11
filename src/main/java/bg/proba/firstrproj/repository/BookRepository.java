package bg.proba.firstrproj.repository;

import bg.proba.firstrproj.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository <Book, Long> {


}

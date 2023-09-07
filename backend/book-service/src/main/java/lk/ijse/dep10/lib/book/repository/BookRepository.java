package lk.ijse.dep10.lib.book.repository;
import lk.ijse.dep10.lib.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {

}

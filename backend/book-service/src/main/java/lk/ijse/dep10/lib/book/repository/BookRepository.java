package lk.ijse.dep10.lib.book.repository;
import lk.ijse.dep10.lib.book.dto.BookDTO;
import lk.ijse.dep10.lib.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    @Query(value = "select b from Book b where b.isbn like :query or b.author like :query or b.title like :query or str(b.copies) like :query")
    List<Book> findByQuery(String query);
//    List<Book> findBooksByIsbnLikeOrTitleLikeOrAuthorLike(String query,String query2,String query3);

}

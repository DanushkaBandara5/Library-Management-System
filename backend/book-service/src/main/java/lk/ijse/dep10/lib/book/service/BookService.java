package lk.ijse.dep10.lib.book.service;

import lk.ijse.dep10.lib.book.dto.BookDTO;

import java.util.List;

public interface BookService {
    void save(BookDTO bookDTO);
    void update(BookDTO bookDTO);
    void deleteByIsbn(String isbn);
    BookDTO findByIsbn(String isbn);
    List<BookDTO> getAllBook(String query);

}

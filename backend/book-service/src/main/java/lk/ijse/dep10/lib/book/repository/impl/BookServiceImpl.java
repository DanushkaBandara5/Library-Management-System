package lk.ijse.dep10.lib.book.repository.impl;

import lk.ijse.dep10.lib.book.dto.BookDTO;
import lk.ijse.dep10.lib.book.entity.Book;
import lk.ijse.dep10.lib.book.repository.BookRepository;
import lk.ijse.dep10.lib.book.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void save(BookDTO bookDTO) {
        if (bookRepository.findById(bookDTO.getIsbn()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "isbn " + bookDTO.getIsbn() + " Already Exists");
        }
        bookRepository.save(modelMapper.map(bookDTO, Book.class));

    }

    @Override
    public void update(BookDTO bookDTO) {
        if (!bookRepository.findById(bookDTO.getIsbn()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "isbn " + bookDTO.getIsbn() + " Not Exists");
        }
        bookRepository.save(modelMapper.map(bookDTO, Book.class));

    }

    @Override
    public void deleteByIsbn(String isbn) {
        if (!bookRepository.findById(isbn).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "isbn " + isbn + " Not Exists");
        }
        bookRepository.deleteById(isbn);

    }

    @Override
    public BookDTO findByIsbn(String isbn) {
        return bookRepository.findById(isbn).map(book -> modelMapper.map(book, BookDTO.class)).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "isbn not exist"));
    }

    @Override
    public List<BookDTO> getAllBook(String query) {
       return bookRepository.findBooksByQuery(query).stream().map(book->modelMapper.map(book,BookDTO.class)).collect(Collectors.toList());
    }
}

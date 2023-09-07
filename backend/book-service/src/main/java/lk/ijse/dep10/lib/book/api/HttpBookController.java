package lk.ijse.dep10.lib.book.api;

import lk.ijse.dep10.lib.book.dto.BookDTO;
import lk.ijse.dep10.lib.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/books")
public class HttpBookController {
    private final BookService bookService;

    public HttpBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void SaveBook(@RequestBody @Valid BookDTO bookDTO) {
        bookService.save(bookDTO);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{isbn}")
    public void updateBook(@RequestBody @Validated BookDTO bookDTO, @PathVariable String isbn) {
        bookDTO.setIsbn(isbn);
        bookService.update(bookDTO);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn){
        bookService.deleteByIsbn(isbn);
    }
    @GetMapping("/{isbn}")
    public BookDTO getByIbn(@PathVariable String isbn){
       return bookService.findByIsbn(isbn);
    }
    @GetMapping
    public List<BookDTO> findBooks(@RequestParam(name="q",required = false) String query){

        if(query==null){
            query=" ";
        }
        query="%"+query+"%";
       return bookService.getAllBook(query);
    }
}

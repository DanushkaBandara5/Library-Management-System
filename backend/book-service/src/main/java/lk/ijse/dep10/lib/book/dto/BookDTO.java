package lk.ijse.dep10.lib.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private int copies;
}

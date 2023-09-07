package lk.ijse.dep10.lib.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.pool.TypePool;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @NotBlank(message = "ISBN can't be empty")
    private String isbn;
    @NotBlank(message = "Title can't be empty")
    private String title;
    @NotBlank(message = "Author can't be empty")
    @Pattern(regexp = "^[A-z ]{3,}$")
    private String author;
    @NotNull
    @PositiveOrZero
    private int copies;
}

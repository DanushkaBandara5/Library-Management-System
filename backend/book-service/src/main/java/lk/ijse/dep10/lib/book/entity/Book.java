package lk.ijse.dep10.lib.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(columnDefinition = "varchar(20)")
    private String isbn;
    @Column(nullable = false,columnDefinition = "varchar(200)")
    private String title;
    @Column(nullable = false,columnDefinition = "varchar(100)")
    private String author;
    @Column(nullable = false)
    private int copies;
}

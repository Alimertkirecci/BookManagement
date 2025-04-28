package com.example.restcontrollers;

import com.example.entities.Book;
import com.example.services.BookService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("book")
@Validated
public class BookRestController {
    final BookService bookService;



    @PostMapping("save")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }
    @GetMapping("/list")
    public Page<Book> getBook(
            @RequestParam(defaultValue = "0") int page,
            @Min(5) @Max(20) @RequestParam(defaultValue = "0") int size
    )
    {
        return bookService.bookList(page, size);
    }

    @DeleteMapping("delete/{bid}")
    public ResponseEntity delete(@PathVariable Long bid) {
        return bookService.deleteProduct(bid);
    }


    //UPDATE YÖNTEMİ İÇİN PUT KULLANIYOURZ.
    @PutMapping("update")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return bookService.productUpdate(book);
    }

    @GetMapping("search")
    public Page<Book> searchBooks(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return bookService.booksearch(title, PageRequest.of(page, size));
    }

}

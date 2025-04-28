package com.example.services;

import com.example.entities.Book;
import com.example.entities.Customer;
import com.example.repositories.BookRepository;
import com.example.repositories.CustomerRepository;
import com.example.utils.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {


    final BookRepository bookRepository;
    final HttpServletRequest request;
    final CustomerRepository customerRepository;

    public Book save (Book book) {
        Customer customer = (Customer) request.getSession().getAttribute("user");//Veritabanında kitap ekleyenin kim olduğunu tutyoruz.session!
        book.setCid(customer.getCid());
        bookRepository.save(book);
        return book;
    }

    public Page<Book> bookList(int page, int size) {
        Customer customer = (Customer) request.getSession().getAttribute("user");
        Pageable pageable = PageRequest.of( page, size);
        Page<Book> books = bookRepository.findByCidEquals(customer.getCid(),pageable);
        return books;
    }

    public ResponseEntity deleteProduct(Long pid) {
        ResponseEntity res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (pid == null || pid < 1) {
            return res;
        }

        Optional<Book> productOptional = bookRepository.findById(pid);
        if (productOptional.isPresent()) {
            Book book = productOptional.get();

            Customer customer = (Customer) request.getSession().getAttribute("user");

            if (book.getCid().equals(customer.getCid())) {
                bookRepository.deleteById(pid);
                res = new ResponseEntity<>(HttpStatus.OK);
            } else {

                res = new ResponseEntity<>("Error! Dont Have Book",HttpStatus.FORBIDDEN);
            }
        }

        return res;
    }

    //güncelleme
    //Method içinde Hata Yakalatmak için REsponse entity döndermek gerekir.
    //normalde product dönderiyorduk.
    public ResponseEntity<Book> productUpdate(Book book) {

        if (book.getBid() == null || book.getBid() < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Book> existingBookOptional = bookRepository.findById(book.getBid());

        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            Customer loggedInCustomer = (Customer) request.getSession().getAttribute("user");

            // Kitabın şu anda oturum açmış kullanıcı tarafından oluşturulup oluşturulmadığını kontrol edin
            if (existingBook.getCid().equals(loggedInCustomer.getCid())) {
                book.setCid(loggedInCustomer.getCid()); // son değiştiriciyi yansıtacak şekilde güncellemeye devam edin
                bookRepository.saveAndFlush(book);
                return new ResponseEntity<>(book, HttpStatus.OK);
            } else {

                return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);//yetkisiz
            }
        } else {

            return new ResponseEntity<>( HttpStatus.NOT_FOUND);//BULUNAMADI
        }
    }

    public Page<Book> booksearch(String title, Pageable pageable) {
        return bookRepository.findByTitleContainingIgnoreCase(title, pageable);
    }
}

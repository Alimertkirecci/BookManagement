package com.example.repositories;

import com.example.entities.Book;
import com.example.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
  Page<Book> findByTitleContainingIgnoreCase(String title,  org.springframework.data.domain.Pageable pageable); // Pagable düzenini kontrol et

  Page<Book> findByCidEquals(Long cid, Pageable pageable) ;
}
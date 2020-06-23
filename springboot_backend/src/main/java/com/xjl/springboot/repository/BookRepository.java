package com.xjl.springboot.repository;

import com.xjl.springboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}

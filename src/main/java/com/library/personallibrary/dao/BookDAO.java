package com.library.personallibrary.dao;

import com.library.personallibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book,Integer> {

    @Query("SELECT b from Book b WHERE b.bookName=?1")
    Book findByBookName(String bookName);
}

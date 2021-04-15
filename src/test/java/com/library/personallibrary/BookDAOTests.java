package com.library.personallibrary;


import com.library.personallibrary.dao.BookDAO;
import com.library.personallibrary.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

public class BookDAOTests {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddBook(){
        Book book = new Book();
        book.setBookName("Good Omens");
        book.setAuthorName("Neil Gaiman");
        book.setCoAuthorName("Terry Pratchett");
        book.setAvailability("Owned");
        book.setPrice(260.0f);
        Book savedBook = bookDAO.save(book);
        Book existingBook = entityManager.find(Book.class, savedBook.getBookid());
        assertThat(existingBook.getBookName()).isEqualTo(book.getBookName());
    }
    @Test
    public void testFindByBookName(){
        String bookName = "Good Omens";
        Book book = bookDAO.findByBookName(bookName);
        assertThat(book).isNotNull();
    }
}

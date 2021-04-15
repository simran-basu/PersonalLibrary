package com.library.personallibrary.service;

import com.library.personallibrary.api.BookResource;
import com.library.personallibrary.dao.BookDAO;
import com.library.personallibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BookService implements UserDetailsService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public UserDetails loadUserByUsername(String bookName) throws UsernameNotFoundException {
        Book book = bookDAO.findByBookName(bookName);
        if(book == null)
        {
            throw new UsernameNotFoundException("Book not found");
        }
        return new BookResource(book);
    }
}

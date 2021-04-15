package com.library.personallibrary.api;

import com.library.personallibrary.model.Book;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class BookResource implements UserDetails {
    private Book book;
    public BookResource(Book book){ this.book = book; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }

    @Override
    public String getPassword() { return null; }

    @Override
    public String getUsername() { return book.getBookName(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    public String getBookandAuthor()
    {
        return book.getBookName()+" by "+book.getAuthorName();
    }
}

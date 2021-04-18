package com.library.personallibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int bookid;
    @Column(name = "bookName", nullable = false, length = 20)
    @JsonProperty("bookName")
    private String bookName;
    @Column(name = "authorName", nullable = false, length = 40)
    @JsonProperty("authorName")
    private String authorName;
    @Column(name = "coAuthorName", nullable = true, length = 40)
    @JsonProperty("coAuthorName")
    private String coAuthorName;
    @Column(nullable = false, unique = true, length = 30)
    @JsonProperty("availability")
    private String availability;
    @Column(nullable = true)
    private Float price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable=false)
    @JsonIgnore
    private User user;

    public int getBookid() { return bookid; }

    public void setBookid(int bookid) { this.bookid = bookid; }

    public String getBookName() { return bookName; }

    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getAuthorName() { return authorName; }

    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getAvailability() { return availability; }

    public void setAvailability(String availability) { this.availability = availability; }

    public Float getPrice() { return price; }

    public void setPrice(Float price) { this.price = price; }

    public String getCoAuthorName() { return coAuthorName; }

    public void setCoAuthorName(String coAuthorName) { this.coAuthorName = coAuthorName; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}

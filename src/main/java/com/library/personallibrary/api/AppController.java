package com.library.personallibrary.api;

import com.library.personallibrary.dao.BookDAO;
import com.library.personallibrary.dao.UserDAO;
import com.library.personallibrary.model.Book;
import com.library.personallibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserDAO userDAO;
    private BookDAO bookDAO;
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDAO.save(user);
        return "register_success";
    }
    @GetMapping("/list")
    public String getLists(Model model){
        return "option";
    }
    @GetMapping("/list_users")
    public String viewUsersList(Model model){
        List<User> userList = userDAO.findAll();
        model.addAttribute("userList", userList);
        return "users";
    }
    @GetMapping("/list_books")
    public String viewBooks(Model model){
        /*List<Book> bookList = bookDAO.findAll();
        model.addAttribute("bookList", bookList);*/
        return "books";
    }
    @GetMapping("/add_book")
    public String addBook(Model model)
    {
        model.addAttribute("book",new Book());
        return "book_form";
    }
    @GetMapping("/adding_book")
    public String newBook(Book book){
        bookDAO.save(book);
        return "book_added";
    }
}

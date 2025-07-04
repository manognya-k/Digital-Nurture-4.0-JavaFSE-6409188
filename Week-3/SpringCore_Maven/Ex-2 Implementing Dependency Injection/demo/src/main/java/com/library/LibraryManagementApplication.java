package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test adding a book
        bookService.addBook("The Hobbit by J.R.R. Tolkien");
    }
}

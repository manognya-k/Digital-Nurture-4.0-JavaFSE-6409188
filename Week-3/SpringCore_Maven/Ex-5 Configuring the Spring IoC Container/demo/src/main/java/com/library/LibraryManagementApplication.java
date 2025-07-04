package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load Spring context from XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration
        bookService.addBook("Effective Java by Joshua Bloch");
    }
}

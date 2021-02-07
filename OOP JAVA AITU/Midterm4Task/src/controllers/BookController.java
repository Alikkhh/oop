package controllers;

import entities.Book;
import repositories.interfaces.IBookRepository;

public class BookController {
    private final IBookRepository bookRepository;

    public BookController(IBookRepository bookRepository){
       this.bookRepository=bookRepository;
    }

    public String searchBookByName(String name){
        String result = bookRepository.searchBookByName(name).toString();

        return result;
    }

    public String getBookById(int id){
        String result = bookRepository.getBookById(id).toString();

        return result;
    }

    public String addBook(String name, double price, String authorName){
        boolean added = bookRepository.addBook(new Book(name,price,authorName));

        if (added){
            return "Book was added!";
        }
        return "Book was not added!";
    }

    public String removeBookById(int id){
        boolean removed = bookRepository.removeBookBId(id);

        if (removed){
            return "Book was removed";
        }
        return "Book was not added";
    }


}

package repositories.interfaces;

import entities.Book;

import java.util.ArrayList;

public interface IBookRepository {
    public ArrayList<Book> searchBookByName(String name);
    public Book getBookById(int id);
    public boolean addBook(Book book);
    public boolean removeBookBId(int id);
}

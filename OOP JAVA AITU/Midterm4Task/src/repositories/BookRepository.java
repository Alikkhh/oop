package repositories;

import entities.Book;
import data.interfaces.IDBManager;
import repositories.interfaces.IBookRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRepository implements IBookRepository {

    private final IDBManager dbManager;

    public BookRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Book> searchBookByName(String name) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Books WHERE name LIKE '%" + name + "%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Book> books = new ArrayList<>();

            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getDouble("price"), resultSet.getString("authorName"));

            books.add(book);
            }

            return books;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Book book = new Book();

            if(resultSet.next()){
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthorName(resultSet.getString("authorName"));

                return book;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books(name,price,authorName) VALUES(?,?,?)");

            preparedStatement.setString(1,book.getName());
            preparedStatement.setDouble(2,book.getPrice());
            preparedStatement.setString(3,book.getAuthorName());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeBookBId(int id) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE id=?");

            preparedStatement.setInt(1,id);

            preparedStatement.execute();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

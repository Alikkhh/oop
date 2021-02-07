import controllers.BookController;
import data.DBManager;
import data.interfaces.IDBManager;
import repositories.BookRepository;
import repositories.interfaces.IBookRepository;

public class Main {
    public static void main(String[] args){
        IDBManager dbManager = new DBManager();
        IBookRepository bookRepository = new BookRepository(dbManager);
        BookController bookController = new BookController(bookRepository);
        MyApp myApp = new MyApp(bookController);
        myApp.start();
    }
}
